package com.zeyneb.eommerce.service;

import com.zeyneb.eommerce.dto.Purchase;
import com.zeyneb.eommerce.dto.PurchaseResponse;

public interface CheckoutService {
	
	PurchaseResponse placeOrder(Purchase purchase);
	
}
