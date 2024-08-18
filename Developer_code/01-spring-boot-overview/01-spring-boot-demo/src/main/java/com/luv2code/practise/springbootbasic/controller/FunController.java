package com.luv2code.practise.springbootbasic.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunController {

	@GetMapping("/")
	public String hellowWorld() {
		return "Hello World";
	}
}
