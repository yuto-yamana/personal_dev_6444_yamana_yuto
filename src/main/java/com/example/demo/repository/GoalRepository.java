package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Goal;

public interface GoalRepository extends JpaRepository<Goal, Integer> {

	List<Goal> findAllByOrderByIdAsc();

}
