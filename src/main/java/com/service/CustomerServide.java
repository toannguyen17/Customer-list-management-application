package com.service;

import com.model.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public interface CustomerServide {
	List<Customer> findAll();

	Customer findOne(long id);

	public Customer save(Customer customer);

	public List<Customer> save(List<Customer> customers) ;

	public boolean exists(long id);

	public List<Customer> findAll(List<Long> ids);

	public long count();

	public void delete(long id);

	public void delete(Customer customer);

	public void delete(List<Customer> customers);

	public void deleteAll();
}
