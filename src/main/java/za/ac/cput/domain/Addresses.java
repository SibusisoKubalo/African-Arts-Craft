package za.ac.cput.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * Addresses.java
 *
 * @author Rethabile Ntsekhe
 * Student Num: 220455430
 * @date 23-Jul-24
 */


@Entity
public class Addresses implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long address_id;
    private long user_id;
    private String address_line1;
    private String address_line2;
    private String city;
    private String province;
    private String postal_code;
    private String country;
    private LocalDate created_at;
    private LocalDate updated_at;

    public Addresses() {
    }

    public Addresses(Builder builder) {
        this.address_id = builder.address_id;
        this.user_id = builder.user_id;
        this.address_line1 = builder.address_line1;
        this.address_line2 = builder.address_line2;
        this.city = builder.city;
        this.province = builder.province;
        this.postal_code = builder.postal_code;
        this.country = builder.country;
        this.created_at = builder.created_at;
        this.updated_at = builder.updated_at;
    }

    public long getAddress_id() {
        return address_id;
    }

    public long getUser_id() {
        return user_id;
    }

    public String getAddress_line1() {
        return address_line1;
    }

    public String getAddress_line2() {
        return address_line2;
    }

    public String getCity() {
        return city;
    }

    public String getProvince() {
        return province;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public String getCountry() {
        return country;
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
        if (!(o instanceof Addresses addresses)) return false;

        if (getAddress_id() != addresses.getAddress_id()) return false;
        if (getUser_id() != addresses.getUser_id()) return false;
        if (getAddress_line1() != null ? !getAddress_line1().equals(addresses.getAddress_line1()) : addresses.getAddress_line1() != null)
            return false;
        if (getAddress_line2() != null ? !getAddress_line2().equals(addresses.getAddress_line2()) : addresses.getAddress_line2() != null)
            return false;
        if (getCity() != null ? !getCity().equals(addresses.getCity()) : addresses.getCity() != null) return false;
        if (getProvince() != null ? !getProvince().equals(addresses.getProvince()) : addresses.getProvince() != null)
            return false;
        if (getPostal_code() != null ? !getPostal_code().equals(addresses.getPostal_code()) : addresses.getPostal_code() != null)
            return false;
        if (getCountry() != null ? !getCountry().equals(addresses.getCountry()) : addresses.getCountry() != null)
            return false;
        if (getCreated_at() != null ? !getCreated_at().equals(addresses.getCreated_at()) : addresses.getCreated_at() != null)
            return false;
        return getUpdated_at() != null ? getUpdated_at().equals(addresses.getUpdated_at()) : addresses.getUpdated_at() == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (getAddress_id() ^ (getAddress_id() >>> 32));
        result = 31 * result + (int) (getUser_id() ^ (getUser_id() >>> 32));
        result = 31 * result + (getAddress_line1() != null ? getAddress_line1().hashCode() : 0);
        result = 31 * result + (getAddress_line2() != null ? getAddress_line2().hashCode() : 0);
        result = 31 * result + (getCity() != null ? getCity().hashCode() : 0);
        result = 31 * result + (getProvince() != null ? getProvince().hashCode() : 0);
        result = 31 * result + (getPostal_code() != null ? getPostal_code().hashCode() : 0);
        result = 31 * result + (getCountry() != null ? getCountry().hashCode() : 0);
        result = 31 * result + (getCreated_at() != null ? getCreated_at().hashCode() : 0);
        result = 31 * result + (getUpdated_at() != null ? getUpdated_at().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Addresses{" +
                "Address ID: " + address_id +
                ", USER ID: " + user_id +
                ", ADDRESS LINE1: '" + address_line1 + '\'' +
                ", ADDRESS LINE2: '" + address_line2 + '\'' +
                ", CITY: '" + city + '\'' +
                ", PROVINCE: '" + province + '\'' +
                ", POSTAL CODE: '" + postal_code + '\'' +
                ", COUNTRY: '" + country + '\'' +
                ", CREATED AT: " + created_at +
                ", UPDATED AT: " + updated_at +
                '}';
    }

    public static class Builder {
        private long address_id;
        private long user_id;
        private String address_line1;
        private String address_line2;
        private String city;
        private String province;
        private String postal_code;
        private String country;
        private LocalDate created_at;
        private LocalDate updated_at;

        public Builder setAddress_id(long address_id) {
            this.address_id = address_id;
            return this;
        }

        public Builder setUser_id(long user_id) {
            this.user_id = user_id;
            return this;
        }

        public Builder setAddress_line1(String address_line1) {
            this.address_line1 = address_line1;
            return this;
        }

        public Builder setAddress_line2(String address_line2) {
            this.address_line2 = address_line2;
            return this;
        }

        public Builder setCity(String city) {
            this.city = city;
            return this;
        }

        public Builder setProvince(String province) {
            this.province = province;
            return this;
        }

        public Builder setPostal_code(String postal_code) {
            this.postal_code = postal_code;
            return this;
        }

        public Builder setCountry(String country) {
            this.country = country;
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

        public Builder copy(Addresses addresses) {
            this.address_id = addresses.getAddress_id();
            this.user_id = addresses.getUser_id();
            this.address_line1 = addresses.getAddress_line1();
            this.address_line2 = addresses.getAddress_line2();
            this.city = addresses.getCity();
            this.province = addresses.getProvince();
            this.postal_code = addresses.getPostal_code();
            this.country = addresses.getCountry();
            this.created_at = addresses.getCreated_at();
            this.updated_at = addresses.getUpdated_at();
            return this;
        }

        public Addresses build() {
            return new Addresses(this);
        }
    }
}

