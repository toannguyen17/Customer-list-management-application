package com.service.impl;

import com.model.Customer;
import com.service.CustomerServide;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

public class CustomerServiceImpl implements CustomerServide {
	private static List<Customer> customers;
	private static long autoIncreaseId = 0;

	static {
		customers = asList(
			new Customer(1, "Nguyen van toan", "toan@gmail.com", "Vinh Phuc"),
			new Customer(2, "Nguyen van toan", "toan@gmail.com", "Vinh Phuc"),
			new Customer(3, "Nguyen van toan", "toan@gmail.com", "Vinh Phuc")
		);
	}

	@Override
	public List<Customer> findAll() {
		return new ArrayList<>(customers);
	}

	@Override
	public Customer findOne(long id) {
		return customers.stream()
				.filter(c -> c.getId() == id)
				.findFirst()
				.orElse(null);
	}

	@Override
	public Customer save(Customer customer) {
		return customer.getId() == 0 ? persist(customer) : merge(customer);
	}

	@Override
	public List<Customer> save(List<Customer> customers) {
		return customers.stream()
				.map(this::save)
				.collect(Collectors.toList());
	}

	@Override
	public boolean exists(long id) {
		return customers.stream().anyMatch(c -> c.getId() == id);
	}

	@Override
	public List<Customer> findAll(List<Long> ids) {
		return ids.stream()
				.map(this::findOne)
				.collect(Collectors.toList());
	}

	@Override
	public long count() {
		return customers.size();
	}

	@Override
	public void delete(long id) {
		customers.removeIf(c -> c.getId() == id);
	}

	@Override
	public void delete(Customer customer) {
		delete(customer.getId());
	}

	@Override
	public void delete(List<Customer> customers) {
		customers.forEach(this::delete);
	}

	@Override
	public void deleteAll() {
		customers = new ArrayList<>();
	}

	private Customer persist(Customer customer) {
		customer.setId(++autoIncreaseId);
		customers.add(customer);
		return customer;
	}

	private Customer merge(Customer customer) {
		Customer origin = findOne(customer.getId());
		origin.setName(customer.getName());
		origin.setEmail(customer.getEmail());
		origin.setAddress(customer.getAddress());
		return origin;
	}
}
