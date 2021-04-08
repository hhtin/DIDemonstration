/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author DELL
 */

// loc moi thu, ko chi sinh vien
// ta dung ki thuat k care kieu du lieu (generic)
@FunctionalInterface  //sonh sinh voi lambda
// dam bao interface nay chi co duy nhat 1 ham
public interface Filter <T> {
    
    public boolean check(T obj);
    // day la ham nhan vao 1 object nao do va tra ve true false
    //code cua ham the nao de true/false do la viec cua ng su dung class
    //class nay giong clb racer co ham run() abstract
    // VD student implements racer
    
    
}

//muon xai interface co nhung cach sau
//1. lam class roi, class le concrete class chua full code cho ham abstract
// sau do new class le nay

// 2. chi can code cho ham abtract, new luon 
// de viet ham -> anonymous class
// new filter() { .... } ; dung quen ;

// 3. lambda expression neu interface chi co duy nhat 1 ham abstract
// chinh la anonymous class + bo luon ten ham abstract
// chi giu lai tham so + code