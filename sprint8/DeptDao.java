package etu1835.framework.modele;
import etu1835.framework.annotation.*;
import java.lang.annotation.*;
import java.time.LocalDateTime;
@dao(table="DeptDao")
public class DeptDao{
    int id;
    String libele;
    String loc;
    
    public DeptDao() {
    }
    public DeptDao(int id, String libele, String loc) {
        this.id = id;
        this.libele = libele;
        this.loc = loc;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getLibele() {
        return libele;
    }
    public void setLibele(String libele) {
        this.libele = libele;
    }
    public String getLoc() {
        return loc;
    }
    public void setLoc(String loc) {
        this.loc = loc;
    }

    public void Save(){
        System.out.println("IDDept :"+  this.getId());
        System.out.println("Libele :" + this.getLibele());
        System.out.println("Loc :" + this.getLoc());

    }
    

}