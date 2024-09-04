package za.ac.cput.domain;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Payments.java
 *
 * @author Rethabile Ntsekhe
 * Student Num: 220455430
 * @date 23-Jul-24
 */


@Entity
public class Payments implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long payment_id;
    private long order_id;
    private LocalDate payment_date;
    private double payment_amount;
    private String payment_method;
    private String payment_status;

    public Payments() {
    }

    public Payments(Builder builder) {
        this.payment_id = builder.payment_id;
        this.order_id = builder.order_id;
        this.payment_date = builder.payment_date;
        this.payment_amount = builder.payment_amount;
        this.payment_method = builder.payment_method;
        this.payment_status = builder.payment_status;
    }

    public long getPayment_id() {
        return payment_id;
    }

    public long getOrder_id() {
        return order_id;
    }

    public LocalDate getPayment_date() {
        return payment_date;
    }

    public double getPayment_amount() {
        return payment_amount;
    }

    public String getPayment_method() {
        return payment_method;
    }

    public String getPayment_status() {
        return payment_status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Payments payments)) return false;

        if (getPayment_id() != payments.getPayment_id()) return false;
        if (getOrder_id() != payments.getOrder_id()) return false;
        if (Double.compare(getPayment_amount(), payments.getPayment_amount()) != 0) return false;
        if (getPayment_date() != null ? !getPayment_date().equals(payments.getPayment_date()) : payments.getPayment_date() != null)
            return false;
        if (getPayment_method() != null ? !getPayment_method().equals(payments.getPayment_method()) : payments.getPayment_method() != null)
            return false;
        return getPayment_status() != null ? getPayment_status().equals(payments.getPayment_status()) : payments.getPayment_status() == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (int) (getPayment_id() ^ (getPayment_id() >>> 32));
        result = 31 * result + (int) (getOrder_id() ^ (getOrder_id() >>> 32));
        result = 31 * result + (getPayment_date() != null ? getPayment_date().hashCode() : 0);
        temp = Double.doubleToLongBits(getPayment_amount());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (getPayment_method() != null ? getPayment_method().hashCode() : 0);
        result = 31 * result + (getPayment_status() != null ? getPayment_status().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Payments{" +
                "Payment ID: " + payment_id +
                ", ORDER ID: " + order_id +
                ", PAYMENT DATE: " + payment_date +
                ", PAYMENT AMOUNT: " + payment_amount +
                ", PAYMENT METHOD: '" + payment_method + '\'' +
                ", PAYMENT STATUS: '" + payment_status + '\'' +
                '}';
    }

    public static class Builder {
        private long payment_id;
        private long order_id;
        private LocalDate payment_date;
        private double payment_amount;
        private String payment_method;
        private String payment_status;

        public Builder setPayment_id(long payment_id) {
            this.payment_id = payment_id;
            return this;
        }

        public Builder setOrder_id(long order_id) {
            this.order_id = order_id;
            return this;
        }

        public Builder setPayment_date(LocalDate payment_date) {
            this.payment_date = payment_date;
            return this;
        }

        public Builder setPayment_amount(double payment_amount) {
            this.payment_amount = payment_amount;
            return this;
        }

        public Builder setPayment_method(String payment_method) {
            this.payment_method = payment_method;
            return this;
        }

        public Builder setPayment_status(String payment_status) {
            this.payment_status = payment_status;
            return this;
        }

        public Builder copy(Payments payments) {
            this.payment_id = payments.getPayment_id();
            this.order_id = payments.getOrder_id();
            this.payment_date = payments.getPayment_date();
            this.payment_amount = payments.getPayment_amount();
            this.payment_method = payments.getPayment_method();
            this.payment_status = payments.getPayment_status();
            return this;
        }

        public Payments build() {
            return new Payments(this);
        }
    }
}

