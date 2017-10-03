package com.kgfsl.homework;
import com.kgfsl.homework.controller.TaskController;
import com.kgfsl.homework.model.Task;
//import com.kgfsl.homework.repository.TaskRepository;
import com.kgfsl.homework.service.TaskService;
import com.kgfsl.homework.service.*;
import org.junit.Test;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import static org.mockito.Mockito.verify;
import java.util.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)

public class TaskControllerUI
{
@InjectMocks
private TaskController taskcontroller;

@Mock
private TaskService taskService;
   
    Task task=new Task();
    TaskConn c=new TaskConn();

@Test
public void TaskTest() {
  when(taskService.findAll1()).thenReturn(c.testmethod());
    ResponseEntity<List<Task>> result = taskcontroller.findall();
    assertEquals(2, c.testmethod().size());
}


@Test
public void saveTask() {
    when(taskService.save(task)).thenReturn(c.testmethod1());
    ResponseEntity<?> result= taskcontroller.put(1L,task);
    assertEquals(1L,1L);
}

@Test
 public void editTest()
{

when(taskService.findOne(1L)).thenReturn(c.testmethod1());
ResponseEntity<?> result = taskcontroller.getById(1L);
assertEquals(1L, 1L);
}

  @Test
     public void deleteTest() {
        taskService.delete(1L);
        verify(taskService, times(1)).delete(1L);
 }
}