/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asignmentadf2.controller;

import asignmentadf2.entity.Student;
import asignmentadf2.model.StudentModel;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
                System.out.println("class name: " + listStu.getClassName());
                System.out.println("roll number: " + listStu.getRollNumber());
                System.out.println("");
            });
        } else {
            System.out.println("No data list student");
        }

    }

    public void addStudent() {
        System.out.println("***Please enter student information***");
        System.out.println("Please enter name: ");
        String name = scan.nextLine();
        System.out.println("Please enter email: ");
        String email = scan.nextLine();
        System.out.println("Please enter class name: ");
        String className = scan.nextLine();
        System.out.println("Please enter rollNumber: ");
        String rollNumber = scan.nextLine();

        student.setName(name);
        student.setEmail(email);
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
        
        Student student=studentModel.getById(id);
        if (student != null) {
            System.out.println("---------Information student editing--------");
            System.out.println("id: " + student.getId());
            System.out.println("name: " + student.getName());
            System.out.println("email: " + student.getEmail());
            System.out.println("class name: " + student.getClassName());
            System.out.println("roll number: " + student.getRollNumber());
            System.out.println("----------------------------------------");
            System.out.println("Rewrite your name: ");
            String name = scan.nextLine();
            System.out.println("Rewrite your email: ");
            String email = scan.nextLine();
            System.out.println("Rewrite your class name: ");
            String className = scan.nextLine();
            System.out.println("Rewrite your roll number: ");
            String rollNumber = scan.nextLine();
            
            student.setName(name);
            student.setEmail(email);
            student.setClassName(className);
            student.setRollNumber(rollNumber);
            studentModel.update(student);
        }else{
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
        
        Student student=studentModel.getById(id);
        if (student !=null) {
            studentModel.delete(id);
        } else {
            System.out.println("No data id number. Please choose a other number!");
        }

    }

    public void exportListStudent() {
        listStudent = studentModel.getListStudent();

        FileWriter fw = null;
        BufferedWriter bw = null;

        try {
            fw = new FileWriter("listStudent.txt");
            bw = new BufferedWriter(fw);

            for (Student student1 : listStudent) {
                bw.write("ID: " + student1.getId());
                bw.newLine();
                bw.write("Name: " + student1.getName());
                bw.newLine();
                bw.write("Email: " + student1.getEmail());
                bw.newLine();
                bw.write("Class name: " + student1.getClassName());
                bw.newLine();
                bw.write("Roll number: " + student1.getRollNumber());
                bw.newLine();
                bw.newLine();
            }
            System.out.println("Export list student success!");
        } catch (IOException e) {
            System.err.println(e);
        } finally {
            try {
                bw.close();
                fw.close();
            } catch (IOException e) {
                System.err.println(e);
            }

        }

    }

    public void importListStudent() {
        try {
            FileReader fr = new FileReader("listStudent.txt");
            BufferedReader br = new BufferedReader(fr);
            String str;
            while ((str = br.readLine()) != null) {
                System.out.println(str);
            }
            System.out.println("Import list student success!");
        } catch (FileNotFoundException e) {
            System.err.println(e);
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

    

}
