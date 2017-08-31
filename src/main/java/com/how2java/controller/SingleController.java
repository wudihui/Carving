package com.how2java.controller;

import com.fanchen.util.CookieUtil;
import com.how2java.mapper.CarvingMapper;
import com.how2java.pojo.Carving;
import com.how2java.pojo.Img_url;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by Administrator on 2017/8/14.
 */
@Controller
public class SingleController {

    @Autowired
    CarvingMapper carvingMapper;

    @RequestMapping(value = "/single", method = RequestMethod.GET)
    public ModelAndView single(@RequestParam String id, HttpServletRequest request, HttpServletResponse response, Model model) {
        ModelAndView mav = new ModelAndView();
        String username = CookieUtil.getCookieByName(request, "username");
        String password = CookieUtil.getCookieByName(request, "password");
        if (username!=null&&password!=null&&username.equals("root") && password.equals("112233")) {
            CookieUtil.addCookie(response, "HImgId", id);
            model.addAttribute("insButton", "<a href=\"/addhigh\" class=\"btn btn-primary btn-outline\">插入图片</a>");
            model.addAttribute("delButton","<a href=\"/delete?id="+id+"\" class=\"btn btn-primary btn-outline\">删除模板</a>");
            model.addAttribute("retButton", "<a href=\"/portfolio\" class=\"btn btn-primary btn-outline\">返回</a>");
        } else {
            model.addAttribute("retButton", "<a href=\"/portfolio\" class=\"btn btn-primary btn-outline\">返回</a>");
        }
        Carving carving = carvingMapper.get(Integer.parseInt(id));
        model.addAttribute("id", carving.getId());
        model.addAttribute("name", carving.getName());
        model.addAttribute("detailed", carving.getDetailed());
        List<Img_url> img_urls = carvingMapper.getUrl(carving);
        mav.addObject("cs", img_urls);
        mav.setViewName("single");
        return mav;
    }
}
