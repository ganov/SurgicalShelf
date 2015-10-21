package utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * PasswordUtils Class help to deal with managing Password
 * Created by ganovelli on 21/10/2015.
 */
public final class PasswordUtils {

    public static byte[] getSha512(String value) {
        try {
            return MessageDigest.getInstance("SHA-512").digest(value.getBytes("UTF-8"));
        }
        catch (NoSuchAlgorithmException |UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
}
