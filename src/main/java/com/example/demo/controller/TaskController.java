package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Task;
import com.example.demo.repository.TaskRepository;

@Controller
public class TaskController {

	@Autowired
	TaskRepository taskRepository;

	@GetMapping("/tasks")
	public String index(@RequestParam("goal_id") Integer goalId, Model model) {

		List<Task> task = taskRepository.findByGoalIdOrderByIdAsc(goalId);
		model.addAttribute("goalId", goalId);
		model.addAttribute("tasks", task);

		return "tasks";
	}

	@PostMapping("/tasks/{id}/increaseNum")
	public String increaseNum(@PathVariable("id") Integer id,
			@RequestParam("goal_id") Integer goalId) {

		Task task = taskRepository.findById(id).get();
		Integer newNum = task.getNum() + 1;
		task.setNum(newNum);
		taskRepository.save(task);

		return "redirect:/tasks?goal_id=" + goalId;

	}

	//  登録画面遷移	
	@GetMapping("/tasks/add")
	public String addTask(@RequestParam("goal_id") Integer goalId, Model model) {

		model.addAttribute("goalId", goalId);
		return "addTask";
	}

	//   ToDo登録処理
	@PostMapping("/tasks/add")
	public String createTask(
			@RequestParam(value = "name", defaultValue = "") String name,
			@RequestParam("goal_id") Integer goalId,
			Model model) {

		Task task = new Task(name, goalId, 0);

		taskRepository.save(task);

		return "redirect:/tasks?goal_id=" + goalId;

	}

	//　 ToDo編集画面表示
	@GetMapping("/tasks/{id}/edit")
	public String editTask(@PathVariable("id") Integer id,
			@RequestParam("goal_id") Integer goalId,
			Model model) {
		Task task = taskRepository.findById(id).get();
		model.addAttribute("task", task);
		model.addAttribute("goalId", goalId);
		return "editTask";

	}

	//   更新処理
	@PostMapping("/tasks/{id}/edit")
	public String updateTask(
			@PathVariable("id") Integer id,
			@RequestParam("goal_id") Integer goalId,
			@RequestParam(value = "name", defaultValue = "") String name,
			@RequestParam(value = "num", defaultValue = "") Integer num,
			Model model) {

		Task task = new Task(id, name, goalId, num);
		taskRepository.save(task);
		return "redirect:/tasks?goal_id=" + goalId;
	}

	//削除処理

	@PostMapping("/tasks/{id}/delete")
	public String deleteTask(@PathVariable("id") Integer id,
			@RequestParam("goal_id") Integer goalId,
			Model model) {

		taskRepository.deleteById(id);

		return "redirect:/tasks?goal_id=" + goalId;

	}
}
