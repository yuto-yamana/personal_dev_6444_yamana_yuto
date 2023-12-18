package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Task;

public interface TaskRepository extends JpaRepository<Task,Integer> {
	
	List<Task> findByGoalId(Integer goalId);

	void save(Integer num);
	
	List<Task>findByGoalIdOrderByIdAsc(Integer goalId);
	
	

}
