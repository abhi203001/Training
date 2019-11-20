package com.example.customer.testService;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.test.context.junit4.SpringRunner;

import com.example.customer.model.Address;
import com.example.customer.model.Customer;
import com.example.customer.repository.CustomerRepository;
import com.example.customer.service.CustomerService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerServiceTest {

	@Autowired
	CustomerService cs;

	@MockBean
	CustomerRepository cr;

	@Test
	public void getCustomerByIdTest() {
		String id = "124";
		Address address = new Address("12", "madiwala", "maruthi nagar", "banglore", "karnatka", "india", 560095);
		Customer customer = new Customer("124", "Abhishek", "abhi@gmail.com", 9458222571L, address);
		Optional<Customer> c = Optional.ofNullable(customer);
		Mockito.when(cr.findById(customer.getCid())).thenReturn(c);
		assertEquals(c, cs.getCustomerById(id));

	}

	@Test
	public void createCustomerTest() {
		Address address = new Address("12", "madiwala", "maruthi nagar", "banglore", "karnatka", "india", 560095);
		Customer customer = new Customer("124", "Abhishek", "abhi@gmail.com", 9458222571L, address);
		Mockito.when(cr.save(customer)).thenReturn(customer);
		assertEquals(customer, cs.createCustomer(customer));
	}

}
