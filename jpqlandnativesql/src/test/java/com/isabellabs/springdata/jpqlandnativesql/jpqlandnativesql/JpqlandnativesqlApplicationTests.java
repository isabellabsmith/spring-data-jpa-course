package com.isabellabs.springdata.jpqlandnativesql.jpqlandnativesql;

import com.isabellabs.springdata.jpqlandnativesql.jpqlandnativesql.entities.Student;
import com.isabellabs.springdata.jpqlandnativesql.jpqlandnativesql.repos.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.stream.Collectors;

@SpringBootTest
class JpqlandnativesqlApplicationTests {
	@Autowired
	StudentRepository repository;

	@Test
	void testStudentCreate() {
		Student student = new Student();
		student.setFirstName("Jane");
		student.setLastName("Doe");
		student.setScore(88);

		Student student2 = new Student();
		student2.setFirstName("Harry");
		student2.setLastName("Potter");
		student2.setScore(92);

		repository.save(student);
		repository.save(student2);
	}

	@Test
	void testFindAllStudents() {
		System.out.println(repository.findAllStudents(PageRequest.of(0,2, Sort.Direction.DESC, "id")));
	}

	@Test
	void testFindAllStudentsPartialData() {
		repository.findAllStudentsPartialData().forEach(p->System.out.println(Arrays.toString(p)));
	}
	@Test
	void testFindAllStudentsByFirstName() {
		System.out.println(repository.findAllStudentsByFirstName("Harry"));
	}

	@Test
	void testFindAllStudentsByScores() {
		System.out.println(repository.findStudentsByGivenScore(80, 90));
	}

	@Test
	@Transactional
	@Rollback(false) // only in JUnitTests
	void testDeleteStudentsByFirstName() {
		repository.deleteStudentsByFirstName("Jane");
	}

	@Test
	void testFindAllStudentsNQ() {
		System.out.println(repository.findAllStudentsNQ());
	}

	@Test
	void testFindByFirstNameNQ() {
		System.out.println(repository.findByFirsName("Jane"));
	}
}
