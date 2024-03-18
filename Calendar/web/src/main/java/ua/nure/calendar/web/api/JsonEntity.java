package ua.nure.calendar.web.api;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.function.Function;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Wrapper for {@link JsonObject} to make work with fields directly, without {@link JsonElement}.
 * Throws {@link JsonEntityValidationException} if JSON object don't have fields with given names
 * or field values can't be converted into correct types.
 */
public class JsonEntity {

    private final JsonObject jsonObject;

    public JsonEntity(JsonObject jsonObject) {
        this.jsonObject = checkNotNull(jsonObject);
    }

    /**
     * Returns JSON object's field by given name as {@link String}.
     *
     * @param fieldName - The JSON object field name.
     * @return JSON object's field as {@link String}.
     * @throws JsonEntityValidationException If JSON object don't have field with given name
     *                                       or field value can't be converted into {@link String}.
     */
    public String getAsString(String fieldName) throws JsonEntityValidationException {
        checkNotNull(fieldName);
        return get(fieldName, JsonElement::getAsString);
    }

    /**
     * Returns JSON object's field by given name as {@link Integer}.
     *
     * @param fieldName - The JSON object field name.
     * @return JSON object's field as {@link Integer}.
     * @throws JsonEntityValidationException If JSON object don't have field with given name
     *                                       or field value can't be converted into {@link Integer}.
     */
    public Integer getAsInteger(String fieldName) throws JsonEntityValidationException {
        checkNotNull(fieldName);
        return get(fieldName, JsonElement::getAsInt);
    }

    private <T> T get(String fieldName, Function<JsonElement, T> getFunction)
            throws JsonEntityValidationException {

        if (!jsonObject.has(fieldName)) {
            throw new JsonEntityValidationException("Field " + fieldName + " not found in JSON");
        }

        try {

            return getFunction.apply(jsonObject.get(fieldName));

        } catch (UnsupportedOperationException | IllegalStateException exception) {

            throw new JsonEntityValidationException("Field " + fieldName + " has incorrect type.");

        }
    }
}
