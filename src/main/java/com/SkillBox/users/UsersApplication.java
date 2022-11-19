package com.SkillBox.users;

import com.SkillBox.users.Entity.User;
import com.SkillBox.users.repository.UserRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class UsersApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsersApplication.class, args);
	}

	@Bean
	public CommandLineRunner runner (UserRepo repo) {
		return (args) -> {
			System.out.println("___________________________________________");
			List<User> all = repo.findAll();

			all.forEach(System.out::println);

		};
	}

}
