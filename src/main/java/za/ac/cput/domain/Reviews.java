package za.ac.cput.domain;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Reviews.java
 *
 * @author Rethabile Ntsekhe
 * Student Num: 220455430
 * @date 23-Jul-24
 */


@Entity
public class Reviews implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long review_id;
    private long product_id;
    private long user_id;
    private int rating;
    private String comment;
    private LocalDate created_at;

    public Reviews() {
    }

    public Reviews(Builder builder) {
        this.review_id = builder.review_id;
        this.product_id = builder.product_id;
        this.user_id = builder.user_id;
        this.rating = builder.rating;
        this.comment = builder.comment;
        this.created_at = builder.created_at;
    }

    public long getReview_id() {
        return review_id;
    }

    public long getProduct_id() {
        return product_id;
    }

    public long getUser_id() {
        return user_id;
    }

    public int getRating() {
        return rating;
    }

    public String getComment() {
        return comment;
    }

    public LocalDate getCreated_at() {
        return created_at;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Reviews reviews)) return false;

        if (getReview_id() != reviews.getReview_id()) return false;
        if (getProduct_id() != reviews.getProduct_id()) return false;
        if (getUser_id() != reviews.getUser_id()) return false;
        if (getRating() != reviews.getRating()) return false;
        if (getComment() != null ? !getComment().equals(reviews.getComment()) : reviews.getComment() != null)
            return false;
        return getCreated_at() != null ? getCreated_at().equals(reviews.getCreated_at()) : reviews.getCreated_at() == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (getReview_id() ^ (getReview_id() >>> 32));
        result = 31 * result + (int) (getProduct_id() ^ (getProduct_id() >>> 32));
        result = 31 * result + (int) (getUser_id() ^ (getUser_id() >>> 32));
        result = 31 * result + getRating();
        result = 31 * result + (getComment() != null ? getComment().hashCode() : 0);
        result = 31 * result + (getCreated_at() != null ? getCreated_at().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Reviews{" +
                "Review ID: " + review_id +
                ", PRODUCT ID: " + product_id +
                ", USER ID: " + user_id +
                ", RATING: " + rating +
                ", COMMENT: '" + comment + '\'' +
                ", CREATED AT: " + created_at +
                '}';
    }

    public static class Builder {
        private long review_id;
        private long product_id;
        private long user_id;
        private int rating;
        private String comment;
        private LocalDate created_at;

        public Builder setReview_id(long review_id) {
            this.review_id = review_id;
            return this;
        }

        public Builder setProduct_id(long product_id) {
            this.product_id = product_id;
            return this;
        }

        public Builder setUser_id(long user_id) {
            this.user_id = user_id;
            return this;
        }

        public Builder setRating(int rating) {
            this.rating = rating;
            return this;
        }

        public Builder setComment(String comment) {
            this.comment = comment;
            return this;
        }

        public Builder setCreated_at(LocalDate created_at) {
            this.created_at = created_at;
            return this;
        }

        public Builder copy(Reviews reviews) {
            this.review_id = reviews.getReview_id();
            this.product_id = reviews.getProduct_id();
            this.user_id = reviews.getUser_id();
            this.rating = reviews.getRating();
            this.comment = reviews.getComment();
            this.created_at = reviews.getCreated_at();
            return this;
        }

        public Reviews build() {
            return new Reviews(this);
        }
    }
}

