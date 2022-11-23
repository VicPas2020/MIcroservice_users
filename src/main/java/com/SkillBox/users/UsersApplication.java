package com.SkillBox.users;

import com.SkillBox.users.Entity.HardSkills;
import com.SkillBox.users.Entity.User;
import com.SkillBox.users.repository.UserPageRepository;
import com.SkillBox.users.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@SpringBootApplication
public class UsersApplication {

	private final Logger logger = LoggerFactory.getLogger("UsersApplication");

	public static void main(String[] args) {
		SpringApplication.run(UsersApplication.class, args);
	}

//	@Bean
//	public CommandLineRunner runner(UserRepository repo) {
//		return (args) -> {
//
//
//			logger.info("________________All users___________________________");
//			List<User> all = repo.findAll();
//
//
//			for(User user: all){
//				logger.info(user.toString());
//			}
//
//
//			logger.info("___________________Skills________________________");
//
//			List<User> moscow = repo.findUserByCurrentLocation("Moscow");
//
//
//			for(User user: moscow){
//				user.getSkills().stream().map(HardSkills::getHardSkill).forEach(logger::info);
//			}
//
//
//			logger.info("________________Subscribers___________________________");
//
//			Optional<User> byId = repo.findById(UUID.fromString("039fb3b6-6693-11ed-9022-0242ac120002"));
//
//
//			if(byId.isPresent()) {
//				Set<User> subscribers = byId.get().getSubscribers();
//
//				subscribers.stream().map(User::getLastName).forEach(logger::info);
//			}
//		};
//	}


//	@Bean
//	public CommandLineRunner runner2(UserPageRepository repo) {
//		return (args) -> {
//
//			logger.info("======================= PAGE 1 =================================");
//			Pageable first = PageRequest.of(0, 1);
//			List<User> one = repo.findUserByCurrentLocation("Moscow", first);
//
//			logger.info(one.toString());
//			logger.info("======================= PAGE 2 =================================");
//
//			Pageable second = PageRequest.of(1, 1);
//			List<User> two = repo.findUserByCurrentLocation("Moscow", second);
//			logger.info(two.toString());
//
//		};
//	}
}