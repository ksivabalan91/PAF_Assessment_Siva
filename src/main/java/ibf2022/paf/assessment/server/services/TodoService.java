package ibf2022.paf.assessment.server.services;

import java.sql.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

import ibf2022.paf.assessment.server.models.Task;
import ibf2022.paf.assessment.server.models.User;
import ibf2022.paf.assessment.server.repositories.TaskRepository;
import ibf2022.paf.assessment.server.repositories.UserRepository;

// TODO: Task 7
@Service
public class TodoService {

    @Autowired
    UserRepository userRepo;

    @Autowired
    TaskRepository taskRepo;

    Logger logger = LoggerFactory.getLogger(getClass());

     // "request body Result: 
    // {username=[fred], description-0=[item 1], priority-0=[1], dueDate-0=[2023-04-12], description-1=[item 2], priority-1=[2], dueDate-1=[2023-04-19]}"
    public int upsertTask(MultiValueMap<String,String> form){
        
        String username = form.getFirst("username");
        String userId = "";
        
        Optional<User> user = userRepo.findUserByUSername(username);
        if(!user.isPresent()){
            User newUser = new User();
            newUser.setUsername(username);
            userId = userRepo.insertUser(newUser);
        }else{
            userId = user.get().getUserId();
        }
        
        List<Task> tasks = new LinkedList<>();
        for(int i =0; i< (form.keySet().size()-1)/3; i++){

            logger.info(">>>> printing task from todo service loop");
            logger.info(form.getFirst("description-"+i));
            logger.info(form.getFirst("priority-"+i));
            logger.info(form.getFirst("dueDate-"+i));            
            
            Task newTask = new Task();
            newTask.setDueDate(Date.valueOf(form.getFirst("dueDate-"+i)));
            newTask.setPriority(Integer.parseInt(form.getFirst("priority-"+i)));
            newTask.setTaskDescription(form.getFirst("description-"+i));
            newTask.setUserId(userId);
            tasks.add(newTask);
        }
        int tasksInserted =  taskRepo.insertTask(tasks);

        return tasksInserted;
    }
}
