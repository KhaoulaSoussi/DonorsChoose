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
public class ClassVisitorProject extends ProjectRequest{
    private Visitor visitor;
    private GregorianCalendar dateOfVisit;

    public ClassVisitorProject(Visitor visitor, int visitYear, int visitMonth, int visitDay, String title, 
        String description, char student_grade, Category c, double fundingGoal ,int deadYear, int deadMonth, 
        int deadDate, String institution){
        super(title, description, student_grade, c, fundingGoal, deadYear, deadMonth, deadDate, institution);
        this.visitor = visitor;
        this.dateOfVisit = new GregorianCalendar(visitYear, visitMonth, visitDay);
    }

    public Visitor getVisitor() {
        return visitor;
    }

    public void setVisitor(Visitor visitor) {
        this.visitor = visitor;
    }

    public GregorianCalendar getDateOfVisit() {
        return dateOfVisit;
    }

    public void setDateOfVisit(int year, int month, int day) {
        dateOfVisit.set(year, month, day);
    }

    @Override
    public String toString(){
        return super.toString();
    }
}
