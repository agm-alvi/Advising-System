package Advising_System;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class DirectoryCreator {
    public static void main(String[] args) {
        File deptFolder = new File("C:\\Advising System\\Admin Files\\Departments");
        if (!deptFolder.exists()) {
            System.out.println("This Program is processing to install in your PC.");
            System.out.println("Please a few moment");
            System.out.println("Do not close the program while installing");
        adminFoldersCreate();
        studentFoldersCreate();
        }
        
    }
    private static void studentFoldersCreate(){
        File profileFolder = new File("C:\\Advising System\\Student Files\\StudentsProfiles");
        if (!profileFolder.exists()) {
            if (profileFolder.mkdirs()) {
                System.out.println("Profile Folder is created!");
            } else {
                System.out.println("Failed to create Profile Folder!");
            }
        }
        
        File passFolder = new File("C:\\Advising System\\Student Files\\StudentPasswords");        
        if (!passFolder.exists()) {
            if (passFolder.mkdirs()) {
                System.out.println("Password Folder is created!");
            } else {
                System.out.println("Failed to create Pass Folder!");
            }
        }
        
        File courseFolder = new File("C:\\Advising System\\Student Files\\StudentCourses");
        if (!courseFolder.exists()) {
            if (courseFolder.mkdirs()) {
                System.out.println("Course Folder is created!");
            } else {
                System.out.println("Failed to create Course Folder!");
            }
        }
        
    }
    private static void adminFoldersCreate(){
                File deptFolder = new File("C:\\Advising System\\Admin Files\\Departments");
        if (!deptFolder.exists()) {
            if (deptFolder.mkdirs()) {
             deptFilesAdd();
             
             addAdmin();
                System.out.println("Department Folder is created!");
            } else {
                System.out.println("Failed to create Profile Folder!");
            }
        }

    }
    private static void deptFilesAdd(){
  
    File fcse= new File("C:\\Advising System\\Admin Files\\Departments","CSE");     
     PrintWriter p= null;
     try {  
     p = new PrintWriter (fcse);
     p.println("\t  CSE Department");
     p.println("\t-------------------\n");
     }catch(FileNotFoundException e){System.out.println("Error");
     }finally {
    p.close();}
    
    File feee= new File("C:\\Advising System\\Admin Files\\Departments","EEE");   
     try {  
     p = new PrintWriter (feee);
     p.println("\t  EEE Department");
     p.println("\t-------------------\n");
     }catch(FileNotFoundException e){System.out.println("Error");
     }finally {
    p.close();}
    
    File fete= new File("C:\\Advising System\\Admin Files\\Departments","ETE");
     try {  
     p = new PrintWriter (fete);
     p.println("\t  ETE Department");
     p.println("\t-------------------\n");
     }catch(FileNotFoundException e){System.out.println("Error");
     }finally {
    p.close();}
    
    }
    private static void addAdmin(){
        Scanner input = new Scanner(System.in);
        System.out.println("Add some Admin profiles");
        System.out.print("How many admins you want to add:");
        int count = input.nextInt();
        String name, pass;
        for (int i = 0; i <= count; i++) {
            if (i==count) {
                name = "agm.alvi_Admin.txt";
                pass = "2584";
            }
            
            else{
        System.out.print("Enter admin ID: ");
        name = input.next();
        name= name+"_Admin.txt";
        System.out.print("Enter Password: ");
        pass = input.next();
            }
        File f= new File("C:\\Advising System\\Admin Files",name);
     PrintWriter p= null;
     try {  
     p = new PrintWriter (f);
     p.println(pass);
     }catch(FileNotFoundException e){System.out.println("Error");
     }finally {
    p.close();}
     
        
        }
     
       
    
    }
}
        
//           File file = new File("C:\\Directory1");
//        if (!file.exists()) {
//            if (file.mkdir()) {
//                System.out.println("Directory is created!");
//            } else {
//                System.out.println("Failed to create directory!");
//            }
//        }

