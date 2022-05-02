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
public class AnswersNotMatchException extends Exception{
    public AnswersNotMatchException(){
        super("The answer provided does not match the security answer! Please refer to help services to retrieve your password!");
    }
}
