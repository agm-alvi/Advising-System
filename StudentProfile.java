
package Advising_System;

import java.io.*;
import java.util.Scanner;


public class StudentProfile {
    static String currentDirectory;
    private  String name;
    private  String id;
    private  String enroll;
    private  String enSession;
    private  int CrPass;
    private  double  cgpa;
private  String password;

    public StudentProfile(String id, String password) {
       
        this.id = id;
        this.password = password;
        createPassword();
    }

    public StudentProfile(String name, String id, String enroll, String enSession, int CrPass, double  cgpa) throws Exception {
        this.name = name;
        this.id = id;
        this.enroll = enroll;
        this.enSession = enSession;
        this.CrPass = CrPass;
        this.cgpa = cgpa;
      //  this.password= password;
        
        createProfile();
        createCourseList();
        createPassword();
        addDept();
    }
    
    public StudentProfile(String name, String enroll, String enSession, int CrPass, double  cgpa, String id) {
        this.name = name;
        this.id = id;
        this.enroll = enroll;
        this.enSession = enSession;
        this.CrPass = CrPass;
        this.cgpa = cgpa;
      //  this.password= password;
        
        createProfile();
    }
    public static void main(String[] args) {
        File file = new File("\\");
         currentDirectory = file.getAbsolutePath();
         //System.out.println(currentDirectory);
    }

    public void setCgpa(double cgpa) {
        this.cgpa = cgpa;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
    
   
    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getEnroll() {
        return enroll;
    }

    public String getEnSession() {
        return enSession;
    }

    public int getCrPass() {
        return CrPass;
    }

    public double  getCgpa() {
        return cgpa;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setEnroll(String enroll) {
        this.enroll = enroll;
    }

    public void setEnSession(String enSession) {
        this.enSession = enSession;
    }

    public void setCrPass(int CrPass) {
        this.CrPass = CrPass;
    }

    public void setCgpa(int cgpa) {
        this.cgpa = cgpa;
    }

    @Override
    public String toString() {
        return "Student Profile:\n" + "Name: " + name + "\n Id: " + id + "\n Enroll: " + enroll +
        "\n Enroll Session: " + enSession + "\n Credit Pass: " + CrPass + "\n CGPA: " + cgpa ;
    }
    
    
    
    private void createProfile(){
    String info = id+"_Profile.txt";
  //  String path= currentDirectory+"Java_Project\\Project Files\\StudentsProfiles";
      //  File f = new File(path,info);
        File f= new File("C:\\Advising System\\Student Files\\StudentsProfiles",info);
        
    PrintWriter p= null;
     try {
     
     p = new PrintWriter (f);
     p.println("\t  Student Profile");
     p.println("\t-------------------\n");
     p.println(" \tName: " + name);
     p.println( " \tID: " + id );
     p.println( " \tEnrolled in: " + enroll  );
     p.println( " \tEnroll Session: " + enSession);
     p.println( " \tCredit Pass: " + CrPass);
     p.println( " \tCGPA: " + cgpa );
   
     }catch(FileNotFoundException e){System.out.println("Error");
     }finally {
    p.close();}
    }
    private void createCourseList(){
    String info = id+"_Courses.txt";
   // String path= currentDirectory+"Java_Project\\Project Files\\StudentCourses";
      // File f = new File(path,info);
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
    }
    private void createPassword(){
    String info = id+"_Password.txt";
   // String path= currentDirectory+"Java_Project\\Project Files\\StudentPasswords";
       // File f = new File(path,info);
    
        File f= new File("C:\\Advising System\\Student Files\\StudentPasswords",info);
     
     PrintWriter p= null;
     try {
     
     p = new PrintWriter (f);
    // p.print("Password: ");
   p.print(password);
     }catch(FileNotFoundException e){System.out.println("Error");
     }finally {
    p.close();}
    }
    private void addDept() throws Exception{
        
        String info = enroll+"_Dept.txt";
        File f= new File("C:\\Advising System\\Admin Files\\Departments",info);
        
    FileWriter p= null;
     try {
     
     p = new FileWriter (f,true);
      p.write(System.getProperty( "line.separator" ));
     p.write(id);
     p.write(" -  "+name);
   
     }catch(FileNotFoundException e){System.out.println("Error");
     }finally {
    p.close();}
    
    }
}
