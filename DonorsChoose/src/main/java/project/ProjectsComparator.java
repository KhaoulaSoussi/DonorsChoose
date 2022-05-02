/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.util.Comparator;

/**
 *
 * @author hp
 */
public class ProjectsComparator implements Comparator<ProjectRequest>{
    
    @Override
    public int compare(ProjectRequest prj1, ProjectRequest prj2){
        if(prj1.getAmountLeft() < prj2.getAmountLeft()){
            return -1;
        }
        else if(prj1.getAmountLeft() > prj2.getAmountLeft()){
            return 1;
        }
        else{
            return 0;
        }
    }
}
