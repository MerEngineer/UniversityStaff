package com.example.universitystaff.repo;

import com.example.universitystaff.api.Util.utilClasses.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
     Person findByEmail(String email);
     Person findByDepartmentId(Long id);
}
