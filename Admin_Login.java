

package Advising_System;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Admin_Login {
     static String currentDirectory;
     static String id;
    private static String[] args;
    public static void main(String[] args) throws Exception {
        File file = new File("\\");
		currentDirectory = file.getAbsolutePath();
          Scanner input = new Scanner(System.in);
          System.out.print("Enter Admin ID: ");
        String ID = input.next();  
        String user_pass= passChecker(ID);
        
         System.out.print("Enter Password: ");
         String given_pass = input.next();
         
         if (user_pass.equals(given_pass)){
             System.out.println("Welcome Admin " +ID);
            id=ID;
             adminAccess(); 
            
         }
         else{
             System.out.println("Wrong Password. Try again");
               main(args);
         }}
    
    //private static void 
 private static  String passChecker(String ID) throws Exception{
          String info = ID+"_Admin.txt";
        String pass=null;
        
        //String path= currentDirectory+"Java_Project\\Admin";
        String  path = "C:\\Advising System\\Admin Files";
        File f = new File(path,info);
       if (f.exists()) {

           try{
            Scanner read = new Scanner(f);
        while   (read.hasNext()){
            pass = read.next();
        }    
        }catch(FileNotFoundException e){System.out.println("Account Not Found");}
        
      
        return pass;

     }
       else{
           System.out.println("Not an Admin Account");
           main(args);
           return null;
       }      
     }
 private static void adminAccess() throws Exception{
      Scanner input = new Scanner(System.in);
        System.out.println("1: Add New Student\n2: View Student Info\n3: Edit Student Info\n4: View Student List\n5: Change Password\n6: Log Out");
         System.out.print("Enter Choice: ");
         int choice = input.nextInt();
         switch (choice) {
            case 1: addNewStudent();
                 break; 
            case 2:  viewStudentProfile();
                
                break;
            case 3: editStudentInfo();
                 break;
            case 4: viewStudentList();
                break;
            case 5:  
                editPass();
                 break;
            case 6: 
                 MAIN_OUTPUT.main(args);
                 break;
             default:
                 System.out.println("wrong Choice, Try Again");
                 adminAccess();
         }
      
 }
   private  static void addNewStudent() throws Exception{
       Scanner in= new Scanner (System.in);
        System.out.println("\nEnter New Student Info: ");
        System.out.print("First Name: ");
        String fName =in.nextLine();
        System.out.print("Middle Name: ");
        String mName =in.nextLine();
        System.out.print("Last Name: ");
        String lName =in.nextLine();
        String Name= fName+" "+mName+" "+lName;
         System.out.print("ID: ");
         String ID=in.nextLine();
         System.out.print("Enrolled in: ");
         String enIn= null;
         while(true){
         enIn=in.nextLine();
         enIn= enIn.toUpperCase();
         if (enIn.equalsIgnoreCase("CSE")||enIn.equalsIgnoreCase("EEE")||enIn.equalsIgnoreCase("ETE")) {
                 break;
             }
         else{
             System.out.print("Enter a valid dept.:  ");
         }
         }
         
         System.out.print("Enroll Session: ");
         String enS=in.nextLine();
         enS=enrollSessionCecker(enS);
         System.out.print("Credit Passed: ");
        int cPass=in.nextInt();
        System.out.print("CGPA: ");
        double  cgpa=in.nextDouble();
       
         StudentProfile s= new StudentProfile(Name, ID,enIn,enS, cPass, cgpa);
         System.out.println("Profile Creation Successfull\n\n\n");
          adminAccess(); 
 }
   private static void viewStudentProfile() throws Exception{
        Scanner in= new Scanner (System.in);
       System.out.print("Enter Student ID: ");
       String ID = in.next();
       Student_Login.studentProfile(ID);
       adminAccess();
   }
   private static void editStudentInfo() throws Exception{
        Scanner in= new Scanner (System.in);
      System.out.println("Enter Student ID to edit: ");
      String ID=in.nextLine();
       String info = ID+"_Profile.txt";
        String pass=null;
          String path= currentDirectory+"Java_Project\\Project Files\\StudentsProfiles";
        File f = new File(path,info);
        //File f = new File("H:\\Java_Project\\Project Files\\StudentsProfiles",info);
 try (FileInputStream fis = new FileInputStream(f)) {
 			int content;
			while ((content = fis.read()) != -1) {
				// convert to char and display it
                    
				System.out.print((char) content);
                                
			} 
		} catch (Exception e) {System.out.println("Error Loading Profile");}
        System.out.println("\nEdit Data of: "+ID);
        System.out.println("\n(write every info)");
        System.out.print("First Name: ");
        String fName =in.nextLine();
        System.out.print("Middle Name: ");
        String mName =in.nextLine();
        System.out.print("Last Name: ");
        String lName =in.nextLine();
        String Name= fName+" "+mName+" "+lName;
         System.out.print("Enrolled in: ");
         String enIn=in.nextLine();
         System.out.print("Enroll Session: ");
         String enS=in.nextLine();
         enS=enrollSessionCecker(enS);
         System.out.print("Credit Passed: ");
        int cPass=in.nextInt();
        System.out.print("CGPA: ");
        double  cgpa=in.nextDouble();
    StudentProfile s= new StudentProfile(Name,enIn,enS, cPass, cgpa,ID);
       System.out.println("Edit data Successfull");
       System.out.println("\n\n\n");
   adminAccess();
   }
   private static void viewStudentList() throws Exception{
       Scanner input = new Scanner(System.in);
         String[] args = {};
        System.out.print("Enter Department(CSE/EEE/ETE):");
       String dept= input.next();
         String info = dept+"_Dept.txt";
  //  String path= currentDirectory+"Java_Project\\Project Files\\StudentsProfiles";
      //  File f = new File(path,info);
        File f= new File("C:\\Advising System\\Admin Files\\Departments",info);
        try {
            Scanner read = new Scanner(f);
            while(read.hasNext()){
                   System.out.println(read.nextLine()); 
                    
                
            }
        } catch (Exception e) { System.out.println("Error. File not Found");
        }
            System.out.println("\n\n\n");
   adminAccess();
   }
   private static void editPass() throws Exception{
       
        Scanner input = new Scanner(System.in);
         String[] args = {};
        System.out.print("Enter password:");
       String pass= input.next();
                      
                
       String info = id+"_Admin.txt";
//    String path= currentDirectory+"Java_Project\\Project Files\\StudentPasswords";
//        File f = new File(path,info);
     String  path = "C:\\Advising System\\Admin Files";
        File f= new File(path,info);
     
     PrintWriter p= null;
     try {
     
     p = new PrintWriter (f);
    // p.print("Password: ");
   p.print(pass);
     }catch(FileNotFoundException e){System.out.println("Error");
     }finally {
    p.close();}    
                System.out.println("Password Changed Successfully. Please login again");
 
   main(args); 
   }
       
   private static String enrollSessionCecker(String enS){
       int e = Integer.parseInt(enS);
       int session = e%10;
       int year = e/10;
       if(session == 1){
           return "Spring'"+year;
       }
       else if(session == 2){
           return "Summer'"+year;
       }
       else if(session == 3){
           return "Fall'"+year;
       }
       else{
           return enS;
       }
   }
 
 
}
