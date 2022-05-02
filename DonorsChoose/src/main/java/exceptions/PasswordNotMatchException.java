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
public class PasswordNotMatchException extends Exception{
    public PasswordNotMatchException(){
        super("The previous password does not match the current password!");
    }
}
