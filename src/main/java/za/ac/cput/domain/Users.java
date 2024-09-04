package za.ac.cput.domain;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Users.java
 *
 * @author Rethabile Ntsekhe
 * Student Num: 220455430
 * @date 23-Jul-24
 */
@Entity
public class Users implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long user_id;
    private String username;
    private String password;
    private String email;
    private String first_name;
    private String last_name;
    private LocalDate created_at;
    private LocalDate updated_at;

    public Users() {
    }

    public Users(Builder builder) {
        this.user_id = builder.user_id;
        this.username = builder.username;
        this.password = builder.password;
        this.email = builder.email;
        this.first_name = builder.first_name;
        this.last_name = builder.last_name;
        this.created_at = builder.created_at;
        this.updated_at = builder.updated_at;
    }

    public long getUser_id() {
        return user_id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
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
        if (!(o instanceof Users users)) return false;

        if (getUser_id() != users.getUser_id()) return false;
        if (getUsername() != null ? !getUsername().equals(users.getUsername()) : users.getUsername() != null)
            return false;
        if (getPassword() != null ? !getPassword().equals(users.getPassword()) : users.getPassword() != null)
            return false;
        if (getEmail() != null ? !getEmail().equals(users.getEmail()) : users.getEmail() != null) return false;
        if (getFirst_name() != null ? !getFirst_name().equals(users.getFirst_name()) : users.getFirst_name() != null)
            return false;
        if (getLast_name() != null ? !getLast_name().equals(users.getLast_name()) : users.getLast_name() != null)
            return false;
        if (getCreated_at() != null ? !getCreated_at().equals(users.getCreated_at()) : users.getCreated_at() != null)
            return false;
        return getUpdated_at() != null ? getUpdated_at().equals(users.getUpdated_at()) : users.getUpdated_at() == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (getUser_id() ^ (getUser_id() >>> 32));
        result = 31 * result + (getUsername() != null ? getUsername().hashCode() : 0);
        result = 31 * result + (getPassword() != null ? getPassword().hashCode() : 0);
        result = 31 * result + (getEmail() != null ? getEmail().hashCode() : 0);
        result = 31 * result + (getFirst_name() != null ? getFirst_name().hashCode() : 0);
        result = 31 * result + (getLast_name() != null ? getLast_name().hashCode() : 0);
        result = 31 * result + (getCreated_at() != null ? getCreated_at().hashCode() : 0);
        result = 31 * result + (getUpdated_at() != null ? getUpdated_at().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Users{" +
                "Users ID: " + user_id +
                ", USERNAME: '" + username + '\'' +
                ", PASSWORD: '" + password + '\'' +
                ", EMAIL: '" + email + '\'' +
                ", FIRST NAME: '" + first_name + '\'' +
                ", LAST NAME: '" + last_name + '\'' +
                ", CREATED AT: " + created_at +
                ", UPDATED AT: " + updated_at +
                '}';
    }

    public static class Builder {
        private long user_id;
        private String username;
        private String password;
        private String email;
        private String first_name;
        private String last_name;
        private LocalDate created_at;
        private LocalDate updated_at;

        public Builder setUser_id(long user_id) {
            this.user_id = user_id;
            return this;
        }

        public Builder setUsername(String username) {
            this.username = username;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setFirst_name(String first_name) {
            this.first_name = first_name;
            return this;
        }

        public Builder setLast_name(String last_name) {
            this.last_name = last_name;
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

        public Builder copy(Users users) {
            this.user_id = users.getUser_id();
            this.username = users.getUsername();
            this.password = users.getPassword();
            this.email = users.getEmail();
            this.first_name = users.getFirst_name();
            this.last_name = users.getLast_name();
            this.created_at = users.getCreated_at();
            this.updated_at = users.getUpdated_at();
            return this;
        }

        public Users build() {
            return new Users(this);
        }
    }
}
