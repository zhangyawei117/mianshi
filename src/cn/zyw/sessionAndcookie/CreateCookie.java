package cn.zyw.sessionAndcookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CreateCookie",urlPatterns = "/CreateCookie")
public class CreateCookie extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, java.io.IOException
    {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, java.io.IOException
    {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        Cookie cookie = new Cookie("name", "Jack");
        response.addCookie(cookie);
    }
}