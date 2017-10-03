package com.kgfsl.homework.service;

import com.kgfsl.homework.model.Task;
import java.util.List;


public interface TaskService {

    public List<Task> findAll1();

    public Task save(Task task);

    public Task findOne(long id);
	 

    public void delete(Long id);

}

