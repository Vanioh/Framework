package etu1835.framework.servlet;
import java.sql.SQLException;
import java.io.*;
import java.lang.reflect.Field;

import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import etu1835.framework.*;
import etu1835.framework.Utilitaire;
import etu1835.framework.Mapping;
public class FrontServlet extends HttpServlet 
{
    HashMap<String,Mapping> mappingUrls = new HashMap<>();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                try {
                    response.setContentType("text/plain");
                    PrintWriter out = response.getWriter();
                    Utilitaire u = new Utilitaire();
                    ServletContext context= getServletContext();
                    String path= u.getPath(request); //Premiere methode
                    System.out.println(path);
                    String meth = u.getMethode(request); // Deuxieme methode  
                    System.out.println(meth);
                    out.println(meth);            
                    Class[] classes = u.AllClasses();

                    for (int i = 0; i < classes.length; i++) {
                        Field[] attributs = classes[i].getDeclaredFields();
                        Object obj = new Object();
                        obj = classes[i].newInstance();
                        for (int j = 0; j < attributs.length; j++) {
                            if((request.getParameter(attributs[j].getName()) != null) || (request.getParameter(attributs[i].getName()) != "")){
                                String valeure = request.getParameter(attributs[j].getName());
                                if(attributs[j].getType() =="int"){
                                    int valeur = Integer.parseInt(valeure);
                                    classes[i].getDeclaredMethod("set".concat(attributs[j].getName()),attributs[j].getType()).invoke(obj, valeur);
                                }
                                if(attributs[j].getType() =="double"){
                                  double  valeur = Double.parseInt(valeure);
                                  classes[i].getDeclaredMethod("set".concat(attributs[j].getName()),attributs[j].getType()).invoke(obj, valeur);
                                }
                                if(attributs[j].getType() =="Date"){
                                   Date  valeur = Date.valueOf(valeure);
                                   classes[i].getDeclaredMethod("set".concat(attributs[j].getName()),attributs[j].getType()).invoke(obj, valeur);
                                }
                                if(attributs[j].getType() =="String"){
                                    classes[i].getDeclaredMethod("set".concat(attributs[j].getName()),attributs[j].getType()).invoke(obj, valeure);
                                }   
                            }
                        
                            classes[i].getDeclaredMethod("Save");
  
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    // TODO: handle exception
                }
               

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
        processRequest(request,response);
        
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        

    }
}
