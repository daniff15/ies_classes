package org.codehaus.mojo.archetypes;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.ServletHandler;

@WebServlet(name = "embeddedServer", urlPatterns = { "/embeddedServer" })
public class EmbeddedServer {

    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);       
         
        ServletHandler servletHandler = new ServletHandler();
        server.setHandler(servletHandler);
                 
        servletHandler.addServletWithMapping(ParamService.class, "/");
         
        server.start();
        server.join();
    }


    public class ParamService extends HttpServlet{
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {

            response.setContentType("text/html");
            PrintWriter out = response.getWriter();

            out.println("<html>");
            out.println("<head>");
            out.println("<title>Request Parameters Example</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h3>Request Parameters Example</h3>");
            out.println("Parameters passed in url!<br>");

            String firstName = null;
            String lastName = null;

            try {
                firstName = request.getParameter("firstname");
                lastName = request.getParameter("lastname");
            } catch (NullPointerException e) {
                out.println(e.getStackTrace());
            }

            out.println("<h4>Hello user:" + firstName + " " + lastName + " </h4>");
        
        }
    }
    
}