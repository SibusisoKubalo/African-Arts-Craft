package za.ac.cput.domain;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * Cart_Items.java
 *
 * @author Rethabile Ntsekhe
 * Student Num: 220455430
 * @date 23-Jul-24
 */


@Entity
public class Cart_Items implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cart_item_id;
    private long cartId;
    private long productId;
    private int quantity;

    public Cart_Items() {
    }

    public Cart_Items(Builder builder) {
        this.cart_item_id = builder.cart_item_id;
        this.cartId = builder.cartId;
        this.productId = builder.product_id;
        this.quantity = builder.quantity;
    }

    public long getCart_item_id() {
        return cart_item_id;
    }

    public long getCart_id() {

        return cartId;
    }

    public long getProduct_id() {

        return productId;
    }

    public int getQuantity() {

        return quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cart_Items cartItems = (Cart_Items) o;
        return cart_item_id == cartItems.cart_item_id && cartId == cartItems.cartId && productId == cartItems.productId && quantity == cartItems.quantity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cart_item_id, cartId, productId, quantity);
    }

    @Override
    public String toString() {
        return "Cart_Items{" +
                "Cart Item ID: " + cart_item_id +
                ", CART ID: " + cartId +
                ", PRODUCT ID: " + productId +
                ", QUANTITY: " + quantity +
                '}';
    }

    public static class Builder {
        private long cart_item_id;
        private long cartId;
        private long product_id;
        private int quantity;

        public Builder setCart_item_id(long cart_item_id) {
            this.cart_item_id = cart_item_id;
            return this;
        }

        public Builder setCart_id(long cart_id) {
            this.cartId = cart_id;
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

        public Builder copy(Cart_Items cart_items) {
            this.cart_item_id = cart_items.getCart_item_id();
            this.cartId = cart_items.getCart_id();
            this.product_id = cart_items.getProduct_id();
            this.quantity = cart_items.getQuantity();
            return this;
        }

        public Cart_Items build() {
            return new Cart_Items(this);
        }
    }
}

