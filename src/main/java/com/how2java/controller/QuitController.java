package com.how2java.controller;

import com.fanchen.util.CookieUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2017/8/31.
 */
@Controller
public class QuitController {
    @RequestMapping(value = "quit",method = RequestMethod.POST)
    public String quit(HttpServletResponse response,Model model){
        CookieUtil.deleteCookie(response,"username");
        CookieUtil.deleteCookie(response,"password");
        model.addAttribute("info","你已经成功注销...");
        model.addAttribute("button","<a class=\"btn btn-primary btn-outline\" href=\"/\">点击返回控制台</a>");
        return "info";
    }
}
