package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tasks")
public class Task {


	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id; //タスクID
	private String name; //タスク名
	@Column(name = "goal_id")
	private Integer goalId; //目標ID
	private Integer num; // カウント数
	
	
    public Task() {
    	
    }

	public Task(Integer id,Integer num, Integer goalId,String name) {
    	this.id=id;
    	this.num=num;
    	this.goalId=goalId;
    	this.name=name;
    }
    
    
    public Task(String name,Integer goalId,Integer num) {
    	this.name=name;
    	this.goalId=goalId;
    	this.num=num;
    }

    public Task(Integer id,String name,Integer goalId,Integer num) {
    	this.id=id;
    	this.name=name;
    	this.goalId=goalId;
    	this.num=num;
    }
	
	
	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Integer getGoalId() {
		return goalId;
	}

	public Integer getNum() {
		return num;
	}

public void setId(Integer id) {
	this.id = id;
}
public void setName(String name) {
	this.name = name;
}
public void setGoalId(Integer goalId) {
	this.goalId = goalId;
}
public void setNum(Integer num) {
	this.num = num;
}
}
