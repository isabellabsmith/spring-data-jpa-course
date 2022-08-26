package com.isabellabs.hibernateinheritance.hibernateinheritance;

import com.isabellabs.hibernateinheritance.hibernateinheritance.entities.Check;
import com.isabellabs.hibernateinheritance.hibernateinheritance.entities.CreditCard;
import com.isabellabs.hibernateinheritance.hibernateinheritance.repos.PaymentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HibernateinheritanceApplicationTests {

	@Autowired
	PaymentRepository repository;

	@Test
	void createPayment() {
		CreditCard cc = new CreditCard();
		cc.setId(123);
		cc.setAmount(1000);
		cc.setCardnumber("1234567890");
		repository.save(cc);
	}

	@Test
	void createCheckPayment() {
		Check ch = new Check();
		ch.setId(125);
		ch.setAmount(1000);
		ch.setCheckNumber("1235567890");
		repository.save(ch);
	}
}
