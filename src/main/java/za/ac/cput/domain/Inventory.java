package za.ac.cput.domain;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Inventory.java
 *
 * @author Rethabile Ntsekhe
 * Student Num: 220455430
 * @date 23-Jul-24
 */


@Entity
public class Inventory implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long inventory_id;
    private long product_id;
    private int quantity;
    private String vendor_location;
    private LocalDate last_updated;

    public Inventory() {
    }

    public Inventory(Builder builder) {
        this.inventory_id = builder.inventory_id;
        this.product_id = builder.product_id;
        this.quantity = builder.quantity;
        this.vendor_location = builder.vendor_location;
        this.last_updated = builder.last_updated;
    }

    public long getInventory_id() {
        return inventory_id;
    }

    public long getProduct_id() {
        return product_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getVendor_location() {
        return vendor_location;
    }

    public LocalDate getLast_updated() {
        return last_updated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Inventory inventory)) return false;

        if (getInventory_id() != inventory.getInventory_id()) return false;
        if (getProduct_id() != inventory.getProduct_id()) return false;
        if (getQuantity() != inventory.getQuantity()) return false;
        if (getVendor_location() != null ? !getVendor_location().equals(inventory.getVendor_location()) : inventory.getVendor_location() != null)
            return false;
        return getLast_updated() != null ? getLast_updated().equals(inventory.getLast_updated()) : inventory.getLast_updated() == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (getInventory_id() ^ (getInventory_id() >>> 32));
        result = 31 * result + (int) (getProduct_id() ^ (getProduct_id() >>> 32));
        result = 31 * result + getQuantity();
        result = 31 * result + (getVendor_location() != null ? getVendor_location().hashCode() : 0);
        result = 31 * result + (getLast_updated() != null ? getLast_updated().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "Inventory ID: " + inventory_id +
                ", PRODUCT ID: " + product_id +
                ", QUANTITY: " + quantity +
                ", VENDOR LOCATION: '" + vendor_location + '\'' +
                ", LAST UPDATED: " + last_updated +
                '}';
    }

    public static class Builder {
        private long inventory_id;
        private long product_id;
        private int quantity;
        private String vendor_location;
        private LocalDate last_updated;

        public Builder setInventory_id(long inventory_id) {
            this.inventory_id = inventory_id;
            return this;
        }

        public Builder setProduct_id(long product_id) {
            this.product_id = product_id;
            return this;
        }

        public Builder setQuantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public Builder setVendor_location(String vendor_location) {
            this.vendor_location = vendor_location;
            return this;
        }

        public Builder setLast_updated(LocalDate last_updated) {
            this.last_updated = last_updated;
            return this;
        }

        public Builder copy(Inventory inventory) {
            this.inventory_id = inventory.getInventory_id();
            this.product_id = inventory.getProduct_id();
            this.quantity = inventory.getQuantity();
            this.vendor_location = inventory.getVendor_location();
            this.last_updated = inventory.getLast_updated();
            return this;
        }

        public Inventory build() {
            return new Inventory(this);
        }
    }
}

