package ibf2022.paf.assessment.server.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

// TODO: Task 4, Task 8

@RestController
public class TasksController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @PostMapping(path="/task", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseEntity<String> postTask(@RequestBody MultiValueMap<String,String> form){
        logger.info("Starting logger");
        
    }
    

    
}
