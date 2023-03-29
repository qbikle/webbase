package com.mvg.baseweb;

import java.io.*;
import java.sql.SQLException;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String confirm;
    private String denied;
    public void init() {
        confirm = "Data Entered Successfully!";
        denied = "There was an error submitting data, please try again!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        String subject = request.getParameter("subject");
        String ccode = request.getParameter("ccode");
        String cname = request.getParameter("cname");
        String rating = request.getParameter("review");
        PrintWriter out = response.getWriter();
        String q = "INSERT INTO `webbase`.`review_table` (`Subject`, `Course_code`, `Coordinator_name`, `Review`) VALUES " +
                "('" + subject + "', '"+ ccode +"', '"+ cname +"', '"+ rating +"');\n";
        try {if (DBConnector.DBConnectAndUpdate(q)){
            out.println("<html><body>");
            out.println("<h1>" + confirm + "</h1>");
            out.println("</body></html>");
            out.close();
        }else {
            out.println("<html><body>");
            out.println("<h1>" + denied + "</h1>");
            out.println("</body></html>");
            out.close();
        }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void destroy() {
    }
}