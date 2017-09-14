/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asignmentadf2.controller;

import asignmentadf2.entity.Student;
import asignmentadf2.model.StudentModel;
import asignmentadf2.validate.Validator;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ueda
 */
public class StudentController {

    private static ArrayList<Student> listStudent;
    private static StudentModel studentModel = new StudentModel();
    Scanner scan = new Scanner(System.in);
    Student student = new Student();

    public void listStudent() {
        listStudent = studentModel.getListStudent();

        if (listStudent.isEmpty() == false) {

            System.out.println("----------- List Student ------------");
            listStudent.forEach(listStu -> {

                System.out.println("id: " + listStu.getId());
                System.out.println("name: " + listStu.getName());
                System.out.println("email: " + listStu.getEmail());
                System.out.println("email: " + listStu.getPhone());
                System.out.println("class name: " + listStu.getClassName());
                System.out.println("roll number: " + listStu.getRollNumber());
                System.out.println("");
            });
        } else {
            System.out.println("No data list student");
        }

    }

    public void addStudent() {
        Validator v = new Validator();
        System.out.println("***Please enter student information***");
        String name, email, phone, className, rollNumber;
        System.out.println("Please enter name: ");
        name = scan.nextLine();
        System.out.println("Please enter email: ");
        while (true) {
            email = scan.nextLine();
            if (v.isEmailValid(email)) {
                break;
            }
        }

        System.out.println("Please enter phone: ");
        while (true) {
            phone = scan.nextLine();
            if (v.isPhoneValid(phone)) {
                break;
            }
        }
        System.out.println("Please enter class name: ");
        className = scan.nextLine();
        System.out.println("Please enter rollNumber: ");

        rollNumber = scan.nextLine();

        student.setName(name);
        student.setEmail(email);
        student.setPhone(phone);
        student.setClassName(className);
        student.setRollNumber(rollNumber);
        studentModel.insert(student);

    }

    public void editStudent() {
        System.out.println("Please enter your ID nunber: ");
        String strId = scan.nextLine();
        int id = 0;
        try {
            id = Integer.parseInt(strId);
        } catch (NumberFormatException e) {
            System.out.println("Please enter ID is a number " + e.getMessage());

        }

        Student student = studentModel.getById(id);
        if (student != null) {
            System.out.println("---------Information student editing--------");
            System.out.println("id: " + student.getId());
            System.out.println("name: " + student.getName());
            System.out.println("email: " + student.getEmail());
            System.out.println("phone: " + student.getPhone());
            System.out.println("class name: " + student.getClassName());
            System.out.println("roll number: " + student.getRollNumber());
            System.out.println("----------------------------------------");
            String name, email, phone, className, rollNumber;
            System.out.println("Rewrite your name: ");
            name = scan.nextLine();
            System.out.println("Rewrite your email: ");
            Validator v = new Validator();
            while (true) {
            email = scan.nextLine();
            if (v.isEmailValid(email)) {
                break;
            }
        }
            System.out.println("Rewrite your phone: ");
            while (true) {
            phone = scan.nextLine();
            if (v.isPhoneValid(phone)) {
                break;
            }
        }
            System.out.println("Rewrite your class name: ");
            className = scan.nextLine();
            System.out.println("Rewrite your roll number: ");
            rollNumber = scan.nextLine();

            student.setName(name);
            student.setEmail(email);
            student.setPhone(phone);
            student.setClassName(className);
            student.setRollNumber(rollNumber);
            studentModel.update(student);
        } else {
            System.out.println("No data id number. Please choose a other number!");
        }

    }

    public void deleteStudent() {
        System.out.println("Please enter your ID number: ");
        String strId = scan.nextLine();
        int id = 0;
        try {
            id = Integer.parseInt(strId);

        } catch (NumberFormatException e) {
            System.out.println("Please enter ID is a number " + e.getMessage());
        }

        Student student = studentModel.getById(id);
        if (student != null) {
            studentModel.delete(id);
        } else {
            System.out.println("No data id number. Please choose a other number!");
        }

    }


}
