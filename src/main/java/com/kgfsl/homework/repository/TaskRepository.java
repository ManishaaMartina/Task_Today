package com.kgfsl.homework.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kgfsl.homework.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {



}