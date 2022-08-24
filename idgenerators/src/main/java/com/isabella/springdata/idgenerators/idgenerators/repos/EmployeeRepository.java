package com.isabella.springdata.idgenerators.idgenerators.repos;

import com.isabella.springdata.idgenerators.idgenerators.entities.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
}
