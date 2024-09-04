package za.ac.cput.domain;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * CartController.java
 *
 * @author Rethabile Ntsekhe
 * Student Num: 220455430
 * @date 23-Jul-24
 */

@Entity
public class Cart implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cartId;
    private long userId;
    private LocalDate created_at;
    private LocalDate updated_at;

    public Cart() {
    }

    public Cart(Builder builder) {
        this.cartId = builder.cartId;
        this.userId = builder.userId;
        this.created_at = builder.created_at;
        this.updated_at = builder.updated_at;
    }

    public long getCart_id() {
        return cartId;
    }

    public long getUser_id() {
        return userId;
    }

    public LocalDate getCreated_at() {
        return created_at;
    }

    public LocalDate getUpdated_at() {
        return updated_at;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cart cart)) return false;

        if (getCart_id() != cart.getCart_id()) return false;
        if (getUser_id() != cart.getUser_id()) return false;
        if (getCreated_at() != null ? !getCreated_at().equals(cart.getCreated_at()) : cart.getCreated_at() != null)
            return false;
        return getUpdated_at() != null ? getUpdated_at().equals(cart.getUpdated_at()) : cart.getUpdated_at() == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (getCart_id() ^ (getCart_id() >>> 32));
        result = 31 * result + (int) (getUser_id() ^ (getUser_id() >>> 32));
        result = 31 * result + (getCreated_at() != null ? getCreated_at().hashCode() : 0);
        result = 31 * result + (getUpdated_at() != null ? getUpdated_at().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "Cart ID: " + cartId +
                ", USER ID: " + userId +
                ", CREATED AT: " + created_at +
                ", UPDATED AT: " + updated_at +
                '}';
    }

    public static class Builder {
        private long cartId;
        private long userId;
        private LocalDate created_at;
        private LocalDate updated_at;

        public Builder setCart_id(long cart_id) {
            this.cartId = cart_id;
            return this;
        }

        public Builder setUser_id(long user_id) {
            this.userId = user_id;
            return this;
        }

        public Builder setCreated_at(LocalDate created_at) {
            this.created_at = created_at;
            return this;
        }

        public Builder setUpdated_at(LocalDate updated_at) {
            this.updated_at = updated_at;
            return this;
        }

        public Builder copy(Cart cart) {
            this.cartId = cart.getCart_id();
            this.userId = cart.getUser_id();
            this.created_at = cart.getCreated_at();
            this.updated_at = cart.getUpdated_at();
            return this;
        }

        public Cart build() {
            return new Cart(this);
        }
    }
}

