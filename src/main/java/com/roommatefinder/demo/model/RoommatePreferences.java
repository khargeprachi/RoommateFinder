package com.roommatefinder.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import java.util.List;


@Entity
public class RoommatePreferences {
    


    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    
    Boolean drink;
    Boolean smoke;
    Boolean pets;
    String nationality;
    Integer ageMin;
    Integer ageMax;
    String preferredGender;
    Integer zipCode;
    Integer budget;
    Boolean furnished;
    Integer noOfPeople;

    
    public RoommatePreferences() {
        super();
    }

    public RoommatePreferences(Boolean drink, Boolean smoke, Boolean pets, String nationality, Integer ageMin,
            Integer ageMax, String preferredGender, Integer zipCode, Integer budget, Boolean furnished,
            Integer noOfPeople) {
        super();
        this.drink = drink;
        this.smoke = smoke;
        this.pets = pets;
        this.nationality = nationality;
        this.ageMin = ageMin;
        this.ageMax = ageMax;
        this.preferredGender = preferredGender;
        this.zipCode = zipCode;
        this.budget = budget;
        this.furnished = furnished;
        this.noOfPeople = noOfPeople;
    }
    
    public Boolean getDrink() {
        return drink;
    }

    public void setDrink(Boolean drink) {
        this.drink = drink;
    }

    public Boolean getSmoke() {
        return smoke;
    }

    public void setSmoke(Boolean smoke) {
        this.smoke = smoke;
    }

    public Boolean getPets() {
        return pets;
    }

    public void setPets(Boolean pets) {
        this.pets = pets;
    }

  
    public Integer getAgeMin() {
        return ageMin;
    }

    public void setAgeMin(Integer ageMin) {
        this.ageMin = ageMin;
    }

    public Integer getAgeMax() {
        return ageMax;
    }

    public void setAgeMax(Integer ageMax) {
        this.ageMax = ageMax;
    }

    public String getPreferredGender() {
        return preferredGender;
    }

    public void setPreferredGender(String preferredGender) {
        this.preferredGender = preferredGender;
    }


    public Integer getBudget() {
        return budget;
    }

    public void setBudget(Integer budget) {
        this.budget = budget;
    }

    public Boolean getFurnished() {
        return furnished;
    }

    public void setFurnished(Boolean furnished) {
        this.furnished = furnished;
    }

    public Integer getNoOfPeople() {
        return noOfPeople;
    }

    public void setNoOfPeople(Integer noOfPeople) {
        this.noOfPeople = noOfPeople;
    }
}
