package com.kgfsl.homework;
import com.kgfsl.homework.model.Task;

import java.util.*;


public class TaskConn

{
   
public  List<Task> testmethod()
{
   
 
     Task a1=new TaskBuilder().name("Jesus").status("completed").priority("first").iscompleted(true).build();
     Task a2=new TaskBuilder().name("Mary").status("completed").priority("second").iscompleted(true).build();

     ArrayList<Task> t2=new ArrayList<Task> ();


     t2.add(a1);
     t2.add(a2);
     return t2;
}

public  Task testmethod1()
{
   
 
     Task a1=new TaskBuilder().name("Jesus").status("completed").priority("first").iscompleted(true).build();
    /* Task a2=new TaskBuilder().name("Mary").status("completed").priority("second").iscompleted(true).build();

     ArrayList<Task> t2=new ArrayList<Task> ();


     t2.add(a1);
     t2.add(a2);*/
     return a1;
}

}