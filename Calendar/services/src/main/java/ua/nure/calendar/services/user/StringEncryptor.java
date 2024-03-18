package ua.nure.calendar.services.user;

import com.google.common.base.Charsets;
import com.google.common.hash.Hashing;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Class for string encrypting.
 */
class StringEncryptor {

    private static final String SECRET_WORD = "s967dft9s76dtf67sdf";

    private StringEncryptor() {
    }

    static String encrypt(String text) {
        checkNotNull(text);

        return Hashing.sha256()
                .hashString(text + SECRET_WORD, Charsets.UTF_8)
                .toString();
    }
}
