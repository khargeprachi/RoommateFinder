package com.roommatefinder.demo.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.roommatefinder.demo.model.Person;
import com.roommatefinder.demo.model.PersonRepository;
import com.roommatefinder.demo.service.FindRoommateService;


@Controller
public class FindRoommateController {

    
    @Autowired
    PersonRepository personRepo;
    
    @Autowired
    FindRoommateService findRoommateService;
    
    
    @RequestMapping(value="/" , method=RequestMethod.GET )
    public String homepage(Model model) {
        return "home";
    }
    
    @RequestMapping(value="/search" , method=RequestMethod.GET )
    public String search(Model model) {
        model.addAttribute("person", new Person());
        return "search";
    }
    
    @RequestMapping(value = "/match", method = RequestMethod.POST) 
    public Map<String, String>  find(@ModelAttribute Person person, BindingResult bindingResult,  Model model, HttpServletRequest request ) throws IllegalArgumentException, IllegalAccessException {
        if(bindingResult.hasErrors()){
            System.out.println("There was a error "+bindingResult);
            System.out.println("Person is: "+ person.getEmailId());
            return new HashMap();
        }
        
       Person existPerson = personRepo.findByEmailId(person.getEmailId()) ;
       if(existPerson == null) {
           personRepo.save(person);
          
       } else {
          existPerson.setRoommatePreferences(person.getRoommatePreferences());        
          personRepo.save(existPerson);
       }

       List<Person> people =  (List<Person>) personRepo.findAll();
    
       Map<String, String> resultMap = findRoommateService.matchRoommates(people);
   
        return resultMap;
        
//        return ResponseEntity.ok()
//                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=SPA000000001")
//                .contentLength(resource.contentLength())
//                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_OCTET_STREAM_VALUE)
//                .body(resource);
        
    }
}
