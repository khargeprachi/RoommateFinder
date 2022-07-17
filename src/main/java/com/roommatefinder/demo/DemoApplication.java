package com.roommatefinder.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.roommatefinder.demo.model.Person;
import com.roommatefinder.demo.model.PersonRepository;
import com.roommatefinder.demo.model.RoommatePreferences;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages="com.roommatefinder.demo")
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
	        
	        Person person1 = new Person("Prachi", "Kharge");
	        person1.setRoommatePreferences(new RoommatePreferences(true, true, true, "India", 10, 15, "F", 85283, 3000, true, 2));
	        
	        
	        Person person2 = new Person("Parth", "Kharge");
            person2.setRoommatePreferences(new RoommatePreferences(false, false, false, "USA", 30, 40, "M", 85282, 2000, false, 1));
            
            Person person3 = new Person("Rosy", "Banerjee");
            person3.setRoommatePreferences(new RoommatePreferences(true, true, false, "India", 10, 15, "F", 85283, 3000, true, 2));
            
            Person person4 = new Person("Gargi", "Vyas");
            person4.setRoommatePreferences(new RoommatePreferences(true, false, false, "India", 20, 30, "F", 85281, 1000, true, 2));
            
            Person person5 = new Person("Kinnri", "Sinha");
            person5.setRoommatePreferences(new RoommatePreferences(true, false, false, "India", 20, 30, "F", 85281, 1000, true, 2));
            
            Person person6 = new Person("Prashant", "Kharge");
            person6.setRoommatePreferences(new RoommatePreferences(false, false, false, "USA", 30, 40, "M", 85282, 2000, false, 1));
            
//	        repository.save(person1);
//	        repository.save(person2);
//	        repository.save(person3);
//	        repository.save(person4);
//	        repository.save(person5);
//	        repository.save(person6);
            

	    };
	  }
}
