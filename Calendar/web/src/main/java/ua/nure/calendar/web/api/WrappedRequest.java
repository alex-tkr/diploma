package ua.nure.calendar.web.api;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import spark.Request;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Wrapper for {@link Request} to provide work with body as {@link JsonEntity}.
 */
public class WrappedRequest {

    private final Gson gson = new Gson();

    private final JsonEntity jsonBody;
    private final Request request;

    public WrappedRequest(Request request) {
        checkNotNull(request);

        if (Objects.equals(request.contentType(), "application/json")) {
            var jsonObject =
                    Objects.requireNonNullElseGet(gson.fromJson(request.body(), JsonObject.class),
                            JsonObject::new);
            jsonBody = new JsonEntity(jsonObject);
        } else {
            jsonBody = new JsonEntity(new JsonObject());
        }

        this.request = request;
    }

    /**
     * Returns hTTP body representation as {@link JsonEntity}.
     */
    public JsonEntity jsonBody() {
        return jsonBody;
    }

    /**
     * Returns the raw HttpServletRequest object.
     */
    public HttpServletRequest raw() {
        return request.raw();
    }

    /**
     * Returns the value of the provided header.
     *
     * @param header
     *         HTTP request header name.
     */
    public String headers(String header) {
        checkNotNull(header);
        return request.headers(header);
    }

    /**
     * Returns the value of the provided route pattern parameter.
     * Example: parameter 'name' from the following pattern: (get '/hello/:name')
     *
     * @param param
     *         HTTP parameter name.
     * @return The value of the provided parameter.
     */
    public String params(String param) {
        checkNotNull(param);
        return request.params(param);
    }

    /**
     * Sets an attribute on the request.
     *
     * @param attribute
     *         The attribute.
     * @param value
     *         The attribute value.
     */
    public void attribute(String attribute,
                          Object value) {
        checkNotNull(attribute);
        checkNotNull(value);

        request.attribute(attribute, value);
    }
}
