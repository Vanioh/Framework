package main;
import  etu1835.framework.Utile;
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
            Utile u= new Utile();
            HashMap<String,Mapping> mappingUrls = new HashMap<>();
            mappingUrls= u.getHashmap( mappingUrls,  "C:/Program Files/Apache Software Foundation/Tomcat 10.1/webapps/Sprint3/WEB-INF/classes/etu1835/framework/modele");
            System.out.println(mappingUrls);
            u.printHM(mappingUrls);

            
        } catch (Exception e) {
            e.printStackTrace();
            // TODO: handle exception
        }
       
    }
}