package com.ical.cleaningservice.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "SERVICE_TYPE", schema = "simple_cleaning_java")
public class ServiceType {
    private int serviceTypePk;
    private String name;

    public ServiceType(String name) {
        this.name = name;
    }

    public ServiceType() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "service_type_pk")
    public int getServiceTypePk() {
        return serviceTypePk;
    }

    public void setServiceTypePk(int serviceTypePk) {
        this.serviceTypePk = serviceTypePk;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ServiceType that = (ServiceType) o;
        return serviceTypePk == that.serviceTypePk &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serviceTypePk, name);
    }
}
