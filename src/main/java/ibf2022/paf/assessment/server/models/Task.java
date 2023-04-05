package ibf2022.paf.assessment.server.models;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// TODO: Task 4

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    private int taskId;
    private String userId;
    private String taskDescription;
    private int priority;    
    private Date dueDate;
}
