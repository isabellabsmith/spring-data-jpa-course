package com.isabellabs.hibernateinheritance.hibernateinheritance.repos;

import com.isabellabs.hibernateinheritance.hibernateinheritance.entities.Payment;
import org.springframework.data.repository.CrudRepository;

public interface PaymentRepository extends CrudRepository<Payment, Integer> {
}
