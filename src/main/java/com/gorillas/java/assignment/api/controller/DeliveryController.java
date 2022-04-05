package com.gorillas.java.assignment.api.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gorillas.java.assignment.api.model.Delivery;
import com.gorillas.java.assignment.api.service.DeliveryService;

@RestController
@RequestMapping("api")
@Validated
public class DeliveryController {

	@Autowired
	DeliveryService deliveryService;

	@PostMapping(path = "/saveDelivery")
	public ResponseEntity<List<Delivery>> saveDelivery(@RequestBody List<Delivery> delivery) {
		return ResponseEntity.status(HttpStatus.CREATED).body(deliveryService.addDeliveries(delivery));
	}

	@GetMapping("/deliveries")
	public ResponseEntity<List<Delivery>> getAllDeliveries() {
		return ResponseEntity.status(HttpStatus.OK).body(deliveryService.getAllDeliveries());
	}

	@GetMapping("/delivery/{id}")
	public ResponseEntity<Delivery> getDelivery(
			@PathVariable("id")
			@NotNull(message = "Delivery id cannot be null")
			@Min(value = 2, message = "Please provide non negative id")
			 long id) throws Exception {
		return ResponseEntity.status(HttpStatus.OK).body(deliveryService.getDeliveryById(id));
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteDelivery(
			@PathVariable long id) {
		deliveryService.deleteDeliveryById(id);
		return ResponseEntity.status(HttpStatus.OK).body("Delivery with Id : " + id + " has been deleted successfully");
	}

	@PutMapping(value = "/updateQuantity/{id}")
	ResponseEntity<String> updateQuantity(
			@PathVariable("id")
			@NotNull(message = "Delivery id cannot be null")
			@Min(value = 2, message = "Please provide non negative id")
			 long id,
			
			@Valid
			@RequestBody Delivery delivery) {
		deliveryService.updateQuantity(id, delivery);
		return ResponseEntity.status(HttpStatus.OK).body("Delivery with Id : " + id + " has been updated successfully");
	}

}
