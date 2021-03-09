package com.ical.cleaningservice.models;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class ServicePK implements Serializable {
    private int userServicePk;
    private int serviceTypePk;
    private int servicePk;

    @Column(name = "user_service_pk")
    @Id
    public int getUserServicePk() {
        return userServicePk;
    }

    public void setUserServicePk(int userServicePk) {
        this.userServicePk = userServicePk;
    }

    @Column(name = "service_type_pk")
    @Id
    public int getServiceTypePk() {
        return serviceTypePk;
    }

    public void setServiceTypePk(int serviceTypePk) {
        this.serviceTypePk = serviceTypePk;
    }

    @Column(name = "service_pk")
    @Id
    public int getServicePk() {
        return servicePk;
    }

    public void setServicePk(int servicePk) {
        this.servicePk = servicePk;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ServicePK servicePK = (ServicePK) o;
        return userServicePk == servicePK.userServicePk &&
                serviceTypePk == servicePK.serviceTypePk &&
                servicePk == servicePK.servicePk;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userServicePk, serviceTypePk, servicePk);
    }
}
