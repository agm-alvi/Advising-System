
package Advising_System;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;



public class MAIN_OUTPUT {

    
    public static void main(String[] args) throws Exception {
       
         Scanner input = new Scanner(System.in);
       DirectoryCreator.main(args);
         System.out.println("1: Admin Log in\n2: Student Log in\n3: Exit");
         System.out.print("Enter Choice: ");
         int choice = input.nextInt();
         switch (choice) {
            case 1: Admin_Login.main(args);
                 break;
            case 2: Student_Login.main(args);
                 break;
              case 3: System.exit(0);
                     break;
              
             default:
                  System.out.println("wrong Choice, Try Again");               
                 main(args);
         }
    }
}
