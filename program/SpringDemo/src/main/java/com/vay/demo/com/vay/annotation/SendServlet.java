package com.vay.demo.com.vay.annotation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author qiaozhe
 */
@WebServlet(name="SendServlet", urlPatterns="/SendServlet")
public class SendServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("sendServlet");
        req.setAttribute("attr", "attr");
        req.getRequestDispatcher("/testAttr").forward(req,resp);
    }
}
