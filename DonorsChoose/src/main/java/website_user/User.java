/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package website_user;


public class User {
    
    private Profile profile;
    
    public User(Profile profile){
       this.profile = profile;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }
        
    @Override
    public String toString(){
        return getProfile().toString();
    }
}