package com.mpedano.spring.repository;

import com.mpedano.spring.model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface StudentRepository extends CrudRepository<Student, Integer> {

}
