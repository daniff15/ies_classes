package org.codehaus.mojo.archetypes;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "parameters", urlPatterns = { "/parameters" })
public class ParametersService extends HttpServlet {

    private static final long serialVersionUID = -1915463532411657451L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String username = request.getParameter("username");

        if (username == null) {
            throw new NullPointerException("There isn't a usernane!");
        } else {
            try {
                // Write some content
                out.println("<html>");
                out.println("<head>");
                out.println("<title>CalendarServlet</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h2>Hello " + username + "</h2>");
                out.println("<h2>The time right now is : " + new Date() + "</h2>");
                out.println("</body>");
                out.println("</html>");
            } finally {
                out.close();
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Do some other work
    }
}