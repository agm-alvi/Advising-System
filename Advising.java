
package Advising_System;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Advising {

    public static void main(String[] args) throws Exception {

    }
    public static void advise(String id) throws Exception{
        Scanner in = new Scanner(System.in);
        String[][] courses = {{"01","CSE115","1","AAA","SAC311","9:40AM-11:10AM","MW"},
                              {"02","CSE115","2","AAA","SAC311","11:20AM-12:50PM","MW"},
                              {"03","CSE115","3","BBB","SAC311","8:00AM-9:40AM","ST"},
                              {"04","CSE115","4","CCC","SAC311","1:00PM-2:30PM","MW"},
                              {"05","CSE115","5","DDD","SAC311","9:40AM-11:10AM","ST"},
                              
                              {"06","CSE173","1","DDD","SAC311","8:00AM-9:40AM","ST"},
                              {"07","CSE173","2","HHH","SAC311","9:40AM-11:10AM","MW"},
                              {"08","CSE173","3","HHH","SAC311","1:00PM-2:30PM","RA"},
                              {"09","CSE173","4","FFF","SAC311","2:40PM-4:10PM","ST"},
                              {"10","CSE173","5","CCC","SAC311","11:20AM-12:50PM","MW"},
                              
                              {"11","CSE215","1","BBB","SAC311","8:00AM-9:40AM","ST"},
                              {"12","CSE215","2","BBB","SAC311","11:20AM-12:50PM","ST"},
                              {"13","CSE215","3","AAA","SAC311","9:40AM-11:10AM","MW"},
                              {"14","CSE215","4","CCC","SAC311","11:20AM-12:50PM","MW"},
                              {"15","CSE215","5","AAA","SAC311","9:40AM-11:10AM","RA"},
                              
                              {"16","CSE225","1","FFF","SAC311","11:20AM-12:50PM","MW"},
                              {"17","CSE225","2","DDD","SAC311","9:40AM-11:10AM","RA"},
                              {"18","CSE225","3","EEE","SAC311","11:20AM-12:50PM","RA"},
                              {"19","CSE225","4","GGG","SAC311","1:00PM-2:30PM","MW"},
                              {"20","CSE225","5","CCC","SAC311","8:00AM-9:40AM","ST"},
                              
                              {"21","EEE141","1","YYY","SAC311","9:40AM-11:10AM","ST"},
                              {"22","EEE141","2","ZZZ","SAC311","11:20AM-12:50PM","ST"},
                              {"23","EEE141","3","YYY","SAC311","8:00AM-9:40AM","MW"},
                              {"24","EEE141","4","YYY","SAC311","11:20AM-12:50PM","RA"},
                              {"25","EEE141","5","SSS","SAC311","9:40AM-11:10AM","RA"},
                              
                              {"26","EEE111","1","GGG","SAC311","1:00PM-2:30PM","MW"},
                              {"27","EEE111","2","SSS","SAC311","8:00AM-9:40AM","ST"},
                              {"28","EEE111","3","ZZZ","SAC311","11:20AM-12:50PM","MW"},
                              {"29","EEE111","4","ZZZ","SAC311","9:40AM-11:10AM","ST"},
                              {"30","EEE111","5","YYY","SAC311","11:20AM-12:50PM","RA"}
        };
        for (int i = 0; i < courses.length; i++) {
            for (int j = 0; j < courses[i].length; j++) {
            System.out.print(courses[i][j]+" ");   
            }
            System.out.println("");
        }
        String[][] taken = new String[3][7];
        System.out.println("Enter Course sl you want to Take(max 3): ");
        for (int i = 0; i < 3; i++) {            
            int choice = in.nextInt();
            if(choice>30){System.out.println("Wrong Selection. Try again"); i--;}
            else{
            if(i>0){
                for (int j = 0; j < i; j++) {
                 if(taken[j][1].equals(courses[choice-1][1])){
                        System.out.println("Cant take same Course ");
                 i--;}
                
                else if(taken[j][5].equals(courses[choice-1][5])&&taken[j][6].equals(courses[choice-1][6])){
                        System.out.println("Cant take in same Time ");
                 i--;}
                
             else{
                taken[i]=courses[choice-1];
            }   }
            }
            else{
                taken[i]=courses[choice-1];
            }
        }
        }
         courseFile(id,taken);
    Student_Login.studentAccess();
    }
    private static void courseFile(String id, String[][] taken) throws IOException{
//        for (int i = 0; i < taken.length; i++) {
//        System.out.println(taken[i][1]+""+taken[i][5]+""+taken[i][6]);   
//        }
       String info = id+"_Courses.txt";
//    String path= currentDirectory+"Java_Project\\Project Files\\StudentCourses";
//        File f = new File(path,info);
        File f= new File("C:\\Advising System\\Student Files\\StudentCourses",info);
     
     FileWriter p= null;
     try {
     p = new FileWriter (f,true);
         for (int i = 0; i < taken.length; i++) {
              p.write(System.getProperty( "line.separator" ));
     p.write(taken[i][1]+"."+taken[i][2]+"\t"+taken[i][3]+"\t"+taken[i][4]+"\t"+taken[i][5]+" "+taken[i][6]);
    
     
         }
     }catch(FileNotFoundException e){System.out.println("Error");
     }finally {
    p.close();}
    
    }
    /* 
*/        
 }
