package za.ac.cput.factory;

import za.ac.cput.domain.Wishlists;
import za.ac.cput.util.Helper;

import java.time.LocalDate;

/**
 * WishlistFactory.java
 *
 * @author Rethabile Ntsekhe
 * Student Num: 220455430
 * @date 26-Jul-24
 */

public class WishlistFactory {
    public static Wishlists buildWishlist(long wishlist_id, long user_id, LocalDate created_at) {
        if (Helper.isNullOrEmpty(user_id) ||
                Helper.isNullOrEmpty(user_id)
        ) return null;

        return new Wishlists.Builder()
                .setWishlist_id(wishlist_id)
                .setUser_id(user_id)
                .setCreated_at(created_at)
                .build();
    }
}
