/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package didemonstration;

import data.Student;
import data.StudentManager;
import java.awt.List;

/**
 *
 * @author DELL
 */
public class DIDemonstration {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        StudentManager sm=new StudentManager();
        //1. In danh sach sinh vien
        System.out.println("The list of students =========");
        for (Student student : sm.getStudents()) {
            student.showProfile();
        }
        
        //2 In ds SV nganh SE
        System.out.println("");
        System.out.println("The List Of SE Students");
        for (Student seStudent : sm.getSEStudents()) {
            seStudent.showProfile();
        }
        
        //3 IN ds SV nganh SB
        System.out.println("");
        System.out.println("The List Of SB Students");
        for (Student seStudent : sm.getStudents("SB")) {
            seStudent.showProfile();
        }
        
        //4 in ds sv nganh SE >=5
        for (Student x : sm.getStudents(4)) {
            x.showProfile();
        }
        System.out.println();
        
        //5. toi muon in sv theo .....n thu khac nhau
        // vay sau ham getStudents ko la cau chuyen hay
        // neu co the dua luon if else chua query cho ham getStudents;
        // la dep nhat
        //DI bat dau
    }
    
}
