package com.example.customer.testCustomerController;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.customer.controller.CustomerController;
import com.example.customer.model.Address;
import com.example.customer.model.Customer;
import com.example.customer.service.CustomerService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(CustomerController.class)
public class CustomerControllerTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	CustomerService cs;

	@Test
	public void getCustomerByIdTest() throws Exception {

		mvc.perform(MockMvcRequestBuilders
				.get("/v1/customer/{id}", "1")
				.accept(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk());
	}

	@Test
	public void createCustomerTest() throws Exception {
		Address address = new Address("12", "madiwala", "maruthi nagar", "banglore", "karnatka", "india", 560095);
		Customer customer = new Customer(null, "Abhishek", "abhi@gmail.com", 9458222571L, address);
		mvc.perform(MockMvcRequestBuilders
				.post("/v1/customer/")
				.content(asJsonString(customer))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
			    .andDo(print())
			    .andExpect(status().isOk());
	}

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} 
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
