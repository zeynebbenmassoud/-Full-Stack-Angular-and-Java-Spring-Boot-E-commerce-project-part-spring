package com.zeyneb.eommerce.dto;

import lombok.Data;
import lombok.NonNull;

@Data
public class PurchaseResponse {

	@NonNull
	private String orderTrackingNumber;
	

	public PurchaseResponse(String orderTrackingNumber2) {
		this.orderTrackingNumber = orderTrackingNumber2; 
	}
}
