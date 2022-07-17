package com.roommatefinder.demo.service;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.roommatefinder.demo.model.Person;
import com.roommatefinder.demo.model.RoommatePreferences;

@Service
public class FindRoommateService {

    
    
   public Map<String, String>  matchRoommates(List<Person> people) throws IllegalArgumentException, IllegalAccessException {
       Boolean allProposed = false;
       
       Map<String, String> resultMap= new HashMap<String, String>();
       
       while(!allProposed) {
          Person unmarriedPerson = people.stream().filter(person -> person.getMarriedPerson()==null).findFirst().orElse(null);
            if(unmarriedPerson == null) {
                allProposed = true;
            }
            else {
                findMatch(unmarriedPerson, people);
            }
       }
           
       
       for(Person person : people) {
           resultMap.put(person.getFirstName(), person.getMarriedPerson().getFirstName());
       }
       return resultMap;
       
   }
   
   
   
   
   private void findMatch(Person unmarriedPerson, List<Person> people) throws IllegalArgumentException, IllegalAccessException {

       for(Person person : people) {
           checkPreferrence(person, unmarriedPerson);
       }

   }




   public void checkPreferrence(Person proposer, Person proposed) throws IllegalArgumentException, IllegalAccessException {


       if(!proposer.getId().equals(proposed.getId())) {
           if(proposed.getMarriedPerson()!=null) {
               if(isPreferred(proposed, proposer, proposed.getMarriedPerson())) {
                   proposed.getMarriedPerson().setMarriedPerson(null);
                   proposed.setMarriedPerson(proposer);
                   proposer.setMarriedPerson(proposed);
                 
               }
           }else {

               proposed.setMarriedPersonMatchCount(getPreferenecCount(proposer, proposed));
               proposed.setMarriedPerson(proposer);
               proposer.setMarriedPerson(proposed);
           }


       }

   }


    private boolean isPreferred(Person proposed, Person proposer, Person marriedPerson) throws IllegalArgumentException, IllegalAccessException {
       
        Integer proposerCount =  getPreferenecCount(proposer, proposed);      
        if(proposerCount > proposed.getMarriedPersonMatchCount()) {
            return true;
        }
        return false;
    }

    private Integer getPreferenecCount(Person proposer, Person proposed) throws IllegalArgumentException, IllegalAccessException {
        Field[] preferenceList =   RoommatePreferences.class.getDeclaredFields();
        Integer count =0;
        for(Field field : preferenceList) {
            
            try {
                field.setAccessible(true);
             if( !field.getName().equals("id") && field.get(proposer.getRoommatePreferences()).equals(field.get(proposed.getRoommatePreferences())) ) {
                 count++; 
                 }
          
         } catch (SecurityException e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
         }
         }
         return count;
    }
}
