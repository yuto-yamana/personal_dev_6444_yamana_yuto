package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.repository.TaskRepository;

@Controller
public class TaskController {
	
	@Autowired
	TaskRepository taskRepository;
	
	@GetMapping("/tasks")
	public String index(@RequestParam("goal_id")Integer goalsId,Model model) {
		
		model.addAttribute("tasks",taskRepository.findByGoalId(goalsId));
		
		return "tasks";
	}
		
	}
	
	
	

