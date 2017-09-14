/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asignmentadf2.FileHandle;

import asignmentadf2.entity.Student;
import asignmentadf2.model.StudentModel;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author ueda
 */
public class FileHandle {
    
    ArrayList<Student> listStudent;
    
    public void exportListStudent() {
        StudentModel studentModel=new StudentModel();
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
                bw.write("Phone: " + student1.getPhone());
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
