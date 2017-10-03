package com.kgfsl.homework.controller;
import com.kgfsl.homework.service.TaskService;
import com.kgfsl.homework.model.Task;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/tasklist")
public class TaskController {
	@Autowired
	private TaskService taskService;


@GetMapping("/get")public @ResponseBody ResponseEntity<List<Task>> findall() {
return new ResponseEntity<>(taskService.findAll1(), HttpStatus.OK);
}

  @GetMapping("/get/{taskId}")
    public @ResponseBody ResponseEntity<?> getById(@PathVariable Long TaskId) {

        Task task = taskService.findOne(TaskId);
        return new ResponseEntity<>(task, HttpStatus.OK);

    }
@PostMapping("/post")public ResponseEntity<?> post(@RequestBody Task Task, UriComponentsBuilder ucBuilder) {
taskService.save(Task);
HttpHeaders headers = new HttpHeaders();
headers.setLocation(ucBuilder.path("/get/{id}").buildAndExpand(Task.getId()).toUri());
return new ResponseEntity<>(headers, HttpStatus.CREATED);

}
@PutMapping("/put/{TaskId}")
public ResponseEntity<?> put(@PathVariable Long TaskId , @RequestBody Task Task) {
taskService.save(Task);
return new ResponseEntity<>(Task, HttpStatus.OK);
}

@DeleteMapping("/delete/{TaskId}")
public ResponseEntity<?> delete(@PathVariable Long TaskId) {
taskService.delete(TaskId);
return new ResponseEntity<>(HttpStatus.OK);
}

}
