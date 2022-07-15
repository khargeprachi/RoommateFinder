package com.roommatefinder.demo.service;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.roommatefinder.demo.model.Person;

@Service
public class FindRoommateService {

    
    
   public Map<Person, Person>  matchRoommates(List<Person> people) {
       Boolean allProposed = false;
       
       Map<Person, Person> resultMap= new HashMap<Person, Person>();
       
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
           resultMap.put(person, person.getMarriedPerson());
       }
       return resultMap;
       
   }
   
   
   
   
   private void findMatch(Person unmarriedPerson, List<Person> people) {

       for(Person person : people) {
           checkPreferrence(person, unmarriedPerson);
       }

   }




   public void checkPreferrence(Person proposer, Person proposed) {


       if(!proposer.getId().equals(proposed.getId())) {
           if(proposed.getMarriedPerson()!=null) {
               if(isPreferred(proposed, proposer, proposed.getMarriedPerson())) {
                   proposed.setMarriedPerson(proposer);
               }
           }else {

               proposed.setMarriedPersonMatchCount(getPreferenecCount(proposer, proposed));
               proposed.setMarriedPerson(proposer);
           }


       }

   }


    private boolean isPreferred(Person proposed, Person proposer, Person marriedPerson) {
       
        Integer proposerCount =  getPreferenecCount(proposer, proposed);      
        if(proposerCount > proposed.getMarriedPersonMatchCount()) {
            return true;
        }
        return false;
    }

    private Integer getPreferenecCount(Person proposer, Person proposed) {
        Field[] preferenceList =   Person.class.getFields();
        Integer count =0;
        for(Field field : preferenceList) {
            
            try {
             if( proposer.getClass().getField(field.getName()).equals(proposed.getClass().getField(field.getName())) ) {
                 count++; 
                 }
          
         } catch (NoSuchFieldException e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
         } catch (SecurityException e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
         }
         }
         return count;
    }
}
