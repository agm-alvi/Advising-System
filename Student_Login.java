
package Advising_System;

import java.io.*;
import java.util.Scanner;
import java.lang.*;


public class Student_Login {
    static String id;
    
     public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
       
		
      
         System.out.println("1: Sign in\n2: Sign up\n3: Back\n4: Exit");
         System.out.print("Enter Choice: ");
         int choice = input.nextInt();
         switch (choice) {
            case 1: signIn();
                 break;
            case 2: signUp();
                 break;
               case 3: MAIN_OUTPUT.main(args);
                 break;
            case 4: System.exit(00);
                 break;  
             default:
                 //throw new AssertionError();
                 
                 System.out.println("wrong Choice, Try Again");
                 
                 main(args);
         
         }
      
        //System.out.println("Enter Choice: ");
    
    }
     
    private static void signIn() throws Exception{
           Scanner input = new Scanner(System.in);
          System.out.print("Enter ID: ");
        String ID = input.next();
        String info = ID+"_Password.txt";
        
        File f = new File("C:\\Advising System\\Student Files\\StudentPasswords",info);
        
         if(f.exists()){
        id = ID;
        String user_pass= passChecker(ID);
        if(!"null".equals(user_pass)){
         System.out.print("Enter Password: ");
         String given_pass = input.next();
         
         if (user_pass.equals(given_pass)){
             System.out.println("Welcome " +ID);
             studentAccess();
         }
         else{
             System.out.println("Wrong Password. Try again");
               String[] args = {};
               main(args);
         }}
        else {
                 System.out.println("Sign up first");
                 String[] args = {};
                 main(args);

        }
         }
        else {
            System.out.println("Account Not Enrolled");
            String[] args = {};
                 main(args);
        } 
         
    }
    private static void signUp() throws Exception{
        String[] args = {};
               Scanner in= new Scanner (System.in);
        System.out.println("Enter New Student Info: ");
         System.out.print("\nID: ");
         
         String ID=in.nextLine();
          String info = ID+"_Password.txt";
       
        
        File f = new File("C:\\Advising System\\Student Files\\StudentPasswords",info);
//        try{          
//        }catch(Exception e){System.out.println("Account Not Enrolled");}
        if(f.exists()){
             String user_pass= passChecker(ID);
            if("null".equals(user_pass)){
                
      System.out.print("Enter password:");
       String pass= in.next();
       StudentProfile s= new StudentProfile( ID,pass);
        main(args);
            }
            else {
                System.out.println("Already Singed Up");
                System.out.println("If forgot Your Password, Contact Admin");
            
                 main(args);
            }
        }
        else {
            System.out.println("Account Not Enrolled");
            
                 main(args);
        } 
         
    } 
    private static  String passChecker(String ID){
         String info = ID+"_Password.txt";
        String pass=null;
        
       
        File f = new File("C:\\Advising System\\Student Files\\StudentPasswords",info);
        try{
            Scanner read = new Scanner(f);
        while   (read.hasNext()){
            pass = read.next();
        }    
        }catch(Exception e){System.out.println("Account Not Found");}
        if(pass.equals("null")){
            return "null";
        }
        else{
        return pass;
        }
     }
            static void studentAccess() throws Exception{
        Scanner input = new Scanner(System.in);
        String[] args = {};
        System.out.println("1: View Profile\n2: Advising Window\n3: View Enrolled Courses\n4: Change Password\n5: Log Out");
         System.out.print("Enter Choice: ");
         int choice = input.nextInt();
         
         switch (choice) {
            case 1: studentProfile(id);
             studentAccess();
                 break;
            case 2: advising();
                 break;
            case 3: viewCourses();
                break;
            case 4:  editPass();
                 break;
            case 5: 
                 MAIN_OUTPUT.main(args);
                 break;
             default: 
                 System.out.println("wrong Choice, Try Again");
                 main(args);
         }
      
    }
         static void studentProfile(String ID) throws Exception{
        String info = ID+"_Profile.txt";
        String pass=null;
        File f = new File("C:\\Advising System\\Student Files\\StudentsProfiles",info);

try {
            Scanner read = new Scanner(f);
            while(read.hasNext()){
                   System.out.println(read.nextLine()); 
                    
                
            }
        } catch (Exception e) { System.out.println("Error. File not Found");
        }
        System.out.println("\n\n\n");

    }
    private static void viewCourses() throws Exception{
         String info = id+"_Courses.txt";
        String pass=null;
        File f = new File("C:\\Advising System\\Student Files\\StudentCourses",info);
int check = advisingChecker();
if(check<6){
    System.out.println("You Have not advised. Please do your Advising.");
}
else{
        try {
            Scanner read = new Scanner(f);
            while(read.hasNext()){
                   System.out.println(read.nextLine()); 
                    
                
            }
        } catch (Exception e) { System.out.println("Error. File not Found");
        }
        System.out.println("\n\n\n");
}
 studentAccess();
    }
    private static void editPass() throws Exception{
        Scanner input = new Scanner(System.in);
         String[] args = {};
        System.out.print("Enter password:");
       String pass= input.next();
       StudentProfile s= new StudentProfile( id,pass);
                System.out.println("Password Changed Successfully. Please login again");
                
                main(args);
    } 

    private static int advisingChecker(){
       
    String info = id+"_Courses.txt";
        File f= new File("C:\\Advising System\\Student Files\\StudentCourses",info);
        int line=0;
        
        System.out.println(f.exists());
        try {
            Scanner read = new Scanner(f);
            while(read.hasNextLine()){
                read.nextLine();
                  // System.out.println(read.nextLine()); 
                    line++;
                
            }
        } catch (Exception e) { System.out.println("Error. File not Found");
        }
        return line;
    }
    private static void advising() throws Exception{
        Scanner input = new Scanner(System.in);
    int check = advisingChecker(); 
               
    if(check>6){
    System.out.println("You Have already advised.\nDO you want to delete all previous courses and advise again?");
                    System.out.println("1: Yes\n2: No");
                    System.out.print("Enter Choice: ");
                    int ad_choice = input.nextInt();
                    if(ad_choice==1){
                        String info = id+"_Courses.txt";
        File f= new File("C:\\Advising System\\Student Files\\StudentCourses",info);
     
     PrintWriter p= null;
     try {
     
     p = new PrintWriter (f);
     p.println("\t  Courses Taken");
     p.println("\t-------------------\n");
     p.println("Course\t  Faculty\t   Room  \tTime");
   
     }catch(FileNotFoundException e){System.out.println("Error");
     }finally {
    p.close();}
    
                         Advising.advise(id);
                    }
                    else{
    studentAccess();}
       } 
else{
                Advising.advise(id);}
    }
    
}
