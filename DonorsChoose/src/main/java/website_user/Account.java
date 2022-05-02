/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package website_user;

import exceptions.*;


public class Account{
    
    private String username;
    private String password;
    private User user;
    private SecurityQuestions secQ;
    private String answer;
    
    //For signing up
    public Account(String username, String password, User user) throws LowerCaseException, UpperCaseException, NumberOfCharactersException {
        this.username = username;
        setPassword(password);
        this.user = user;
    }
    
    public Account(String userName){
        this.username = userName;
    }
    
    //For logging in, no need for user information
    public Account(String username, String password){
        this.username = username;
        this.password = password;
    }
    
    public void changePass(String prevPass ,String newPass) throws LowerCaseException, UpperCaseException, NumberOfCharactersException, PasswordNotMatchException{
        if(this.password.equals(newPass)){
           throw new PasswordNotMatchException();
        }
        else{
            setPassword(newPass);
        }
    }
    
    public String forgotPass(String answer) throws AnswersNotMatchException{
        if(answer.equals(this.answer)){
            return password;
        }
        else{
            throw new AnswersNotMatchException();
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) throws LowerCaseException, UpperCaseException, NumberOfCharactersException{
        int flagUp = 0;
        int flagLo = 0;
        int i;
        if(password.length() < 8){
            throw new NumberOfCharactersException();
        }
        for(i = 0; i < password.length(); i++){
            char c = password.charAt(i);
            if(Character.isUpperCase(c)){
                flagUp = 1;
            }
            if(Character.isLowerCase(c)){
                flagLo = 1;
            }
        }
        if(flagUp == 0){
            throw new UpperCaseException();
        }
        if(flagLo == 0){
            throw new LowerCaseException();
        }
        else{
            this.password = password;
        }
    }
    
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public SecurityQuestions getSecQ() {
        return secQ;
    }

    public void setSecQ(String secQ) {
        this.secQ = SecurityQuestions.valueOf(secQ.replaceAll(" ", "_").toUpperCase());
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
    
    @Override
    public String toString(){
        return "\tUsername: " + username;
    }
    
    @Override
    public boolean equals(Object obj){
        if(obj != null && obj instanceof Account){
            Account u = (Account) obj;
            return (u.getUsername().equals(this.username));
        }
        return false;
    }
}