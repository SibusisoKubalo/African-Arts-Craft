package za.ac.cput.factory;

import za.ac.cput.domain.Wishlist_Items;
import za.ac.cput.util.Helper;

/**
 * WishlistItemFactory.java
 *
 * @author Rethabile Ntsekhe
 * Student Num: 220455430
 * @date 26-Jul-24
 */

public class WishlistItemFactory {
    public static Wishlist_Items buildWishlistItem(long wishlist_item_id, long wishlist_id, long product_id) {
        if (Helper.isNullOrEmpty(wishlist_id) ||
                Helper.isNullOrEmpty(product_id)
        ) return null;

        return new Wishlist_Items.Builder()
                .setWishlist_item_id(wishlist_item_id)
                .setWishlist_id(wishlist_id)
                .setProduct_id(product_id)
                .build();
    }
}
