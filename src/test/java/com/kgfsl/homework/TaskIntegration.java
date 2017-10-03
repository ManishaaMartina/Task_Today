package com.kgfsl.homework; 
import com.kgfsl.homework.TaskBuilder;
import com.kgfsl.homework.model.Task;
import com.kgfsl.homework.repository.TaskRepository;
import ch.qos.logback.core.net.SyslogOutputStream;
import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import org.apache.http.HttpStatus;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.TestPropertySource;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.matcher.ResponseAwareMatcher;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.RestAssured;
import java.util.ArrayList;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.boot.test.context.SpringBootTest;
import static com.jayway.restassured.RestAssured.when;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import static org.hamcrest.Matchers.*;

@RunWith(SpringRunner.class)
@ComponentScan(basePackages = "com.kgfsl.homework") 
@SpringBootTest(classes = homeworkApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@TestPropertySource(
  locations = "classpath:application.properties")

  public class TaskIntegration {
      private static final String NAME_FIELD = " name";
	private static final String name="cook";	
      private static final String Task_RESOURCE1 = "/tasklist/get";
  private static final String  Task_RESOURCE2 = "/tasklist/post";
   private static final String  Task_RESOURCE3 = "/tasklist/delete/{TaskId}";


private static final Task first=new TaskBuilder().id(1L).name("cook").status("completed").priority("first").iscompleted(true).build();
private static final Task second=new TaskBuilder().id(2L).name("study").status("completed").priority("third").iscompleted(true).build();
private static final Task third=new TaskBuilder().id(3L).name("cook").status("completed").priority("first").iscompleted(true).build();

 @Autowired
	private TaskRepository taskrepository;



	@Value("${local.server.port}")
	private int serverPort;
	private Task firstTask;
	private Task secondTask;
     private Task thirdTask;


	@Before
	public void setUp() {
		taskrepository.deleteAll();
		firstTask = taskrepository.saveAndFlush(first);
		secondTask= taskrepository.saveAndFlush(second);
	    thirdTask= taskrepository.saveAndFlush(third);
		RestAssured.port = serverPort;
	}
    @Test
	public void addTaskShouldReturnSavedTask() {
	given().body(third).contentType(ContentType.JSON).when().post(Task_RESOURCE2);
		System.out.println("addTaskShouldReturnSavedTask completed !!!");
	}
 

    @Test
 
    public void getItemsShouldReturnBothItems() {
        when().get(Task_RESOURCE1).then().statusCode(HttpStatus.SC_OK).body(NAME_FIELD,
                hasItems(name,name));
    }

    @Test
  public void deleteItemShouldReturnNoContent() {
        when().delete(Task_RESOURCE3,secondTask.getId()).then().statusCode(HttpStatus.SC_OK);
		System.out.println("deleted");
    }
	
}

  
  
	
	
	


	
   


	
    
  










