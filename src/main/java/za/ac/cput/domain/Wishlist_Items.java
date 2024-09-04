package za.ac.cput.domain;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Wishlist_Items.java
 *
 * @author Rethabile Ntsekhe
 * Student Num: 220455430
 * @date 23-Jul-24
 */


@Entity
public class Wishlist_Items implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long wishlist_item_id;
    private long wishlist_id;
    private long product_id;
    private LocalDate added_at;

    public Wishlist_Items() {
    }

    public Wishlist_Items(Builder builder) {
        this.wishlist_item_id = builder.wishlist_item_id;
        this.wishlist_id = builder.wishlist_id;
        this.product_id = builder.product_id;
        this.added_at = builder.added_at;
    }

    public long getWishlist_item_id() {
        return wishlist_item_id;
    }

    public long getWishlist_id() {
        return wishlist_id;
    }

    public long getProduct_id() {
        return product_id;
    }

    public LocalDate getAdded_at() {
        return added_at;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Wishlist_Items that)) return false;

        if (getWishlist_item_id() != that.getWishlist_item_id()) return false;
        if (getWishlist_id() != that.getWishlist_id()) return false;
        if (getProduct_id() != that.getProduct_id()) return false;
        return getAdded_at() != null ? getAdded_at().equals(that.getAdded_at()) : that.getAdded_at() == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (getWishlist_item_id() ^ (getWishlist_item_id() >>> 32));
        result = 31 * result + (int) (getWishlist_id() ^ (getWishlist_id() >>> 32));
        result = 31 * result + (int) (getProduct_id() ^ (getProduct_id() >>> 32));
        result = 31 * result + (getAdded_at() != null ? getAdded_at().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Wishlist_Items{" +
                "Wishlist Item ID: " + wishlist_item_id +
                ", WISHLIST ID: " + wishlist_id +
                ", PRODUCT ID: " + product_id +
                ", ADDED AT: " + added_at +
                '}';
    }

    public static class Builder {
        private long wishlist_item_id;
        private long wishlist_id;
        private long product_id;
        private LocalDate added_at;

        public Builder setWishlist_item_id(long wishlist_item_id) {
            this.wishlist_item_id = wishlist_item_id;
            return this;
        }

        public Builder setWishlist_id(long wishlist_id) {
            this.wishlist_id = wishlist_id;
            return this;
        }

        public Builder setProduct_id(long product_id) {
            this.product_id = product_id;
            return this;
        }

        public Builder setAdded_at(LocalDate added_at) {
            this.added_at = added_at;
            return this;
        }

        public Builder copy(Wishlist_Items wishlist_items) {
            this.wishlist_item_id = wishlist_items.getWishlist_item_id();
            this.wishlist_id = wishlist_items.getWishlist_id();
            this.product_id = wishlist_items.getProduct_id();
            this.added_at = wishlist_items.getAdded_at();
            return this;
        }

        public Wishlist_Items build() {
            return new Wishlist_Items(this);
        }
    }
}

