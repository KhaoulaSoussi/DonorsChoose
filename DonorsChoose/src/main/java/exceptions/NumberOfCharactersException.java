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
public class NumberOfCharactersException extends Exception{
    public NumberOfCharactersException(){
        super("The password must contain at least eight characters!");
    }
    
    public String showExample(){
        return "Ky726791";
    }
}
