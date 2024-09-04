package za.ac.cput.factory;

import za.ac.cput.domain.Users;
import za.ac.cput.util.Helper;

import java.time.LocalDate;

/**
 * Userfactory.java
 *
 * @author Rethabile Ntsekhe
 * Student Num: 220455430
 * @date 24-Jul-24
 */

public class Userfactory {

    public static Users buildUser(long user_id, String username, String password,
                                  String email, String first_name, String last_name,
                                  LocalDate created_at, LocalDate updated_at) {

        if (Helper.isNullOrEmpty(username) ||
                Helper.isNullOrEmpty(password) ||
                Helper.isNullOrEmpty(first_name) ||
                Helper.isNullOrEmpty(last_name)
        ) return null;

        String regex = "^(.+)@(\\S+)$";
        if (!Helper.isEmailValid(email, regex) ||
                Helper.isNullOrEmpty(email)
        ) return null;

        return new Users.Builder()
                .setUser_id(user_id)
                .setUsername(username)
                .setPassword(password)
                .setEmail(email)
                .setFirst_name(first_name)
                .setLast_name(last_name)
                .setCreated_at(created_at)
                .setUpdated_at(updated_at)
                .build();
    }
}
