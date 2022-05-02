/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;
import java.io.Serializable;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class ProjectRequest implements Serializable{
    
    //public static final long serialVersionUID = -400310746;
    private String title;
    private String description;
    private char studentGrade;
    private double fundingGoal;
    transient private double amountLeft;
    private Category category;
    private GregorianCalendar deadline;
    transient private GregorianCalendar datePosted;
    transient private ThankYouPackage pack;
    private String institution;
    transient private List<Donation> donationsList;
    transient private List<Message> messages;
    
    
    //This constructor does not initialize the funding goal because it can be estimated later especially for a material project
    public ProjectRequest(String title, String description, char student_grade, Category c, int deadYear, int deadMonth, 
            int deadDate, String institution) {
        this.title = title;
        this.description = description;
        this.studentGrade = student_grade;
        this.category = c;
        this.deadline = new GregorianCalendar(deadYear, deadMonth, deadDate);
        setDatePosted();
        this.institution = institution;
        this.donationsList = new LinkedList<> ();
        this.messages = new LinkedList<> ();
    }
    
    public ProjectRequest(String title, String description, char student_grade, Category c, double fundingGoal, int deadYear, int deadMonth, 
            int deadDate, String institution) {
        this.title = title;
        this.description = description;
        this.studentGrade = student_grade;
        this.category = c;
        this.fundingGoal = fundingGoal;
        this.deadline = new GregorianCalendar(deadYear, deadMonth, deadDate);
        setDatePosted();
        this.institution = institution;
        this.donationsList = new LinkedList<> ();
        this.messages = new LinkedList<> ();
    }
    
    //This constructor is used for searching by title
    public ProjectRequest(String title){
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public char getStudentGrade() {
        return studentGrade;
    }

    public void setStudentGrade(char studentGrade) {
        this.studentGrade = studentGrade;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getDeadline() {
        return deadline.get(GregorianCalendar.DATE) 
                + "/" + deadline.get(GregorianCalendar.MONTH) + "/" 
                + deadline.get(GregorianCalendar.YEAR);
    }

    public void setDeadline(int year, int month, int date) {
        deadline.set(year, month, date);
    }

    public String getDatePosted() {
        return datePosted.get(GregorianCalendar.DATE) 
                + "/" + datePosted.get(GregorianCalendar.MONTH) + "/" 
                + datePosted.get(GregorianCalendar.YEAR);
    }

    public void setDatePosted() {
        datePosted = (GregorianCalendar) GregorianCalendar.getInstance();
    }

    public ThankYouPackage getPack() {
        return pack;
    }

    public void setPack(ThankYouPackage pack) {
        this.pack = pack;
    }
    
    public void setDatePosted(GregorianCalendar datePosted) {
        this.datePosted = datePosted;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }
    
    public double getFundingGoal() {
        return fundingGoal;
    }

    public void setFundingGoal(double fundingGoal) {
        this.fundingGoal = fundingGoal;
    }

    public double getAmountLeft() {
        return amountLeft;
    }

    public void setAmountLeft(double amountLeft) {
        this.amountLeft = amountLeft;
    }
    
    public void donate(Donation don){
        donationsList.add(don);
        amountLeft -= don.getAmount();
    }
    
    public ListIterator<Donation> displayDonations(){
        return donationsList.listIterator();
    }
    
    public void postMessage(Message msg){
        messages.add(msg);
    }
    
    public ListIterator<Message> displayMessages(){
        return messages.listIterator();
    }

    @Override
    public boolean equals(Object obj){
        if(obj != null && obj instanceof ProjectRequest){
            ProjectRequest pr = (ProjectRequest) obj;
            return (pr.getTitle().equals(this.title));
        }
        return false;
    }
    
   @Override
    public String toString(){
        return title;    
    }
}