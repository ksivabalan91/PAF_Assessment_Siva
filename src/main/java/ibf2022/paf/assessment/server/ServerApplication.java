package ibf2022.paf.assessment.server;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

import ibf2022.paf.assessment.server.models.User;
import ibf2022.paf.assessment.server.repositories.UserRepository;

@SpringBootApplication
public class ServerApplication implements CommandLineRunner {

	@Autowired
	UserRepository userRepo;

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

		User user = new User();
		user.setName("Darth Vader");
		user.setUsername("deathstar");
		String generatedUserId =  userRepo.insertUser(user);

		System.out.println(generatedUserId);

		Optional<User> optUser = userRepo.findUserByUSername("Fred");

		if(optUser.isPresent()){
			System.out.println(optUser.get().toString());
		}

		
	}
}
