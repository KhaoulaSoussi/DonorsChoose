/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entry;

import exceptions.DuplicateAccountsException;
import exceptions.IncorrectPasswordException;
import exceptions.LowerCaseException;
import exceptions.NumberOfCharactersException;
import exceptions.ProjectNotFoundException;
import exceptions.UpperCaseException;
import exceptions.UsernameNotFoundException;
import java.util.Iterator;
import java.util.Scanner;
import project.*;
import website_user.*;

public class Website{
    public static void main (String[] args){
        AccountsCollection accounts = new AccountsCollection();
        ProjectsCollection projects = new ProjectsCollection();   

        Profile pro1 = new Profile("Khaoula", "Najd", "Al Akhawayn", "female", 2000, 04, 02);
        User user1 = new User(pro1);
        
        Profile pro2 = new Profile("Yasmine", "Ait Soussi", "Al Akhawayn Uni", "female", 1998, 03, 06);
        User user2 = new User(pro2);
        
        Profile pro3 = new Profile("Ahmed", "TOTO", "Al Akhawayn Uni", "male", 1978, 02, 12);
        User user3 = new User(pro3);
        
        System.out.println("===== Registering =====");
        
        register(accounts, user1);
        System.out.println("The list of accounts: " + accounts.toString());
        
        register(accounts, user2);
        System.out.println("The list of accounts: " + accounts.toString());
        
        register(accounts, user3);
        System.out.println("The list of accounts: " + accounts.toString());
        
        System.out.println("=====Logging in =====");
        login(accounts);
        login(accounts);
        login(accounts);
        
        //Creating projects: 1 material projects , 1 class trip projects, 1 class visitor project
        
        ProjectRequest mp = new MaterialProject("Music and the Arts Workshop", "description1", 'A', Category.APPLIED_LEARNING, 
                2020, 11, 1, "OurSchool", "Amazon.com", 44, "Amazon.com");
        
        ProjectRequest ctp = new ClassTripProject(7, "Agadir", 18, 2020, 6, 13, 2020, 6, 21, "Trip to Taghazout", 
                "description2", 'B', 2000 ,  Category.HEALTH_AND_SPORTS, 2020, 5, 1, "Al Akhawayn University");
        
        //Creating a visitor
        String first = "toto";
        String last = "foo";
        String job = "Software Engineer";
        Visitor v = new Visitor(first, last, job);
        
        ProjectRequest cvp = new ClassVisitorProject(v, 2020, 6, 10, "Computer Science Ambition", "description3", 'C'
                , Category.MATH_AND_SCIENCE, 3000, 2020, 5, 1,"Al Akhawayn University");
        mp.setFundingGoal(5000);
        mp.setAmountLeft(5000);
        cvp.setAmountLeft(3000);
        ctp.setAmountLeft(2000);
        
        projects.addProject(ctp);
        projects.addProject(mp);
        projects.addProject(cvp);
        
        //To make use of polymorphism
        processProjects(projects);
        
        try{
            donate(projects, "Music and the Arts Workshop");
        }
        catch(ProjectNotFoundException exp){
            System.out.println(exp.getMessage());
        }

        ProjectsComparator comp = new ProjectsComparator();
        projects.sort(comp);
        System.out.println("The projects sorted are: " + projects.toString());
        
        
        //Modify cvp
        String f = "fofo";
        String l = "too";
        String newJob = "Computer Scientist";
        Visitor v2 = new Visitor(f, l, newJob);
        
        ProjectRequest newProj = new ClassVisitorProject(v2, 2020, 6, 10, "Computer Science Ambition", "description3", 'C'
                , Category.MATH_AND_SCIENCE, 3000,2020, 5, 1,"Al Akhawayn University");
        projects.modifyProject(cvp, newProj);
        
        System.out.println("The projects after modifying class visitor project are: " + projects.toString());
        
        //Search by category:
        System.out.println("The projects having the wanted category are: " + projects.searchByCategory("health_and_sports"));
        
        //Search by title:
        System.out.println("The project with the wanted title is: " + projects.searchByTitle("Computer Science Ambition"));
        
        //Remove material project:
        projects.removeProject(mp);
        System.out.println("The projects after removing material project are: " + projects.toString());
    }
    
    public static void processProjects(ProjectsCollection projects){
        Iterator<ProjectRequest> iter = projects.getProjects();
        while(iter.hasNext()){
            ProjectRequest p = iter.next();
            if(p.getClass() == ClassTripProject.class){
                ClassTripProject ct = (ClassTripProject) p;
                ct.setNumOfParticipants(20);
            }
            if(p.getClass() == ClassVisitorProject.class){
                ClassVisitorProject cvp = (ClassVisitorProject) p;
                cvp.setDateOfVisit(2020, 10, 9);
            }
            System.out.println(p.toString());   //Polymorphic Call
            System.out.println(p.getStudentGrade());    //Polymorphical Call to getStudentGrade()
        }
    }
    
   
    public static void register(AccountsCollection accounts, User u){
        Account acc;
        Scanner sc = new Scanner(System.in);  
        System.out.println("Please enter your username: ");
        String userName = sc.nextLine();
        System.out.println("Please enter your password: ");
        String pass = sc.nextLine();
        while(true){
            try{
                acc = new Account(userName, pass, u);
                accounts.register(acc);
                System.out.println("Please choose a security question from the following: ");
                for(SecurityQuestions sq : SecurityQuestions.values()){
                    System.out.println(sq.name().replace('_', ' ').toLowerCase() + "?");
                }
                String secQue = sc.next();
                acc.setSecQ(secQue);
                System.out.println("Enter your answer: ");
                String answer = sc.next();
                acc.setAnswer(answer);
                System.out.println("Please remember this answer it'll help you retrieve your password in case you forget it!");
                break;
            }
            catch(DuplicateAccountsException e4){
                System.out.println(e4.getMessage());
                System.out.println("Please refer to these suggestions: " + e4.suggestUsernames());
                System.out.println("Enter a new Username: ");
                userName = sc.nextLine();
            }
            catch(NumberOfCharactersException e1){
                System.out.println(e1.getMessage());
                System.out.println("Please refer to this example to know about password regulations: " + e1.showExample());
                System.out.println("Enter a new Password: ");
                pass = sc.nextLine();
            }
            catch(LowerCaseException e2){
                System.out.println(e2.getMessage());
                System.out.println("Please refer to this example to know about password regulations: " + e2.showExample());
                System.out.println("Enter a new Password: ");
                pass = sc.nextLine();
            }
            catch(UpperCaseException e3){
                System.out.println(e3.getMessage());
                System.out.println("Please refer to this example to know about password regulations: " + e3.showExample());
                System.out.println("Enter a new Password: ");
                pass = sc.nextLine();
            }
        }
    }
    
    
    public static void login(AccountsCollection accounts){
        System.out.println("Enter the username and the password: ");
        Scanner sc = new Scanner(System.in);
        String uname = sc.next();
        String pass = sc.next();
        Account acc = new Account(uname, pass);
        while(true){
            try{
                accounts.login(acc);
                break;
            }
            catch(UsernameNotFoundException e1){
                System.out.println(e1.getMessage());
                System.out.println("Enter the username: ");
                uname = sc.next();
                acc = new Account(uname, pass);
            }
            catch(IncorrectPasswordException e2){
                System.out.println(e2.getMessage());
                System.out.println("Enter the password: ");
                pass = sc.next();
                acc = new Account(uname, pass);
            }
        }
        System.out.println("You are logged in successfully!");
    }
    
    public static void donate(ProjectsCollection projects, String title) throws ProjectNotFoundException{
        ProjectRequest prj = projects.searchByTitle(title);
        if(prj == null){
            throw new ProjectNotFoundException(title);
        }
        else{
            Donation don = new Donation(2020, 4, 18, 600.0, prj);
            prj.donate(don);
        }
    }
    
    public static void search(ProjectsCollection projects) throws ProjectNotFoundException{
        System.out.println("Choose an option:\n1- Search by category.\n2- Search by title.");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        if(choice == 1){
            System.out.println("Enter Catogory name: ");
            for(Category category : Category.values()){
                System.out.println("\t" + category.toString().replaceAll("_"," ").toLowerCase());
            }
            String c = sc.nextLine();
            System.out.println(projects.searchByCategory(c));
        }
        else{
            System.out.println("Enter the project title: ");
            String title = sc.nextLine();
            ProjectRequest prj = projects.searchByTitle(title);
            if(prj == null){
                throw new ProjectNotFoundException(title);
            }
            else{
                System.out.println(prj);
            }
        }
    }
}