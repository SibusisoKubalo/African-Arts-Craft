package za.ac.cput.factory;

import za.ac.cput.domain.Order_Items;
import za.ac.cput.util.Helper;

/**
 * OrderItemFactory.java
 *
 * @author Rethabile Ntsekhe
 * Student Num: 220455430
 * @date 26-Jul-24
 */

public class OrderItemFactory {
    public static Order_Items buildOrderItem(long order_item_id, long order_id, long product_id,
                                             int quantity, double price) {
        if (Helper.isDoubleNullOrEmpty(price) ||
                Helper.isNullOrEmpty(quantity)
        ) return null;

        return new Order_Items.Builder()
                .setOrder_item_id(order_item_id)
                .setOrder_id(order_id)
                .setProduct_id(product_id)
                .setQuantity(quantity)
                .setPrice(price)
                .build();
    }
}
