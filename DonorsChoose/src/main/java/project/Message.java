/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;
import java.util.GregorianCalendar;
import website_user.Account;

public class Message {
    private GregorianCalendar date;
    private String text;
    private Account acc;

    public Message(int date, int month, int year, String text, Account acc) {
        this.date = new GregorianCalendar(year, month, date);
        this.text = text;
        this.acc = acc;
    }

    public GregorianCalendar getDate() {
        return date;
    }

    public void setDate(int year, int month, int day) {
        date.set(year, month, day);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Account getAcc() {
        return acc;
    }

    public void setAcc(Account acc) {
        this.acc = acc;
    }
    
    @Override
    public String toString(){
        return ("Text: " + text + "\nDate: " + date.get(GregorianCalendar.DATE) 
                + "/" + date.get(GregorianCalendar.MONTH) + "/" 
                + date.get(GregorianCalendar.YEAR) + "\nAccount: " + acc.toString());
    }

}