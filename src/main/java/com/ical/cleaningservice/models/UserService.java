package com.ical.cleaningservice.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "USER_SERVICE", schema = "simple_cleaning_java")
public class UserService {
    private String name;
    private String lastName;
    private int userServicePk;
    private String description;
    private Integer rating;
    private short type;
    private String phone;

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_service_pk")
    public int getUserServicePk() {
        return userServicePk;
    }

    public void setUserServicePk(int userServicePk) {
        this.userServicePk = userServicePk;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "rating")
    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    @Basic
    @Column(name = "type")
    public short getType() {
        return type;
    }

    public void setType(short type) {
        this.type = type;
    }

    @Basic
    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserService that = (UserService) o;
        return userServicePk == that.userServicePk &&
                type == that.type &&
                Objects.equals(name, that.name) &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(description, that.description) &&
                Objects.equals(rating, that.rating) &&
                Objects.equals(phone, that.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, lastName, userServicePk, description, rating, type, phone);
    }
}
