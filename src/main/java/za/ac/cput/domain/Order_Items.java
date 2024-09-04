package za.ac.cput.domain;

import jakarta.persistence.*;
import java.io.Serializable;

/**
 * Order_Items.java
 *
 * @author Rethabile Ntsekhe
 * Student Num: 220455430
 * @date 23-Jul-24
 */

@Entity
public class Order_Items implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long order_item_id;
    private long order_id;
    private long product_id;
    private int quantity;
    private double price;

    public Order_Items() {
    }

    public Order_Items(Builder builder) {
        this.order_item_id = builder.order_item_id;
        this.order_id = builder.order_id;
        this.product_id = builder.product_id;
        this.quantity = builder.quantity;
        this.price = builder.price;
    }

    public long getOrder_item_id() {
        return order_item_id;
    }

    public long getOrder_id() {
        return order_id;
    }

    public long getProduct_id() {
        return product_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Order_Items{" +
                "Order Item ID: " + order_item_id +
                ", ORDER ID: " + order_id +
                ", PRODUCT ID: " + product_id +
                ", QUANTITY: " + quantity +
                ", PRICE: " + price +
                '}';
    }

    public static class Builder {
        private long order_item_id;
        private long order_id;
        private long product_id;
        private int quantity;
        private double price;

        public Builder setOrder_item_id(long order_item_id) {
            this.order_item_id = order_item_id;
            return this;
        }

        public Builder setOrder_id(long order_id) {
            this.order_id = order_id;
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

        public Builder setPrice(double price) {
            this.price = price;
            return this;
        }

        public Builder copy(Order_Items order_items) {
            this.order_item_id = order_items.getOrder_item_id();
            this.order_id = order_items.getOrder_id();
            this.product_id = order_items.getProduct_id();
            this.quantity = order_items.getQuantity();
            this.price = order_items.getPrice();
            return this;
        }

        public Order_Items build() {
            return new Order_Items(this);
        }
    }
}

