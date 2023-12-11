package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="goals")
public class Goal {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	
	
//	コンストラクタ
	public Goal() {
	}
	
	public Goal(String name) {
		this.name=name;
	}
	
	public Goal(Integer id, String name) {
		this.id=id;
		this.name=name;
	}
	
	
//	ゲッター
	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

}
