package com.ical.cleaningservice.repos;

import com.ical.cleaningservice.models.Service;
import org.springframework.data.repository.CrudRepository;

public interface ServiceRepository extends CrudRepository<Service, Integer> {
    Service findByServicePk(Integer servicePk);
}
