package za.ac.cput.factory;

import za.ac.cput.domain.Discounts;
import za.ac.cput.util.Helper;

import java.time.LocalDate;

/**
 * DiscountFactory.java
 *
 * @author Rethabile Ntsekhe
 * Student Num: 220455430
 * @date 26-Jul-24
 */

public class DiscountFactory {
    public static Discounts buildDiscount(long discount_id, String code, String description,
                                          double discount_percent, LocalDate start_date,
                                          LocalDate end_date, int max_uses) {

        if (Helper.isNullOrEmpty(code) ||
                Helper.isNullOrEmpty(description) ||
                Helper.isDoubleNullOrEmpty(discount_percent) ||
                Helper.isNullOrEmpty(max_uses)
        ) return null;

        return new Discounts.Builder()
                .setDiscount_id(discount_id)
                .setCode(code)
                .setDescription(description)
                .setDiscount_percent(discount_percent)
                .setStart_date(start_date)
                .setEnd_date(end_date)
                .setMax_uses(max_uses)
                .build();
    }
}
