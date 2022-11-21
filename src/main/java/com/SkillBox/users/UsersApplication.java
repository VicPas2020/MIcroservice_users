package com.SkillBox.users;

import com.SkillBox.users.Entity.HardSkills;
import com.SkillBox.users.Entity.User;
import com.SkillBox.users.repository.UserRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

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
			System.out.println("All users ");
			all.forEach(System.out::println);
			System.out.println("___________________________________________");
			System.out.println("Skills ");
			User moscow = repo.findUserByCurrentLocation("Moscow");
			 moscow.getSkills()
					.stream()
					.map(HardSkills::getHardSkill)
					.forEach(System.out::println);

			System.out.println("___________________________________________");

			Optional<User> byId = repo.findById(UUID.fromString("039fb3b6-6693-11ed-9022-0242ac120002"));


			if(byId.isPresent()) {
				Set<User> subscribers = byId.get().getSubscribers();
				System.out.println("Subscribers");
				subscribers.stream().map(User::getLastName).forEach(System.out::println);

			}

		};
	}

}
