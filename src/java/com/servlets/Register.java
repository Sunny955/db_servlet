package com.servlets;

import java.io.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class Register extends HttpServlet{
    
    @Override
    public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
        try {
            res.setContentType("text/html");
            PrintWriter out = res.getWriter();
            
            String name = req.getParameter("userName");
            String password = req.getParameter("userPass");
            String email = req.getParameter("userEmail");
            String country = req.getParameter("userCountry");
            
            System.out.println("Receives all parameters!");
            // Creating connection
            Connection con = ConnectionProvider.getConnection("jdbc");
            
            // Prepared Statement
            PreparedStatement pstmt=con.prepareStatement("insert into registeruser values(?,?,?,?)");
            
            if(pstmt!=null){
                try {
                    pstmt.setString(1, name);
                    pstmt.setString(2, password);
                    pstmt.setString(3, email);
                    pstmt.setString(4, country);
                } catch (SQLException ex) {
                    Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            int i = pstmt.executeUpdate();
            if(i>0) {
                out.print("<h2>Hi, you have successfully registered!</h2>");
            }
            else {
                out.print("Oops! an error occured!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
