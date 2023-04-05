package ibf2022.paf.assessment.server.controllers;

import java.sql.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ibf2022.paf.assessment.server.services.TodoService;

// TODO: Task 4, Task 8

@RestController
public class TasksController {
    @Autowired
    TodoService todoSvc;

    private Logger logger = LoggerFactory.getLogger(getClass());

    // "request body Result: 
    // {username=[fred], description-0=[item 1], priority-0=[1], dueDate-0=[2023-04-12], description-1=[item 2], priority-1=[2], dueDate-1=[2023-04-19]}"

    @PostMapping(path="/task", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseEntity<String> postTask(@RequestBody MultiValueMap<String,String> form){
        logger.info("Starting logger");

        // String date = form.getFirst("dueDate-0");

        int rows = todoSvc.upsertTask(form);
        

        return ResponseEntity.ok().body("%d rows inserted".formatted(rows));
    }
    

    
}
