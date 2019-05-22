package cn.zyw.sessionAndcookie;

import javax.servlet.http.Cookie;

/**
 * @ClassName: CookieUtil
 * @description:
 * @author: ZhangYawei
 * @Date: 2019/5/14 23:36
 **/
public class CookieUtil
{

    public static Cookie getCookieByName(Cookie[] cookies, String lastVisitTime)
    {
        if (cookies!=null)
        {
            for (Cookie cookie : cookies)
            {
                if (cookie!=null)
                {
                    if (lastVisitTime.equals(cookie.getName()))
                    {
                        return cookie;
                    }
                }
            }
        }
        return null;
    }
}
