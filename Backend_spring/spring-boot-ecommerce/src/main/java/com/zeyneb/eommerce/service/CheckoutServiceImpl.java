package com.zeyneb.eommerce.service;

import java.util.Set;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.zeyneb.eommerce.dao.CustomerRepository;
import com.zeyneb.eommerce.dto.Purchase;
import com.zeyneb.eommerce.dto.PurchaseResponse;
import com.zeyneb.eommerce.entity.Customer;
import com.zeyneb.eommerce.entity.Order;
import com.zeyneb.eommerce.entity.OrderItem;

@Service
public class CheckoutServiceImpl implements CheckoutService {
	
	private CustomerRepository customerRepository;

    public CheckoutServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {

        // retrieve the order info from dto
        Order order = purchase.getOrder();

        // generate tracking number
        String orderTrackingNumber = generateOrderTrackingNumber();
        order.setOrderTrackingNumber(orderTrackingNumber);

        // populate order with orderItems
        Set<OrderItem> orderItems = purchase.getOrderItems();
        orderItems.forEach(item -> order.add(item));

        // populate order with billingAddress and shippingAddress
        order.setBillingAddress(purchase.getBillingAddress());
        order.setShippingAddress(purchase.getShippingAddress());

        // populate customer with order
        Customer customer = purchase.getCustomer();
        
        //check if this is an existing customer
        String email = customer.getEmail();
        
        Customer customerFromDB = customerRepository.findByEmail(email);
        
        if (customerFromDB != null) {
        	customer = customerFromDB;
        }
        
        customer.add(order);

        // save to the database
        customerRepository.save(customer);

        // return a response
        return new PurchaseResponse(orderTrackingNumber);  
    }

    private String generateOrderTrackingNumber() {

        // generate a random UUID number (UUID version-4)
        // For details see: https://en.wikipedia.org/wiki/Universally_unique_identifier
        // tracking number hard to guess: random / unique 
    	// UUID : Universally Unique IDentifier
        return UUID.randomUUID().toString();
    }

}
