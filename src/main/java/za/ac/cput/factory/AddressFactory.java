package za.ac.cput.factory;

import za.ac.cput.domain.Addresses;
import za.ac.cput.domain.Users;
import za.ac.cput.util.Helper;

import java.time.LocalDate;

/**
 * AddressFactory.java
 *
 * @author Rethabile Ntsekhe
 * Student Num: 220455430
 * @date 26-Jul-24
 */

public class AddressFactory {
    public static Addresses buildAddress(long address_id, long user_id, String address_line1,
                                         String address_line2, String city, String province,
                                         String postal_code, String country,
                                         LocalDate created_at, LocalDate updated_at) {
        if (Helper.isNullOrEmpty(address_line1) ||
                Helper.isNullOrEmpty(city) ||
                Helper.isNullOrEmpty(province) ||
                Helper.isNullOrEmpty(postal_code) ||
                Helper.isNullOrEmpty(country)
        ) return null;

        return new Addresses.Builder()
                .setAddress_id(address_id)
                .setUser_id(user_id)
                .setAddress_line1(address_line1)
                .setAddress_line2(address_line2)
                .setCity(city)
                .setProvince(province)
                .setPostal_code(postal_code)
                .setCountry(country)
                .setCreated_at(created_at)
                .setUpdated_at(updated_at)
                .build();
    }
}
