package ibf2022.paf.assessment.server.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

import ibf2022.paf.assessment.server.services.TodoService;

// TODO: Task 4, Task 8

@Controller
public class TasksController {
    @Autowired
    TodoService todoSvc;

    private Logger logger = LoggerFactory.getLogger(getClass());

    // "request body Result: 
    // {username=[fred], description-0=[item 1], priority-0=[1], dueDate-0=[2023-04-12], description-1=[item 2], priority-1=[2], dueDate-1=[2023-04-19]}"

    @PostMapping(path="/task", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ModelAndView postTask(@RequestBody MultiValueMap<String,String> form, Model model){
        logger.info(">>> Running upsertTask service");
        int rows = todoSvc.upsertTask(form);
        logger.info(">>> upsertTask complete, %d rows inserted".formatted(rows));
        
        ModelAndView mav = new ModelAndView();

        if(rows>0){
            mav.setViewName("result.html");
            mav.addObject("taskCount", rows);
            mav.addObject("username", form.getFirst("username"));
            mav.setStatus(HttpStatusCode.valueOf(200));
        } else{
            mav.setViewName("error.html");
            mav.setStatus(HttpStatusCode.valueOf(500));
        }
        
        return mav;
    }
}
