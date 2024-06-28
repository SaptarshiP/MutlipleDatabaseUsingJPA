package com.psja.MutlipleDatabaseUsingJPA.persistence.employee;

import org.springframework.stereotype.Repository;

import com.psja.MutlipleDatabaseUsingJPA.entity.employee.EmployeeEntity;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, String>{

}
