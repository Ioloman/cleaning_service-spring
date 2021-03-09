package com.ical.cleaningservice.models;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "SERVICE", schema = "simple_cleaning_java")
@IdClass(ServicePK.class)
public class Service {
    private int userServicePk;
    private int serviceTypePk;
    private String title;
    private String description;
    private BigDecimal price;
    private int servicePk;
    private Date date;

    public Service() {
    }

    public Service(String title, String description, BigDecimal price, int userServicePk, int serviceTypePk, Date date) {
        this.userServicePk = userServicePk;
        this.serviceTypePk = serviceTypePk;
        this.title = title;
        this.description = description;
        this.price = price;
        this.date = date;
    }

    @Id
    @Column(name = "user_service_pk")
    public int getUserServicePk() {
        return userServicePk;
    }

    public void setUserServicePk(int userServicePk) {
        this.userServicePk = userServicePk;
    }

    @Id
    @Column(name = "service_type_pk")
    public int getServiceTypePk() {
        return serviceTypePk;
    }

    public void setServiceTypePk(int serviceTypePk) {
        this.serviceTypePk = serviceTypePk;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
    @Column(name = "price")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "service_pk")
    public int getServicePk() {
        return servicePk;
    }

    public void setServicePk(int servicePk) {
        this.servicePk = servicePk;
    }

    @Basic
    @Column(name = "date")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Service service = (Service) o;
        return userServicePk == service.userServicePk &&
                serviceTypePk == service.serviceTypePk &&
                servicePk == service.servicePk &&
                Objects.equals(title, service.title) &&
                Objects.equals(description, service.description) &&
                Objects.equals(price, service.price) &&
                Objects.equals(date, service.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userServicePk, serviceTypePk, title, description, price, servicePk, date);
    }
}
