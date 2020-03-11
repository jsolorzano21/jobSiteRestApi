package com.cdcc.rest_site_locations;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.cdcc.models.Role;
import com.cdcc.repository.RoleRepository;

@SpringBootApplication
@ComponentScan(basePackages = { "com.cdcc.controller","com.cdcc.config","com.cdcc.services"} )
@EnableMongoRepositories("com.cdcc.repository")
@EnableAutoConfiguration

public class RestSiteLocationsApplication {
	
	@Bean
	CommandLineRunner init(RoleRepository roleRepository) {

	    return args -> {

	        Role adminRole = roleRepository.findByRole("ADMIN");
	        if (adminRole == null) {
	            Role newAdminRole = new Role();
	            newAdminRole.setRole("ADMIN");
	            roleRepository.save(newAdminRole);
	        }
	    };

	}

	public static void main(String[] args) {
		SpringApplication.run(RestSiteLocationsApplication.class, args);
	}

}
