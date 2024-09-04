package za.ac.cput.domain;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Orders.java
 *
 * @author Rethabile Ntsekhe
 * Student Num: 220455430
 * @date 23-Jul-24
 */

@Entity
public class Orders implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long order_id;
    private long user_id;
    private double total_amount;
    private LocalDate order_date;
    private String status;
    private String shipping_address;
    private String billing_address;
    private String payment_method;
    private LocalDate created_at;
    private LocalDate updated_at;

    public Orders() {
    }

    public Orders(Builder builder) {
        this.order_id = builder.order_id;
        this.user_id = builder.user_id;
        this.total_amount = builder.total_amount;
        this.order_date = builder.order_date;
        this.status = builder.status;
        this.shipping_address = builder.shipping_address;
        this.billing_address = builder.billing_address;
        this.payment_method = builder.payment_method;
        this.created_at = builder.created_at;
        this.updated_at = builder.updated_at;
    }

    public long getOrder_id() {
        return order_id;
    }

    public long getUser_id() {
        return user_id;
    }

    public double getTotal_amount() {
        return total_amount;
    }

    public LocalDate getOrder_date() {
        return order_date;
    }

    public String getStatus() {
        return status;
    }

    public String getShipping_address() {
        return shipping_address;
    }

    public String getBilling_address() {
        return billing_address;
    }

    public String getPayment_method() {
        return payment_method;
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
        if (!(o instanceof Orders orders)) return false;

        if (getOrder_id() != orders.getOrder_id()) return false;
        if (getUser_id() != orders.getUser_id()) return false;
        if (Double.compare(getTotal_amount(), orders.getTotal_amount()) != 0) return false;
        if (getOrder_date() != null ? !getOrder_date().equals(orders.getOrder_date()) : orders.getOrder_date() != null)
            return false;
        if (getStatus() != null ? !getStatus().equals(orders.getStatus()) : orders.getStatus() != null) return false;
        if (getShipping_address() != null ? !getShipping_address().equals(orders.getShipping_address()) : orders.getShipping_address() != null)
            return false;
        if (getBilling_address() != null ? !getBilling_address().equals(orders.getBilling_address()) : orders.getBilling_address() != null)
            return false;
        if (getPayment_method() != null ? !getPayment_method().equals(orders.getPayment_method()) : orders.getPayment_method() != null)
            return false;
        if (getCreated_at() != null ? !getCreated_at().equals(orders.getCreated_at()) : orders.getCreated_at() != null)
            return false;
        return getUpdated_at() != null ? getUpdated_at().equals(orders.getUpdated_at()) : orders.getUpdated_at() == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (int) (getOrder_id() ^ (getOrder_id() >>> 32));
        result = 31 * result + (int) (getUser_id() ^ (getUser_id() >>> 32));
        temp = Double.doubleToLongBits(getTotal_amount());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (getOrder_date() != null ? getOrder_date().hashCode() : 0);
        result = 31 * result + (getStatus() != null ? getStatus().hashCode() : 0);
        result = 31 * result + (getShipping_address() != null ? getShipping_address().hashCode() : 0);
        result = 31 * result + (getBilling_address() != null ? getBilling_address().hashCode() : 0);
        result = 31 * result + (getPayment_method() != null ? getPayment_method().hashCode() : 0);
        result = 31 * result + (getCreated_at() != null ? getCreated_at().hashCode() : 0);
        result = 31 * result + (getUpdated_at() != null ? getUpdated_at().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "Order ID: " + order_id +
                ", USER ID: " + user_id +
                ", TOTAL AMOUNT: " + total_amount +
                ", ORDER DATE: " + order_date +
                ", STATUS: '" + status + '\'' +
                ", SHIPPING ADDRESS: '" + shipping_address + '\'' +
                ", BILLING ADDRESS: '" + billing_address + '\'' +
                ", PAYMENT METHOD: '" + payment_method + '\'' +
                ", CREATED AT: " + created_at +
                ", UPDATED AT: " + updated_at +
                '}';
    }

    public static class Builder {
        private long order_id;
        private long user_id;
        private double total_amount;
        private LocalDate order_date;
        private String status;
        private String shipping_address;
        private String billing_address;
        private String payment_method;
        private LocalDate created_at;
        private LocalDate updated_at;

        public Builder setOrder_id(long order_id) {
            this.order_id = order_id;
            return this;
        }

        public Builder setUser_id(long user_id) {
            this.user_id = user_id;
            return this;
        }

        public Builder setTotal_amount(double total_amount) {
            this.total_amount = total_amount;
            return this;
        }

        public Builder setOrder_date(LocalDate order_date) {
            this.order_date = order_date;
            return this;
        }

        public Builder setStatus(String status) {
            this.status = status;
            return this;
        }

        public Builder setShipping_address(String shipping_address) {
            this.shipping_address = shipping_address;
            return this;
        }

        public Builder setBilling_address(String billing_address) {
            this.billing_address = billing_address;
            return this;
        }

        public Builder setPayment_method(String payment_method) {
            this.payment_method = payment_method;
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

        public Builder copy(Orders orders) {
            this.order_id = orders.getOrder_id();
            this.user_id = orders.getUser_id();
            this.total_amount = orders.getTotal_amount();
            this.order_date = orders.getOrder_date();
            this.status = orders.getStatus();
            this.shipping_address = orders.getShipping_address();
            this.billing_address = orders.getBilling_address();
            this.payment_method = orders.getPayment_method();
            this.created_at = orders.getCreated_at();
            this.updated_at = orders.getUpdated_at();
            return this;
        }

        public Orders build() {
            return new Orders(this);
        }
    }
}

