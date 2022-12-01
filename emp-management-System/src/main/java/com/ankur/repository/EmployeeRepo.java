package com.ankur.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ankur.model.Employee;


@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

}
