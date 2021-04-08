/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package didemonstration;

import data.BySEGt5;
import data.Student;
import data.StudentManager;
import java.util.List;
import util.Filter;

/**
 *
 * @author DELL
 */
public class DIMain {
    // neu nhieu main() thi co 1 main() default voi F6
    // main() con lai la shift F6
    public static void main(String[] args) {
        // 1. sv SE >=5
        Filter bySEGt5 =  new BySEGt5();
        // luc nay ta da co object kieu Filter/BySEGt5
        // va co code cho ham check roi
        // thay no vao cho ham getStudents(check() co code)
        StudentManager sm = new StudentManager();
        //co ds sv all
        List<Student> result = sm.getStudents(bySEGt5);
        System.out.println("List of SE STUDENT WITH GPA >=5");
        for (Student x : result) 
            x.showProfile();
        
        
        //2. em muon ds sinh vien nganh IA, lam sao ?
        //dua cai dieu kien loc cua ban vao trong ham check() di roi thay vao ham getStudents()
        // lam class roi chan roi
        // chi can lam ham thoi, anonymous class roi cho lanh
        Filter byIA = new Filter<Student>() {
            @Override
            public boolean check(Student obj) {
                return obj.getMajor().equalsIgnoreCase("IA");
            }
        };
        // search va show ket qua
        result = sm.getStudents(byIA);
        System.out.println("List of IA STUDENT ");
        for (Student x : result) 
            x.showProfile();
        
        //3.  tui muon danh sach sinh vien SB >5
        // can ham check() thoi cua class filter, minh tao class roi 
        // minh anonymous la 1 cach, va vi filter chi co 1 ham duy nhat 
        // dep luon ten ham cho gon code -> lamda expression
        // ham viet nhu cau lenh
        
        Filter bySBGt5 = (Filter<Student>) o -> o.getMajor().equalsIgnoreCase("SB")&&o.getGpa()>=5; 
        result = sm.getStudents(bySBGt5);
        System.out.println("List of SB STUDENT WITH GPA >=5");
        for (Student x : result) 
            x.showProfile();
    }
}
