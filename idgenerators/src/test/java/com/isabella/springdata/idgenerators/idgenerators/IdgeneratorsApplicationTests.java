package com.isabella.springdata.idgenerators.idgenerators;

import com.isabella.springdata.idgenerators.idgenerators.entities.Employee;
import com.isabella.springdata.idgenerators.idgenerators.repos.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class IdgeneratorsApplicationTests {
	@Autowired
	EmployeeRepository er;

	@Test
	void testCreateEmployee() {
		Employee employee = new Employee();
		employee.setName("John Doe");

		er.save(employee);
	}

}
