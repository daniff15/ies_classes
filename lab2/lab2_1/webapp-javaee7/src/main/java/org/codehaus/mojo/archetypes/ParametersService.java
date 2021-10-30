package org.codehaus.mojo.archetypes;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "parametersService", urlPatterns = { "/parametersService" })
public class ParametersService extends HttpServlet {

    private static final long serialVersionUID = -1915463532411657451L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, NullPointerException {

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

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException, NullPointerException {
        doGet(request, response);
    }
}