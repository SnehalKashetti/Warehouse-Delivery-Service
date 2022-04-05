package com.gorillas.java.assignment.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gorillas.java.assignment.api.exception.DeliveryApiRequestException;
import com.gorillas.java.assignment.api.model.Delivery;
import com.gorillas.java.assignment.api.repository.DeliveryRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DeliveryService {

	@Autowired
	private DeliveryRepository deliveryRepository;

	public Delivery getDeliveryById(long id) {
		return deliveryRepository.findById(id)
				.orElseThrow(() -> new DeliveryApiRequestException("Delivery with Id " + id + " not found!"));
	}

	public List<Delivery> addDeliveries(List<Delivery> deliveries) {
		return deliveryRepository.saveAll(deliveries);
	}

	public List<Delivery> getAllDeliveries() throws DeliveryApiRequestException {
		List<Delivery> deliveries = deliveryRepository.findAll();
		if (deliveries.isEmpty()) {
			throw new DeliveryApiRequestException("No deliveries at the moment");
		}
		return deliveries;
	}

	public void deleteDeliveryById(long id) throws RuntimeException {
		deliveryRepository.findById(id)
				.orElseThrow(() -> new DeliveryApiRequestException("Delivery with Id " + id + " not found!"));
		deliveryRepository.deleteById(id);
	}

	public Delivery updateQuantity(long id, Delivery delivery) throws DeliveryApiRequestException {
		Delivery existingDelivery = deliveryRepository.findById(id)
				.orElseThrow(() -> new DeliveryApiRequestException("Delivery with Id :" + id + " not found!"));
		existingDelivery.setQuantity(delivery.getQuantity());
		deliveryRepository.save(existingDelivery);
		return existingDelivery;
	}

}
