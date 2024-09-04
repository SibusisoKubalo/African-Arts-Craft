package za.ac.cput.domain;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Discounts.java
 *
 * @author Rethabile Ntsekhe
 * Student Num: 220455430
 * @date 23-Jul-24
 */

@Entity
public class Discounts implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long discount_id;
    private String code;
    private String description;
    private double discount_percent;
    private LocalDate start_date;
    private LocalDate end_date;
    private int max_uses;

    public Discounts() {
    }

    public Discounts(Builder builder) {
        this.discount_id = builder.discount_id;
        this.code = builder.code;
        this.description = builder.description;
        this.discount_percent = builder.discount_percent;
        this.start_date = builder.start_date;
        this.end_date = builder.end_date;
        this.max_uses = builder.max_uses;
    }

    public long getDiscount_id() {
        return discount_id;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public double getDiscount_percent() {
        return discount_percent;
    }

    public LocalDate getStart_date() {
        return start_date;
    }

    public LocalDate getEnd_date() {
        return end_date;
    }

    public int getMax_uses() {
        return max_uses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Discounts discounts)) return false;

        if (getDiscount_id() != discounts.getDiscount_id()) return false;
        if (Double.compare(getDiscount_percent(), discounts.getDiscount_percent()) != 0) return false;
        if (getMax_uses() != discounts.getMax_uses()) return false;
        if (getCode() != null ? !getCode().equals(discounts.getCode()) : discounts.getCode() != null) return false;
        if (getDescription() != null ? !getDescription().equals(discounts.getDescription()) : discounts.getDescription() != null)
            return false;
        if (getStart_date() != null ? !getStart_date().equals(discounts.getStart_date()) : discounts.getStart_date() != null)
            return false;
        return getEnd_date() != null ? getEnd_date().equals(discounts.getEnd_date()) : discounts.getEnd_date() == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (int) (getDiscount_id() ^ (getDiscount_id() >>> 32));
        result = 31 * result + (getCode() != null ? getCode().hashCode() : 0);
        result = 31 * result + (getDescription() != null ? getDescription().hashCode() : 0);
        temp = Double.doubleToLongBits(getDiscount_percent());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (getStart_date() != null ? getStart_date().hashCode() : 0);
        result = 31 * result + (getEnd_date() != null ? getEnd_date().hashCode() : 0);
        result = 31 * result + getMax_uses();
        return result;
    }

    @Override
    public String toString() {
        return "Discounts{" +
                "Discount ID: " + discount_id +
                ", CODE: '" + code + '\'' +
                ", DESCRIPTION: '" + description + '\'' +
                ", DISCOUNT PERCENT: " + discount_percent +
                ", START DATE: " + start_date +
                ", END DATE: " + end_date +
                ", MAX USES: " + max_uses +
                '}';
    }

    public static class Builder {
        private long discount_id;
        private String code;
        private String description;
        private double discount_percent;
        private LocalDate start_date;
        private LocalDate end_date;
        private int max_uses;

        public Builder setDiscount_id(long discount_id) {
            this.discount_id = discount_id;
            return this;
        }

        public Builder setCode(String code) {
            this.code = code;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setDiscount_percent(double discount_percent) {
            this.discount_percent = discount_percent;
            return this;
        }

        public Builder setStart_date(LocalDate start_date) {
            this.start_date = start_date;
            return this;
        }

        public Builder setEnd_date(LocalDate end_date) {
            this.end_date = end_date;
            return this;
        }

        public Builder setMax_uses(int max_uses) {
            this.max_uses = max_uses;
            return this;
        }

        public Builder copy(Discounts discounts) {
            this.discount_id = discounts.getDiscount_id();
            this.code = discounts.getCode();
            this.description = discounts.getDescription();
            this.discount_percent = discounts.getDiscount_percent();
            this.start_date = discounts.getStart_date();
            this.end_date = discounts.getEnd_date();
            this.max_uses = discounts.getMax_uses();
            return this;
        }

        public Discounts build() {
            return new Discounts(this);
        }
    }
}

