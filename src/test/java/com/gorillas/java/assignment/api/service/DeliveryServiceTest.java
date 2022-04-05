package com.gorillas.java.assignment.api.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.gorillas.java.assignment.api.exception.DeliveryApiRequestException;
import com.gorillas.java.assignment.api.model.Delivery;
import com.gorillas.java.assignment.api.repository.DeliveryRepository;

@ExtendWith(MockitoExtension.class)
class DeliveryServiceTest {

	@Mock
	private DeliveryRepository deliveryRepository;

	private DeliveryService deliveryServiceMock;

	@BeforeEach
	void setUp() {
		deliveryServiceMock = new DeliveryService(deliveryRepository);
	}

	@Test
	void testGetDeliveryById() {
		Optional<Delivery> delivery = Optional
				.of(new Delivery(101, "Bananas", "JungleInc", 1000000, "2027-01-08T07:17:48.237Z", "TheMoon"));
		long deliveryId = 101;
		
		when(deliveryRepository.findById(deliveryId)).thenReturn(delivery);

		deliveryServiceMock.getDeliveryById(deliveryId);
		verify(deliveryRepository).findById(deliveryId);

	}

	@Test
	void testAddDeliveries() {
		List<Delivery> deliveries = new ArrayList<>();
		deliveries.add(new Delivery(101, "Bananas", "JungleInc", 1000000, "2027-01-08T07:17:48.237Z", "TheMoon"));
		deliveries.add(new Delivery(102, "Saiyans", "Bardock", 9001, "2019-10-10T09:08:11.098Z", "Namek"));
		deliveries.add(new Delivery(103, "Skull, Crystal", "Akator", 1, "2008-05-22T00:00:00.001Z", "Headquarters"));
		// when
		when(deliveryRepository.saveAll(deliveries)).thenReturn(deliveries);
		List<Delivery> deliveryList = deliveryServiceMock.addDeliveries(deliveries);
		// then
		@SuppressWarnings("unchecked")
		ArgumentCaptor<List<Delivery>> deliveryArgumentCaptor = ArgumentCaptor.forClass(List.class);
		verify(deliveryRepository).saveAll(deliveryArgumentCaptor.capture());
		List<Delivery> capturedDeliveries = deliveryArgumentCaptor.getValue();
		assertThat(capturedDeliveries).isEqualTo(capturedDeliveries);
		assertEquals(3, deliveryList.size());
	}

	@Test
	void testGetAllDeliveries() {
		Delivery delivery = new Delivery(101, "Bananas", "JungleInc", 1000000, "2027-01-08T07:17:48.237Z", "TheMoon");
		List<Delivery> deliveries = new ArrayList<>();
		deliveries.add(delivery);
		// when
		Mockito.when(deliveryRepository.findAll()).thenReturn(deliveries);
		deliveryServiceMock.getAllDeliveries();
		// then
		verify(deliveryRepository).findAll();
	}

	@Test
	void willThrowExceptionIfNoUsers() throws Throwable {
		List<Delivery> deliveries = new ArrayList<>();
		// when
		Mockito.when(deliveryRepository.findAll()).thenReturn(deliveries);
		// then
		assertThatThrownBy(() -> deliveryServiceMock.getAllDeliveries()).isInstanceOf(DeliveryApiRequestException.class)
				.hasMessageContaining("No deliveries at the moment");
		verify(deliveryRepository).findAll();
	}

	@Test
	void testDeleteDeliveryById() {
		Optional<Delivery> delivery = Optional
				.of(new Delivery(101, "Bananas", "JungleInc", 1000000, "2027-01-08T07:17:48.237Z", "TheMoon"));
		long deliveryId = 101;
		// when
		Mockito.when(deliveryRepository.findById(deliveryId)).thenReturn(delivery);
		deliveryServiceMock.deleteDeliveryById(deliveryId);
		// then
		ArgumentCaptor<Long> deliveryIdCapture = ArgumentCaptor.forClass(Long.class);
		verify(deliveryRepository).deleteById(deliveryIdCapture.capture());
		long capturedDeliveryId = deliveryIdCapture.getValue();
		assertThat(capturedDeliveryId).isEqualTo(deliveryId);
	}

	@SuppressWarnings("deprecation")
	@Test
	void testUpdateQuantity() {
		Optional<Delivery> delivery = Optional
				.of(new Delivery(101, "Bananas", "JungleInc", 1000000, "2027-01-08T07:17:48.237Z", "TheMoon"));
		long deliveryId = 101;
		Delivery updatedDelivery = new Delivery(101, "Bananas", "JungleInc", 123456, "2027-01-08T07:17:48.237Z",
				"TheMoon");
		// when
		when(deliveryRepository.findById(deliveryId)).thenReturn(delivery);
		deliveryServiceMock.updateQuantity(deliveryId, updatedDelivery);
		// then
		ArgumentCaptor<Delivery> deliveryArgumentCaptor = ArgumentCaptor.forClass(Delivery.class);
		verify(deliveryRepository).save(deliveryArgumentCaptor.capture());
		Delivery capturedDelivery = deliveryArgumentCaptor.getValue();
		assertThat(capturedDelivery).isEqualToComparingFieldByField(capturedDelivery);
	}

}
