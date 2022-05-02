/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

/**
 *
 * @author hp
 */
public class Visitor {
    private String firstName;
    private String lastName;
    private String job;

    public Visitor(String firstName, String lastName, String job) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.job = job;
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

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }  
    
    @Override
    public String toString(){
        return "\tFirst name: " + firstName + "\tLast Name: " + lastName + "\tJob: " + job;
        
    }
}
