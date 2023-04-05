package ibf2022.paf.assessment.server.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import ibf2022.paf.assessment.server.models.Task;

// TODO: Task 6

@Repository
public class TaskRepository extends BasicCrud{
    
    // insert into task(user_id, task_description, priority,due_date) values (?,?,?,?)
    public int insertTask(List<Task> tasks){
        int tasksInserted=0;
        for(Task t: tasks){
            insert("task", "user_id, task_description, priority,due_date","'"+t.getUserId()+"','"+t.getTaskDescription()+"',"+t.getPriority()+",'"+t.getDueDate()+"'");
            tasksInserted++;
        }
        return tasksInserted;
    } 
};