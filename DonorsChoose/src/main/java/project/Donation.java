/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package project;
import java.util.GregorianCalendar;
import website_user.Donor;

public class Donation {
    private GregorianCalendar date;
    private double amount;
    private ProjectRequest proj;
    private Donor donor;
    
    public Donation(int year, int month, int date, double amount, ProjectRequest proj, Donor donor){
        this.date = new GregorianCalendar(year, month, date);
        this.amount = amount;
        this.proj = proj;
        this.donor = donor;
    }
    
    public Donation(int year, int month, int date, double amount, ProjectRequest proj){
        this.date = new GregorianCalendar(year, month, date);
        this.amount = amount;
        this.proj = proj;
        this.donor = null;      //Anonymous
    }
    
    public double getAmount(){
        return amount;
    }
    
    public void setAmount(double amount){
        this.amount = amount;
    }

    public GregorianCalendar getDate() {
        return date;
    }

    public void setDate(int year, int month, int day) {
        date.set(GregorianCalendar.YEAR,year);
        date.set(GregorianCalendar.MONTH,month);
        date.set(GregorianCalendar.DATE,day);
    }
    
    public ProjectRequest getProj(){
        return proj;
    }

    public void setProj(ProjectRequest proj) {
        this.proj = proj;
    }
    
    public Donor getDonor() {
        return donor;
    }

    public void setDonor(Donor donor) {
        this.donor = donor;
    }
    
    @Override
    public boolean equals(Object o){
        if(o != null && o instanceof Donation){
            Donation d = (Donation) o;
            return d.equals(o);
        }
        return false;
    }
    
    @Override
    public String toString(){
        return "Amount: " + amount + "\nDate: " + date.get(GregorianCalendar.DATE) 
                + "/" + date.get(GregorianCalendar.MONTH) + "/" 
                + date.get(GregorianCalendar.YEAR) + "\nProject Supported: " + proj.toString()
                +"\nDonor: " + donor.toString();
    }
    
    
}