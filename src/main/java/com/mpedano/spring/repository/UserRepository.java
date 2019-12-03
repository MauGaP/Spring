package com.mpedano.spring.repository;

import com.mpedano.spring.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface UserRepository extends CrudRepository<User, Integer> {

    public List<User> findByFirstName(@Param("firstName") String firstName);
}
