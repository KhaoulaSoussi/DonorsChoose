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
public class ProjectNotFoundException extends Exception{
    public ProjectNotFoundException(String title){
        super("We weren't able to find any projects matching: " + title);
    }
}
