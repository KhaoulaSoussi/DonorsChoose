/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package website_user;

import java.util.ArrayList;
import project.Donation;
import project.ProjectRequest;

/**
 *
 * @author hp
 */
public class Donor extends User{
    private ArrayList<Donation> myDonations;
    private ArrayList<ProjectRequest> myWishList;

    public Donor(Profile profile) {
        super(profile);
        this.myDonations = new ArrayList<> (20);
        this.myWishList = new ArrayList<> (20);
    }
    
    public void donate(Donation donation){
        myDonations.add(donation);
    }

    public void addToWishLsit(ProjectRequest proj){
        if(!myWishList.contains(proj)){
            myWishList.add(proj);
        }
    }
    
    @Override
    public String toString(){
        return "\nDonor Information: " + super.toString();
    }
    
    @Override
    public boolean equals(Object o){
        if(o != null && o instanceof Donation){
            Donor d = (Donor) o;
            return d.getProfile().equals(this.getProfile());
        }
        return false;
    }
}
