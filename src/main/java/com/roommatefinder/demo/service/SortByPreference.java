package com.roommatefinder.demo.service;

import java.lang.reflect.Field;
import java.util.Comparator;

import com.roommatefinder.demo.model.Person;
import com.roommatefinder.demo.model.RoommatePreferences;

public class SortByPreference implements Comparator<Person> {

    public SortByPreference() {
        super();
        // TODO Auto-generated constructor stub
    }

    public SortByPreference(Person unmarriedPerson) {
        super();
        this.unmarriedPerson = unmarriedPerson;
    }

    Person unmarriedPerson ;
    
    @Override
    public int compare(Person o1, Person o2) {
        // TODO Auto-generated method stub
        try {
            return getPreferenecCount(unmarriedPerson, o2) - getPreferenecCount(unmarriedPerson, o1);
        } catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        return 0;
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
