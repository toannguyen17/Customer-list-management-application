package com.controller;

import com.model.Customer;
import com.service.CustomerServide;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CustomerController {
	@Autowired
	private CustomerServide customerService;

	@GetMapping("customers")
	public String showList(Model model) {
		List<Customer> list = customerService.findAll();
		model.addAttribute("customers", list);
		return "customers/list";
	}

	@GetMapping("customers/{id}")
	public String showInformation(@PathVariable long id, Model model) {
		Customer customer = customerService.findOne(id);
		model.addAttribute("customer", customer);
		return "customers/info";
	}

	@PostMapping("customers/{id}")
	public String updateCustomer(@ModelAttribute Customer customer) {
		customerService.save(customer);
		return "redirect:/customers";
	}
}
