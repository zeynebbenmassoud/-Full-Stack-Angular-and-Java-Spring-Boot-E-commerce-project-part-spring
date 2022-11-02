package com.zeyneb.eommerce.dto;

import java.util.Set;

import com.zeyneb.eommerce.entity.Address;
import com.zeyneb.eommerce.entity.Customer;
import com.zeyneb.eommerce.entity.Order;
import com.zeyneb.eommerce.entity.OrderItem;

import lombok.Data;

@Data
public class Purchase {
	
	private Customer customer;
    private Address shippingAddress;
    private Address billingAddress;
    private Order order;
    private Set<OrderItem> orderItems;

}
