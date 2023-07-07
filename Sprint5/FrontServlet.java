package etu1835.framework.servlet;
import java.sql.SQLException;
import java.io.*;
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
                    String path= u.getPath(request); //Premiere methode
                    System.out.println(path);
                    String meth = u.getMethode(request); // Deuxieme methode  
                    System.out.println(meth);
                    out.println(path);
                    out.println(meth);
                    String paths = "C:/Program Files/Apache Software Foundation/Tomcat 10.1/Script1/WEB-INF/classes/etu1835/framework/modele";
                    
                    mappingUrls= u.getHashmap( mappingUrls, paths);
                    u.printHM(mappingUrls);
                    Mapping map = u.geMap(mappingUrls, meth);
                    out.println( "Key : "+meth );
                    out.println( map.getClassName() + " | " + map.getMethod());
                    ModeleView view= u.get_View(meth, mappingUrls);
                    String page = view.getView();
                    RequestDispatcher disp = request.getRequestDispatcher(page);
                    disp.forward(request, response);
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
