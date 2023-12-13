package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Goal;
import com.example.demo.repository.GoalRepository;
@Controller
public class GoalsController {
	
	@Autowired
	GoalRepository goalRepository;
		
//  目標一覧画面表示	
	@GetMapping("/goals")
	public String index(Model model) {
		List<Goal>goalList = goalRepository.findAll();
		model.addAttribute("goals",goalList);
		return "goal";
	}
	
	
//  登録画面遷移	
	@GetMapping("/goals/add")
	public String addGoal() {
		return "addGoal";
	}
	
//  目標登録処理
	@PostMapping("/goals/add")
	public String createGoal(
		@RequestParam(value = "name" , defaultValue = "")String name,
		Model model){
		
		Goal goals = new Goal(name);
		
		goalRepository.save(goals);
		
		return "redirect:/goals";
	}
	
// 　編集画面表示　
	@GetMapping("/goals/{id}/edit")
	public String editGoal(@PathVariable("id") Integer id,Model model) {
		
		Goal goals = goalRepository.findById(id).get();
		model.addAttribute("goal",goals);
		return "editGoal";
	}

//  更新処理	
	@PostMapping("/goals/{id}/edit")
	public String updateGoal(
			@PathVariable("id")Integer id,
			@RequestParam(value="name", defaultValue="")String name,
			Model model) {
		
		Goal goals = new Goal(id, name);
		goalRepository.save(goals);
		return "redirect:/goals";
		
	}
	
// 　削除処理
		
	
	@PostMapping("/goals/{id}/delete")
	public String deleteGoal(@PathVariable("id") Integer id,Model model) {
		
		goalRepository.deleteById(id);
		
		return "redirect:/goals";
	}
	

	
	

	}
	
	
	
	

	

