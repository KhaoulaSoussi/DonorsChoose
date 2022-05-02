/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

import java.util.ArrayList;
import website_user.Account;
import static website_user.AccountsCollection.accounts;

/**
 *
 * @author hp
 */
public class DuplicateAccountsException extends Exception{
    
    Account acc;
    
    public DuplicateAccountsException(Account acc) {
        super("The username: " + acc.getUsername() + " already exists! Please try another one.");
        this.acc = acc;
    }
    
    public ArrayList <String> suggestUsernames(){
        ArrayList <String> list = new ArrayList<> (3);
        String name1 = acc.getUser().getProfile().getFirstName().substring(0, 2) + '_' +
                 acc.getUser().getProfile().getLastName().substring(0, 2);
        if(!accounts.contains(new Account(name1))){
            list.add(name1);
        }
        String name2 = acc.getUser().getProfile().getFirstName() + '_' +
                 acc.getUser().getProfile().getLastName();
        if(!accounts.contains(new Account(name2))){
            list.add(name2);
        }
        String name3 = acc.getUser().getProfile().getLastName() + '_' +
                 acc.getUser().getProfile().getFirstName();
        if(!accounts.contains(new Account(name3))){
            list.add(name3);
        }
        return list;
    }
}
