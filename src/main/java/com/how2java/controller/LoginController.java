package com.how2java.controller;

import com.fanchen.util.CookieUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

/**
 * Created by Administrator on 2017/8/17.
 */
@Controller
public class LoginController {
    @RequestMapping("/login")
    public String goLogin() {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(HttpServletRequest request, HttpServletResponse response, Model model) {
        try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (username != null && password != null && username.equals("root") && password.equals("112233")) {
            CookieUtil.addCookie(response, "username", "root");
            CookieUtil.addCookie(response, "password", "112233");
            model.addAttribute("info", "登录成功");
            model.addAttribute("button"," <a class=\"btn btn-primary btn-outline\" href=\"/main\">点击返回控制台</a>");
            return "info";
        } else {
            model.addAttribute("info", "用户名或密码不正确");
            model.addAttribute("button"," <a class=\"btn btn-primary btn-outline\" href=\"/main\">点击返回</a>");
            return "info";
        }
    }
}
