/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package website_user;

import exceptions.DuplicateAccountsException;
import exceptions.IncorrectPasswordException;
import exceptions.UsernameNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 *
 * @author hp
 */
public class AccountsCollection {
    public static List <Account> accounts;
    
    public AccountsCollection(){
        accounts = new LinkedList<>();
    }
    
    public void login(Account acc) throws UsernameNotFoundException, IncorrectPasswordException{
        if(!accounts.contains(acc)){
            throw new UsernameNotFoundException(acc);
        }
        else if(!accounts.get(accounts.indexOf(acc)).getPassword().equals(acc.getPassword())){
            throw new IncorrectPasswordException();
        }
    }
    
    public void register(Account newAcc) throws DuplicateAccountsException{
        if(accounts.contains(newAcc)){
            throw new DuplicateAccountsException(newAcc);
        }
        accounts.add(newAcc);
    }
    
    public int indexOf(Account acc){
        return accounts.indexOf(acc);
    }
    
    public Account get(int index){
        return accounts.get(index);
    }
    
    public ListIterator<Account> getAccounts(){
        return accounts.listIterator();
    }
    
    @Override
    public String toString(){
        String str = "";
        ListIterator<Account> iter = accounts.listIterator();
        while(iter.hasNext()){
            Account acc = iter.next();
            str += acc.toString() + "\t";
        }
        return str;
    }
}
