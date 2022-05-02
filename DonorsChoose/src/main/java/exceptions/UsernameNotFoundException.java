/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

import website_user.Account;

/**
 *
 * @author hp
 */
public class UsernameNotFoundException extends Exception{
    
    public UsernameNotFoundException(Account acc) {
        super("The username you've entered doesn't match any account.\nPlease consider signing up for an account.");
    }
}
