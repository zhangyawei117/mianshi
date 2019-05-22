package cn.zyw.sessionAndcookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "GetLastVisitTime", urlPatterns = "/GetLastVisitTime")
public class GetLastVisitTime extends HttpServlet
{
    protected void doPost(HttpServletRequest request,
        HttpServletResponse response)
        throws ServletException, IOException
    {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        Cookie cookie = CookieUtil.getCookieByName(request.getCookies(), "lastVisitTime");
        if (cookie == null)
        {
            response.getWriter().write("<h1 style='color:green'>大爷你是第一次来吧!</h1>");
        }
        else
        {
            response.getWriter().write("<h1 style='color:red'>欢迎再次光临，您上次访问时间是："+cookie.getValue()+"!</h1>");
        }
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String visitTime = simpleDateFormat.format(date);
        Cookie cookie1 = new Cookie("lastVisitTime", visitTime);
        cookie1.setMaxAge(60*60*24*7);
        response.addCookie(cookie1);
    }
}
