/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

/**
 *
 * @author hp
 */
public class LowerCaseException extends Exception{
    public LowerCaseException(){
        super("The password must contain at least one lower case letter!"); //message is an assribute of the super class, it is inherited by this exception
    }
    
    public String showExample(){
        return "Ky726791";
    }
}
