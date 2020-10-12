package com.example.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.entity.Address;
import com.example.entity.Email;
import com.example.entity.User;
import com.example.repository.AddressRepository;
import com.example.repository.EmailRepository;
import com.example.repository.UserRepository;

@RestController
public class BaseController {
	@Autowired
	EmailRepository emailRepository;
	@Autowired
	AddressRepository addressRepository;
	@Autowired
	UserRepository userRepository;

//	@RequestMapping(value = "/", method = RequestMethod.GET)
//	public String welcome(Model model) {
//		String message = "Hello Spring Boot + JSP";
//		model.addAttribute("message", message);
//		return "index";
//	}
//
//	@RequestMapping(value = "/test", method = RequestMethod.GET)
//	public String test() {
//		Email email = new Email("abc@.gmail.com");
//		emailRepository.save(email);
//		return "success";
//
//	}

	@PostMapping("/saveEmail")
	public ResponseEntity<Email> createEmail(@RequestBody Email email, UriComponentsBuilder builder) {
		emailRepository.save(email);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/saveEmail/{id}").buildAndExpand(email.getId()).toUri());
		return new ResponseEntity<>(email, HttpStatus.CREATED);
	}
	@PostMapping("/saveAddress")
	public ResponseEntity<Address> createAddress(@RequestBody Address address, UriComponentsBuilder builder) {
		addressRepository.save(address);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/saveAddress/{id}").buildAndExpand(address.getId()).toUri());
		return new ResponseEntity<>(address, HttpStatus.CREATED);
	}
	@PostMapping("/saveUser")
	public ResponseEntity<User> createUser(@RequestBody User user, UriComponentsBuilder builder) {
		userRepository.save(user);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/saveUser/{id}").buildAndExpand(user.getId()).toUri());
		return new ResponseEntity<>(user, HttpStatus.CREATED);
	}


//	@RequestMapping(value = "/test1", method = RequestMethod.GET)
//	public String test1() {
//		Address address = new Address("TP.HCM");
//		Set<User> users = new HashSet<>();
//		users.add(new User(new Email("a@gmail.com")));
//		users.add(new User(new Email("b@gmail.com")));
//		address.setUsers(users);
//		addressRepository.save(address);
//		return "success";
//
//	}
//
//	@RequestMapping(value = "/test2", method = RequestMethod.GET)
//	public String test2() {
//		User user = new User(new Email("sa@gmail.com"));
//		Set<Address> address = new HashSet<>();
//		address.add(new Address("DN"));
//		address.add(new Address("HN"));
//		user.setAddress(address);
//		userRepository.save(user);
//		return "success";
//
//	}
//
//	@RequestMapping(value = "/test3", method = RequestMethod.GET)
//	public String test3() {
//		emailRepository.findAll();
//		return "success";
//
//	}
}
