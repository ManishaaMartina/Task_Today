package com.kgfsl.homework.model;

import javax.persistence.*;

@Entity
public class Task {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Task_ID")
	private Long id;
	@Column(name = "Task_NAME")
	private String name;
	@Column(name = "Task_STATUS")
	private String status;
	@Column(name = "Task_PRIORITY")
	private String priority;
	@Column(name = "Task_COMPLETD")
	private Boolean isCompleted;

	public Task() {
		super();
		// Task Auto-generated constructor stub
	}

	public Task(String name, String status, String priority, Boolean isCompleted) {
		super();
		this.name = name;
		this.status = status;
		this.priority = priority;
		this.isCompleted = isCompleted;
	}

	public long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public Boolean getIsCompleted() {
		return isCompleted;
	}

	public void setIsCompleted(Boolean isCompleted) {
		this.isCompleted = isCompleted;
	}

}