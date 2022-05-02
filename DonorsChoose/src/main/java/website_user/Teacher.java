/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package website_user;

import java.util.LinkedList;
import java.util.List;
import project.ProjectRequest;
import project.ThankYouPackage;

/**
 *
 * @author hp
 */
public class Teacher extends User{
    private List<ProjectRequest> myProjects;
    
    public Teacher(Profile profile){
        super(profile);
        this.myProjects = new LinkedList <>();
    }
    
    public void postProject(ProjectRequest proj){
        myProjects.add(proj);
    }
    
    public void markProjectAsExpired(ProjectRequest proj){
        proj.setDeadline(0, 0, 0);
    }
    
    public void postThankYouPackage(ProjectRequest proj, ThankYouPackage tp){
        proj.setPack(tp);
    }
}
