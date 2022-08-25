package com.isabellabs.springdata.jpqlandnativesql.jpqlandnativesql.repos;

import com.isabellabs.springdata.jpqlandnativesql.jpqlandnativesql.entities.Student;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Objects;

public interface StudentRepository extends CrudRepository<Student, Long> {
    @Query("from Student")
    List<Student> findAllStudents(Pageable pageable);

    @Query("select firstName, lastName from Student st")
    List<Object[]>findAllStudentsPartialData();

    @Query("From Student where firstName=:firstName")
    List<Student> findAllStudentsByFirstName(@Param("firstName") String firstName);

    @Query("From Student where score>:min and score<=:max")
    List<Student> findStudentsByGivenScore(@Param("min") int min, @Param("max") int max);

    @Modifying
    @Query("delete from Student where firstName=:firstName")
    void deleteStudentsByFirstName(@Param("firstName") String firstName);
}
