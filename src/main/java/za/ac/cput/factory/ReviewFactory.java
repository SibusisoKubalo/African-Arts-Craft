package za.ac.cput.factory;

import za.ac.cput.domain.Reviews;
import za.ac.cput.util.Helper;

import java.time.LocalDate;

/**
 * ReviewFactory.java
 *
 * @author Rethabile Ntsekhe
 * Student Num: 220455430
 * @date 26-Jul-24
 */

public class ReviewFactory {
    public static Reviews buildReview(long review_id, long product_id, long user_id, int rating,
                                      String comment, LocalDate created_at) {
        if (Helper.isNullOrEmpty(rating) ||
                Helper.isNullOrEmpty(comment) ||
                Helper.isNullOrEmpty(String.valueOf(created_at))
        ) return null;

        return new Reviews.Builder()
                .setReview_id(review_id)
                .setProduct_id(product_id)
                .setUser_id(user_id)
                .setRating(rating)
                .setComment(comment)
                .setCreated_at(created_at)
                .build();
    }
}
