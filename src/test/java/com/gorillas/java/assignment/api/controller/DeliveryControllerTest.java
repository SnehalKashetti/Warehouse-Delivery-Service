package com.gorillas.java.assignment.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gorillas.java.assignment.api.model.Delivery;
import com.gorillas.java.assignment.api.service.DeliveryService;



@ExtendWith(SpringExtension.class)
@WebMvcTest(DeliveryController.class)
public class DeliveryControllerTest {

	 @Autowired
	    MockMvc mockMvc;
	    @Autowired
	    ObjectMapper mapper;
	    @MockBean
	    DeliveryService deliverService;

	    Delivery delivery = new Delivery(101, "Bananas", "JungleInc", 1000000, "2027-01-08T07:17:48.237Z", "TheMoon");
	    List<Delivery> deliveries;

	    @SuppressWarnings({ "rawtypes", "unchecked" })
		@BeforeEach
	    void setUp() {
	        deliveries = new ArrayList();
	        deliveries.add(delivery);
	    }

	    @SuppressWarnings("unused")
		@Test
	    void testGetAllDeliveries() throws Exception {
	        Mockito.when(deliverService.getAllDeliveries()).thenReturn(deliveries);
	        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
	                .get("/api/getAllDeliveries")
	                .contentType(MediaType.APPLICATION_JSON)).andReturn();
	        MockHttpServletResponse res = mvcResult.getResponse();
	        String outputJason = res.getContentAsString();
	    }
	    
}
