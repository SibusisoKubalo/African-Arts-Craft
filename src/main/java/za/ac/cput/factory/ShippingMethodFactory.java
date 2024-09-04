package za.ac.cput.factory;

import za.ac.cput.domain.Shipping_Methods;
import za.ac.cput.util.Helper;

/**
 * ShippingMethodFactory.java
 *
 * @author Rethabile Ntsekhe
 * Student Num: 220455430
 * @date 26-Jul-24
 */

public class ShippingMethodFactory {
    public static Shipping_Methods buildShippingMethod(long shipping_method_id, String name,
                                                       String description, double cost,
                                                       String delivery_time) {
        if (Helper.isNullOrEmpty(name) ||
                Helper.isDoubleNullOrEmpty(cost)
        ) return null;

        return new Shipping_Methods.Builder()
                .setShipping_method_id(shipping_method_id)
                .setName(name)
                .setDescription(description)
                .setCost(cost)
                .setDelivery_time(delivery_time)
                .build();
    }
}
