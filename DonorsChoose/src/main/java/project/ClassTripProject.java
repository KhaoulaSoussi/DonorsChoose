/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.util.GregorianCalendar;

/**
 *
 * @author hp
 */
public class ClassTripProject extends ProjectRequest{
    private int tripDuration;
    private String destination;
    private int numOfParticipants;
    private GregorianCalendar departDate;
    private GregorianCalendar arrivalDate;

    public ClassTripProject(int tripDuration, String destination, int numOfParticipants, int departYear, 
            int departMonth, int departDay, int arrivalYear, int arrivalMonth, int arrivalDay, String title, 
            String description, char student_grade, double fundingGoal, Category c, int deadYear, 
            int deadMonth, int deadDate, String institution) {
        super(title, description, student_grade, c, fundingGoal, deadYear, deadMonth, deadDate, institution);
        this.tripDuration = tripDuration;
        this.destination = destination;
        this.numOfParticipants = numOfParticipants;
        this.departDate = new GregorianCalendar(departYear, departMonth, departDay);
        this.arrivalDate = new GregorianCalendar(arrivalYear, arrivalMonth, arrivalDay);
    }

    public int getTripDuration() {
        return tripDuration;
    }

    public void setTripDuration(int tripDuration) {
        this.tripDuration = tripDuration;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getNumOfParticipants() {
        return numOfParticipants;
    }

    public void setNumOfParticipants(int numOfParticipants) {
        this.numOfParticipants = numOfParticipants;
    }

    public GregorianCalendar getDepartDate() {
        return departDate;
    }

    public void setDepartDate(int year, int month, int day) {
        departDate.set(year, month, day);
    }

    public GregorianCalendar getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(int year, int month, int day) {
        arrivalDate.set(year, month, day);
    }
    
    @Override
    public String toString(){
        return super.toString();
    }
}
