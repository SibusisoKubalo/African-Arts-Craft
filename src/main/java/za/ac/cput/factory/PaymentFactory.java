package za.ac.cput.factory;

import za.ac.cput.domain.Payments;
import za.ac.cput.util.Helper;

import java.time.LocalDate;

/**
 * PaymentFactory.java
 *
 * @author Rethabile Ntsekhe
 * Student Num: 220455430
 * @date 26-Jul-24
 */

public class PaymentFactory {
    public static Payments buildPayment(long payment_id, long order_id, LocalDate payment_date,
                                        double payment_amount, String payment_method, String payment_status) {
        if (Helper.isDoubleNullOrEmpty(payment_amount) ||
                Helper.isNullOrEmpty(String.valueOf(payment_date)) ||
                Helper.isNullOrEmpty(payment_method) ||
                Helper.isNullOrEmpty(payment_status)
        ) return null;

        return new Payments.Builder()
                .setPayment_id(payment_id)
                .setOrder_id(order_id)
                .setPayment_date(payment_date)
                .setPayment_amount(payment_amount)
                .setPayment_method(payment_method)
                .setPayment_status(payment_status)
                .build();
    }
}
