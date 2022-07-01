package com.roommatefinder.demo.model;

import java.util.List;



public class RoommatePreferences {
    Boolean drink;
    Boolean smoke;
    Boolean pets;
    List<String> nationality;
    Integer ageMin;
    Integer ageMax;
    String preferredGender;
    List<Integer> zipCode;
    Integer budget;
    Integer furnished;
    Integer noOfPeople;

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

    public List<String> getNationality() {
        return nationality;
    }

    public void setNationality(List<String> nationality) {
        this.nationality = nationality;
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

    public List<Integer> getZipCode() {
        return zipCode;
    }

    public void setZipCode(List<Integer> zipCode) {
        this.zipCode = zipCode;
    }

    public Integer getBudget() {
        return budget;
    }

    public void setBudget(Integer budget) {
        this.budget = budget;
    }

    public Integer getFurnished() {
        return furnished;
    }

    public void setFurnished(Integer furnished) {
        this.furnished = furnished;
    }

    public Integer getNoOfPeople() {
        return noOfPeople;
    }

    public void setNoOfPeople(Integer noOfPeople) {
        this.noOfPeople = noOfPeople;
    }
}
