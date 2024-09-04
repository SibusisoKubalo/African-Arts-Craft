package za.ac.cput.domain;

import java.io.Serializable;

import jakarta.persistence.*;

/**
 * Categories.java
 *
 * @author Rethabile Ntsekhe
 * Student Num: 220455430
 * @date 23-Jul-24
 */

@Entity
public class Categories implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long category_id;
    private String name;
    private String description;

    public Categories() {
    }

    public Categories(Builder builder) {
        this.category_id = builder.category_id;
        this.name = builder.name;
        this.description = builder.description;
    }

    public long getCategory_id() {
        return category_id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }


    @Override
    public String toString() {
        return "Categories{" +
                "Category ID: " + category_id +
                ", NAME: '" + name + '\'' +
                ", DESCRIPTION: '" + description + '\'' +
                '}';
    }

    public static class Builder {
        private long category_id;
        private String name;
        private String description;

        public Builder setCategory_id(long category_id) {
            this.category_id = category_id;
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

        public Builder copy(Categories categories) {
            this.category_id = categories.getCategory_id();
            this.name = categories.getName();
            this.description = categories.getDescription();
            return this;
        }

        public Categories build() {
            return new Categories(this);
        }
    }
}

