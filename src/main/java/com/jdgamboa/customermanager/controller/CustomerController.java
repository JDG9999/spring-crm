package com.jdgamboa.customermanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jdgamboa.customermanager.entity.Customer;
import com.jdgamboa.customermanager.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
	public String listCustomers(Model model) {
		List<Customer> customers = customerService.getCustomers();
		model.addAttribute("customers", customers);
		return "list-customers";
	}
	
	@GetMapping("/add-customer")
	public String showFormForAdd(Model model) {
		Customer customer = new Customer();
		model.addAttribute("customer", customer);
		return "customer-form";
	}
	
	@GetMapping("/update-customer")
	public String showFormForUpdate(@RequestParam("customerId") int id, Model model) {
		Customer customer = customerService.getCustomer(id);
		model.addAttribute("customer", customer);
		return "customer-form";
	}
	
	@PostMapping("/save-customer")
	public String saveCustomer(@ModelAttribute("customer") Customer customer) {
		customerService.saveCustomer(customer);
		return "redirect:/customer/list";
	}
	
	@GetMapping("/delete-customer")
	public String deleteCustomer(@RequestParam("customerId") int id) {
		customerService.deleteCustomer(id);
		return "redirect:/customer/list";
	}
		
}
