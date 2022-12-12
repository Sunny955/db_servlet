package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.http.*;

public class ServletExp extends HttpServlet {

    /**
     *
     * @param req
     * @param res
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
        System.out.println("This is get method");
        res.setContentType("text/html");
        PrintWriter p = res.getWriter();
        p.print("<h1>This is get method of servlet!</h1>");
    }
 }
