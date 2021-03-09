package com.ical.cleaningservice.repos;

import com.ical.cleaningservice.models.UserService;
import org.springframework.data.repository.CrudRepository;

public interface UserServiceRepository extends CrudRepository<UserService, Integer> {
}
