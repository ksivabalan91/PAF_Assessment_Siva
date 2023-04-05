package ibf2022.paf.assessment.server;

import java.sql.Date;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

import ibf2022.paf.assessment.server.models.Task;
import ibf2022.paf.assessment.server.repositories.TaskRepository;
import ibf2022.paf.assessment.server.repositories.UserRepository;

@SpringBootApplication
public class ServerApplication implements CommandLineRunner {

	@Autowired
	UserRepository userRepo;

	@Autowired
	TaskRepository taskRepo;

	public static void main(String[] args) {
		SpringApplication.run(ServerApplication.class, args);
	}
	@Bean
	public CommonsRequestLoggingFilter log(){
	CommonsRequestLoggingFilter logger = new CommonsRequestLoggingFilter();
	logger.setIncludeClientInfo(true);
	logger.setIncludeQueryString(true);
	return logger;
}
	@Override
	public void run(String... args) throws Exception {

		//! test insert user
		// User user = new User();
		// user.setName("Darth Vader");
		// user.setUsername("deathstar");
		// String generatedUserId =  userRepo.insertUser(user);
		// System.out.println(generatedUserId);

		//! test find user
		// Optional<User> optUser = userRepo.findUserByUSername("Fred");
		// if(optUser.isPresent()){
		// 	System.out.println(optUser.get().toString());
		// }
		
		//! test insert new task
		// Task task = new Task();
		// task.setDueDate(Date.valueOf(LocalDate.now()));
		// task.setPriority(1);
		// task.setTaskDescription("notthin much to do");
		// task.setUserId("1b80114c");		
		// Task task2 = new Task();
		// task2.setDueDate(Date.valueOf(LocalDate.now()));
		// task2.setPriority(2);
		// task2.setTaskDescription("alotta work to do");
		// task2.setUserId("1b80114c");		
		// List<Task> tasks = new LinkedList<>();
		// tasks.add(task);
		// tasks.add(task2);
		// int rowsInserted = taskRepo.insertTask(tasks);
		// System.out.printf(">>> %d tasks inserted".formatted(rowsInserted)); 		
	}
}
