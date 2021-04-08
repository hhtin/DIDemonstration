/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import util.Filter;

/**
 *
 * @author DELL
 */
// class roi choi vs interface , em muon di dua, gia nhap hoi
public class BySEGt5 implements Filter<Student>{

    @Override
    public boolean check(Student obj) {
        // ban se viet code cho ham check() nhu ban muon va quang ham nay vao ham getStudent()
//        if(obj.getMajor().equalsIgnoreCase("SE") && obj.getYob()>=5)
//            return true;
//        return false;

//        obj.equals("a");
        return obj.getMajor().equalsIgnoreCase("SE") && obj.getGpa()>= 5 ;
    }
    
}
