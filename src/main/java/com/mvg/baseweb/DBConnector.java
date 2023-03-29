package com.mvg.baseweb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnector {
    public static boolean DBConnectAndUpdate(String query) throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://localhost:3306/webbase";
        String username = "root";
        String password = "Iqlwcegr@21";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, username, password);
        System.out.println("Connection Established successfully");
        Statement st = con.createStatement();
        st.executeUpdate(query);
        st.close();
        con.close();
        System.out.println("Connection Closed...");
        return true;
    }
}
