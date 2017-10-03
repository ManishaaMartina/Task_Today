package com.kgfsl.homework;
import com.kgfsl.homework.model.*;
public class TaskBuilder {
  private Task t1 = new Task();
  
  public TaskBuilder id(long id) {
	  t1.setId(id);
    return this;
  }
public TaskBuilder name(String name) {
	  t1.setName(name);
    return this;
  }
  public TaskBuilder status(String status) {
	  t1.setStatus(status);
    return this;
  }
  public TaskBuilder priority(String priority) {
	  t1.setPriority(priority);
    return this;
  }
  
 public TaskBuilder iscompleted(Boolean isCompleted) {
	 t1.setIsCompleted(isCompleted);
    return this;
}
  public Task build() {
    return t1;
  }
}
