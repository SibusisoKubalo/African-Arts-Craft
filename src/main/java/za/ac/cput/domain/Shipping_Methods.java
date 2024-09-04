package za.ac.cput.domain;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * ShippingMethods.java
 *
 * @author Rethabile Ntsekhe
 * Student Num: 220455430
 * @date 23-Jul-24
 */


@Entity
public class Shipping_Methods implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long shipping_method_id;
    private String name;
    private String description;
    private double cost;
    private String delivery_time;
    private Addresses address_id;

    public Shipping_Methods() {
    }

    public Shipping_Methods(Builder builder) {
        this.shipping_method_id = builder.shipping_method_id;
        this.name = builder.name;
        this.description = builder.description;
        this.cost = builder.cost;
        this.delivery_time = builder.delivery_time;
    }

    public long getShipping_method_id() {
        return shipping_method_id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getCost() {
        return cost;
    }

    public String getDelivery_time() {
        return delivery_time;
    }

    @Override
    public String toString() {
        return "Shipping_Methods{" +
                "Shipping Method ID: " + shipping_method_id +
                ", NAME: '" + name + '\'' +
                ", DESCRIPTION: '" + description + '\'' +
                ", COST: " + cost +
                ", DELIVERY TIME: '" + delivery_time + '\'' +
                '}';
    }

    public static class Builder {
        private long shipping_method_id;
        private String name;
        private String description;
        private double cost;
        private String delivery_time;

        public Builder setShipping_method_id(long shipping_method_id) {
            this.shipping_method_id = shipping_method_id;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setCost(double cost) {
            this.cost = cost;
            return this;
        }

        public Builder setDelivery_time(String delivery_time) {
            this.delivery_time = delivery_time;
            return this;
        }

        public Builder copy(Shipping_Methods shipping_methods) {
            this.shipping_method_id = shipping_methods.getShipping_method_id();
            this.name = shipping_methods.getName();
            this.description = shipping_methods.getDescription();
            this.cost = shipping_methods.getCost();
            this.delivery_time = shipping_methods.getDelivery_time();
            return this;
        }

        public Shipping_Methods build() {
            return new Shipping_Methods(this);
        }
    }
}

