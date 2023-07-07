package main;
import  etu1835.framework.Utilitaire;
import java.util.ArrayList;
import java.util.HashMap;
import java.lang.annotation.*;
import etu1835.framework.Mapping;
import java.lang.reflect.Field;
import javax.print.attribute.standard.Media;
import annotation.*;
public class Main{
    public static void main(String[] args) {
       
        try {
            Utilitaire u= new Utilitaire();
            HashMap<String,Mapping> mappingUrls = new HashMap<>();
            mappingUrls= u.getHashmap( mappingUrls,  "C:/Program Files/Apache Software Foundation/Tomcat 10.1/Script1/WEB-INF/classes/etu1835/framework/modele");
            System.out.println(mappingUrls);
            u.printHM(mappingUrls);

            
        } catch (Exception e) {
            e.printStackTrace();
            // TODO: handle exception
        }
       
    }
}