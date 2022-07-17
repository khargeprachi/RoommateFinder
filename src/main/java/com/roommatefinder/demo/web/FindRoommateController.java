package com.roommatefinder.demo.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.roommatefinder.demo.model.Person;
import com.roommatefinder.demo.model.PersonRepository;
import com.roommatefinder.demo.service.FindRoommateService;


@RestController
public class FindRoommateController {

    
    @Autowired
    PersonRepository personRepo;
    
    @Autowired
    FindRoommateService findRoommateService;
    
    @RequestMapping(value = "/match", method = RequestMethod.GET) 
    public Map<String, String>  find() throws IllegalArgumentException, IllegalAccessException {
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
