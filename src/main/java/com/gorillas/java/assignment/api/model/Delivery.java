package com.gorillas.java.assignment.api.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "TB_DELIVERY")
@AllArgsConstructor
@NoArgsConstructor
public class Delivery {

	@Id
	@NotNull
	@Getter
	@Setter
	private long deliveryId;
	@Getter
	@Setter
	private String product;
	@Getter
	@Setter
	private String supplier;
	@Getter
	@Setter
	private long quantity;
	@Getter
	@Setter
	private String expectedDate;
	@Getter
	@Setter
	private String expectedWarehouse;

	public Delivery(int i) {

	}

}
