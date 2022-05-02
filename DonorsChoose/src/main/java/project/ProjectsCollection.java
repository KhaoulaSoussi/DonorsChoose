/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 *
 * @author hp
 */
public class ProjectsCollection{
    public static final String path = System.getProperty("user.home") + File.separator + "DonorsChoose.txt";
    private static List <ProjectRequest> projects;

    public ProjectsCollection(){
        projects = new LinkedList<> ();
    }
    
    public boolean addProject(ProjectRequest prj){
        return projects.add(prj);
    }
    
    public boolean removeProject(ProjectRequest prj){
        return projects.remove(prj);
    }
    
    //modifyProject
    public void modifyProject(ProjectRequest proj, ProjectRequest newProj){
        int index = projects.indexOf(proj);
        projects.set(index, newProj);
    }
    
    //search by category
    public List<ProjectRequest> searchByCategory(String category){
        List<ProjectRequest> results = new LinkedList<>(); 
        Iterator<ProjectRequest> iter = projects.iterator();
        while(iter.hasNext()){
            ProjectRequest proj = iter.next();
            if(proj.getCategory().name().equals(category)){
                results.add(proj);
            }
        }
        return results;
    }
    
    //search by title
    public ProjectRequest searchByTitle(String title){
        Iterator<ProjectRequest> iter = projects.iterator();
        while(iter.hasNext()){
            ProjectRequest proj = iter.next();
            if(proj.getTitle().equals(title)){
                return proj;
            }
        }
        return null;
    }
    
    public ListIterator getProjects() {
        return projects.listIterator();
    }
    
    //Sorting the projects by lowest cost to complete
    public void sort(Comparator c){
        projects.sort(c);
    }
    
    public void save(String filePath){
        ObjectOutputStream oos = null;
        try{
            FileOutputStream fos = new FileOutputStream(filePath);
            oos = new ObjectOutputStream(fos);
        }
        catch(FileNotFoundException ex){
            System.out.println(ex.getMessage());
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        try{
            oos.writeObject(projects);
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    public void load(){
        FileInputStream fis;
        ObjectInputStream ois = null;
        try{
            fis = new FileInputStream(path);
            ois = new ObjectInputStream(fis);
        }
        catch(FileNotFoundException ex){
            System.out.println(ex.getMessage());
        }
        catch(EOFException ex){
            return;
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        try{
            projects = (List<ProjectRequest>)ois.readObject();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    @Override
    public String toString(){
        String str = "";
        ListIterator<ProjectRequest> iter = projects.listIterator();
        while(iter.hasNext()){
            ProjectRequest prj = iter.next();
            str += prj.toString() + "\t";
        }
        return str;
    }
}
