package com.example.demo.controller;

import org.springframework.stereotype.Controller;

@Controller
public class GoalController {
	public String index() {
		return "/goals";
	}

}
