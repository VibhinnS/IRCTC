package org.example.utils;

import org.example.entities.User;
import org.mindrot.jbcrypt.BCrypt;

import java.util.Objects;

public class UserServiceUtil {
    public static String hashPassword(String unhashedPassword) {
        return BCrypt.hashpw(unhashedPassword, BCrypt.gensalt());
    }

    public static boolean checkPassword(String unhashedPassword, User user) {
        String hashedPassword = user.getHashedPassword();
        return BCrypt.checkpw(unhashedPassword, hashedPassword);
    }
}
