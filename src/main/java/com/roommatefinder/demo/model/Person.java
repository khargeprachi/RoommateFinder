package com.roommatefinder.demo.model;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

@Entity
public class Person {

    public Person() {
        super();
    }

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    String emailId;
    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    String firstName;
    String lastName;
    String contact;
    Integer age;
    String gender; //enum

    @Transient
    Person marriedPerson;

    @Transient
    Integer marriedPersonMatchCount;
    
    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Integer getMarriedPersonMatchCount() {
        return marriedPersonMatchCount;
    }

    public void setMarriedPersonMatchCount(Integer marriedPersonMatchCount) {
        this.marriedPersonMatchCount = marriedPersonMatchCount;
    }

    
    @OneToOne(targetEntity = RoommatePreferences.class, cascade=CascadeType.ALL)
    RoommatePreferences roommatePreferences;



    //RoommatePreferences roommatePreferences;

    public RoommatePreferences getRoommatePreferences() {
        return roommatePreferences;
    }

    public void setRoommatePreferences(RoommatePreferences roommatePreferences) {
        this.roommatePreferences = roommatePreferences;
    }

    public Person getMarriedPerson() {
        return marriedPerson;
    }

    public void setMarriedPerson(Person marriedPerson) {
        this.marriedPerson = marriedPerson;
    }

   

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }



}
