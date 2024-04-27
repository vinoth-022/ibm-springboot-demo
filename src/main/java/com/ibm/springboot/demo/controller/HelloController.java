package com.ibm.springboot.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
@RequestMapping("hello")

public class HelloController {

	@GetMapping("hi")  //this works only near a function
	public String hi() {
		System.out.println("Hello class");
		return "Hello world!";
	}
	
	@GetMapping("hi1")
	public String hello() {
		System.out.println("Hello 1111");
		return "hi world!";
	}
	
	
	
}
