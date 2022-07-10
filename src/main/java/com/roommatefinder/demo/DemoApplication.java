package com.roommatefinder.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.roommatefinder.demo.model.Person;
import com.roommatefinder.demo.model.PersonRepository;

@SpringBootApplication

@EnableJpaRepositories("com.roommatefinder.demo.model")
public class DemoApplication {

    @Autowired
    PersonRepository personRepository;
    
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		System.out.println("hello");
				
		
		}
	
	  @Bean
	  public CommandLineRunner demo(PersonRepository repository) {
	    return (args) -> {
	        
//	        Person person = new Person("Prachi", "Kharge");
	        repository.save(new Person("Prachi", "Kharge"));
	        repository.save(new Person("Rosy", "Banerjee"));
	        repository.save(new Person("Parth", "Kharge"));
	        repository.save(new Person("Jyoti", "Kharge"));
	        repository.save(new Person("Prashant", "Kharge"));

	    };
	  }
}
