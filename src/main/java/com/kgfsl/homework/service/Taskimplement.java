package com.kgfsl.homework.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kgfsl.homework.model.Task;
import com.kgfsl.homework.repository.TaskRepository;

@Service("TaskService")
public class Taskimplement implements TaskService{

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public List<Task> findAll1() {
        // Task Auto-generated method stub
        return taskRepository.findAll();
    }

    @Override
    public Task save(Task Task) {
        // Task Auto-generated method stub
        return taskRepository.saveAndFlush(Task);

    }

    @Override
    public Task findOne(long id) {
        // Task Auto-generated method stub
        return taskRepository.findOne(id);
    }

    @Override
    public void delete(Long id) {
        // Task Auto-generated method stub
        taskRepository.delete(id);
    }

}




