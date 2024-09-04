package za.ac.cput.domain;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Wishlists.java
 *
 * @author Rethabile Ntsekhe
 * Student Num: 220455430
 * @date 23-Jul-24
 */


@Entity
public class Wishlists implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long wishlist_id;
    private long user_id;
    private LocalDate created_at;

    public Wishlists() {
    }

    public Wishlists(Builder builder) {
        this.wishlist_id = builder.wishlist_id;
        this.user_id = builder.user_id;
        this.created_at = builder.created_at;
    }

    public long getWishlist_id() {
        return wishlist_id;
    }

    public long getUser_id() {
        return user_id;
    }

    public LocalDate getCreated_at() {
        return created_at;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Wishlists wishlists)) return false;

        if (getWishlist_id() != wishlists.getWishlist_id()) return false;
        if (getUser_id() != wishlists.getUser_id()) return false;
        return getCreated_at() != null ? getCreated_at().equals(wishlists.getCreated_at()) : wishlists.getCreated_at() == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (getWishlist_id() ^ (getWishlist_id() >>> 32));
        result = 31 * result + (int) (getUser_id() ^ (getUser_id() >>> 32));
        result = 31 * result + (getCreated_at() != null ? getCreated_at().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Wishlists{" +
                "Wishlist ID: " + wishlist_id +
                ", USER ID: " + user_id +
                ", CREATED AT: " + created_at +
                '}';
    }

    public static class Builder {
        private long wishlist_id;
        private long user_id;
        private LocalDate created_at;

        public Builder setWishlist_id(long wishlist_id) {
            this.wishlist_id = wishlist_id;
            return this;
        }

        public Builder setUser_id(long user_id) {
            this.user_id = user_id;
            return this;
        }

        public Builder setCreated_at(LocalDate created_at) {
            this.created_at = created_at;
            return this;
        }

        public Builder copy(Wishlists wishlists) {
            this.wishlist_id = wishlists.getWishlist_id();
            this.user_id = wishlists.getUser_id();
            this.created_at = wishlists.getCreated_at();
            return this;
        }

        public Wishlists build() {
            return new Wishlists(this);
        }
    }
}

