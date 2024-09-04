package za.ac.cput.factory;

import za.ac.cput.domain.Inventory;
import za.ac.cput.util.Helper;

/**
 * InventoryFactory.java
 *
 * @author Rethabile Ntsekhe
 * Student Num: 220455430
 * @date 26-Jul-24
 */

public class InventoryFactory {
    public static Inventory buildInventory(long inventory_id, long product_id, int quantity, String vendor_location) {
        if (Helper.isNullOrEmpty(quantity) ||
                Helper.isNullOrEmpty(vendor_location)
        )
            return null;

        return new Inventory.Builder()
                .setInventory_id(inventory_id)
                .setProduct_id(product_id)
                .setQuantity(quantity)
                .setVendor_location(vendor_location)
                .build();
    }
}
