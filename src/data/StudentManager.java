/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.ArrayList;
import java.util.List;
import util.Filter;

/**
 *
 * @author DELL
 */
public class StudentManager {

    private List<Student> stdList = new ArrayList<>();
    //  private Filter cond;    // set cond qua nga constructor
                                // thi.cond=cond;
    // ham setCond(Filter con) {this.cond = cond;}
    
    // du lieu 10 sinh vien phai duoc bo vao stdList bo vao qua constructor
    // qua ham setter() nao do ,...
    // nay choi tro la ti
    {
        // doan code nam trong cap ngoac {} khong thuoc ve ham nao ca thi goi la floating-block-of-code
        // co quyen gan static phia truoc, ko gan goi la non-static;
        // thuong dung de khoi dong gi do
        stdList.add(new Student("SE140856", "Tin Huynh", 2000, 9.0, "SE"));
        stdList.add(new Student("SE140855", "Thuan Nguyen", 1987, 4.9, "SE"));
        stdList.add(new Student("IA140854", "Nhan Le", 1999, 7.0, "IA"));
        stdList.add(new Student("IA140853", "Dat Do", 1986, 6.0, "IA"));
        stdList.add(new Student("SB140852", "Long Bui", 1869, 5.0, "SB"));
        stdList.add(new Student("SB140851", "Khanh Nguyen", 1984, 4.0, "SB"));
    }

    //1. tim liet ke danh sach sinh vien
    public List<Student> getStudents() {
        return stdList;
    }

    //2. liet ke danh sach sinh vien nganh SE
    public List<Student> getSEStudents() {
        List<Student> result = new ArrayList();
        for (Student student : stdList) {
            if (student.getMajor().equalsIgnoreCase("SE")) {
                result.add(student);
            }
        }
        return result;
    }

    //3. liet ke danh sach sinh vien nganh GD
    //them ham moi hay so cach nao khac ??
    //tot nhat la truyen Major vao
    //quy uoc: SE, GD, EL, SS,...
    public List<Student> getStudents(String major) {
        List<Student> result = new ArrayList<>();
        for (Student student : stdList) {
            if (student.getMajor().equalsIgnoreCase(major)) {
                result.add(student);
            }
        }
        return result;
    }

    //4. Liet ke cac sv nganh SE diem tb >=8
    //5. Liet ke cac sv diem tb >=8
    //6. Liet ke cac sv diem <5
    //7. Con n cai loai liet ke khac nua
    //nhu vay ta phai viet lam sao de ben StudentManager khong phai sua code them ham cho moi filter
    //giam thieu viec them ham trong Manager
    //cah 1: ko tron ven, dung flag
    // quy uoc ngam4
    // filterType : 1 lay sv nganh se
    // filterType : 1 lay sv nganh ia
    // filterType : 1 lay sv nganh sb
    // filterType : 1 lay sv nganh se >=5
    // filterType : 1 lay sv nganh ia >=5
    // filterType : 1 lay sv tat ca cac nganh GPA >=5
    public List<Student> getStudents(int filterType) {
        List<Student> result = new ArrayList<>();
        switch (filterType) {
            case 1:
                for (Student x : stdList) {
                    if (x.getMajor().equals("SE")) {
                        result.add(x);
                    }
                }
                break;
            case 2:
                for (Student x : stdList) {
                    if (x.getMajor().equals("IA")) {
                        result.add(x);
                    }
                }
                break;
            case 3:
                for (Student x : stdList) {
                    if (x.getMajor().equals("SB")) {
                        result.add(x);
                    }
                }
                break;
            case 4:
                for (Student x : stdList) {
                    if (x.getMajor().equals("SE") && x.getGpa()>=5) {
                        result.add(x);
                    }
                }
                break;
        }
        return result;
    }
    //cach 2: dung DI (dependency Infection) se giup k can phai sua code getStudent ma van tra ve ds sinh vien dung cau query cua ban dua vao
    //DI : thay vi ham getStudent() phai lo cau query
    // ai muon ham nay lam cau nao, ai do phai tu lo cau query va dua cau query vao
    // dua code query vao ham 
    // HIEN NAY: Ham tu lo cau query TAO LO CAU QUERY CUA MAY
    // DI: TAO CHAY CAU CUA MAY
    // to chi nhan vao bo loc cho cau dua nao
    // nho la phai co ham check(), trong do co chua code, vi b muon loc
    // vay cau muon loc the nao thi viet code di
    // implement cai Filter
    // to chi goi ham check(sv) cua cau va tra ve sinh vien cau muon
    public List<Student> getStudents(Filter  cond){
         List<Student> result = new ArrayList<>();
        // lam sao biet tra ve sv nao
        // ta thay tung sv ta dang co cho cai ham check() cua ngta
        // ngta bao rang sv nay vao danh sach list tra ve
        // ta da chuyen cai if cho ngta lo
        // ngta dua cai where cai if vao do la DEPENDENCY dc chich nao
        // ham cu ta tu if do ta dua ra
        for (Student x : stdList) {
            // tao gui tung sv cho ham check() cua may
            // may dua tao object co chua ham cua may
            // tao goi may
            if(cond.check(x)== true){
                result.add(x);
            }
        }
        return result;
    }
    
    
    
    // MO RONG:
    // co nhieu cach choi voi DI
    // 1. truyen dependency / object chu abtracts qua constructor
    // 2. truyen depen ... qua setX(depen here)
    // 3. Lam cai ham nhu minh dang lam
    
    
}
