package ibf2022.paf.assessment.server.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;

// TODO: Task 4, Task 8

public class TasksController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @GetMapping
    public void method(){
        logger.info("Starting logger");
    }
    

    
}
