package com.zeyneb.eommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zeyneb.eommerce.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

	Customer findByEmail(String email);
}