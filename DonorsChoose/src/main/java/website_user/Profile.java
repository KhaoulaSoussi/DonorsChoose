/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package website_user;

import java.util.GregorianCalendar;

public class Profile {
    
    private String firstName;
    private String lastName;
    private String address;
    private Gender gender;
    private GregorianCalendar dateOfBirth;

    public Profile(String firstName, String lastName, String address, String g, int year, int month, int day) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        setGender(g);
        this.dateOfBirth = new GregorianCalendar(year, month, day);
    }

   
    public String getFirstName() {
        return firstName;
    }

    public void setFirst_name(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public Gender getGender(){
        return gender;
    }

    public void setGender(String gender) {
        this.gender = Gender.valueOf(gender.toUpperCase());
    }

    public GregorianCalendar getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(int year, int month, int day) {
        dateOfBirth.set(year, month, day);
    }
    
    @Override 
     public String toString(){
        return "First Name: " + firstName + "\tLast Name: " + lastName;
    }
}