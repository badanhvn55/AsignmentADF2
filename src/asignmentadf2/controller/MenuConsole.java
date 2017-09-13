/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AsignmentADF2.controller;

import java.util.Scanner;

import asignmentadf2.controller.StudentController;

public class MenuConsole {
    
    StudentController studentController=new StudentController();

    public void menu() {
        while (true) {
            System.out.println("============== MENU =================");
            System.out.println("1. List student.");
            System.out.println("2. Add student.");
            System.out.println("3. Edit student.");
            System.out.println("4. Delete student.");
            System.out.println("5. Export list student to file.");
            System.out.println("6. Import list student from file.");
            System.out.println("7. Exit.");
            System.out.println("-------------------------------------");
            System.out.println("Select request: ");
            Scanner scan = new Scanner(System.in);
            String selectStr = scan.nextLine();
            int select=0;
            try {
                select=Integer.parseInt(selectStr);
            } catch (NumberFormatException e) {
                System.err.println("Please enter a number!");
            }
            
            if (select == 7) {
                break;
            } else {

                switch (select) {
                    case 1:
                        //list student
                        studentController.listStudent();
                        break;
                    case 2:
                        //add student
                        studentController.addStudent();
                        break;
                    case 3:
                        //edit student
                        studentController.editStudent();
                        break;
                    case 4:
                        //delete student
                        studentController.deleteStudent();
                        break;
                    case 5:
                        //export student
                        studentController.exportListStudent();
                        break;
                    case 6:
                        //Import student
                        studentController.importListStudent();
                        break;
                    default:
                        System.out.println("Please enter number from 1 to 7");
                }
            }
        }
    }

    public static void main(String[] args) {
        MenuConsole menuConsole=new MenuConsole();
        menuConsole.menu();
    }

}
