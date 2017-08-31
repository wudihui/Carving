package com.how2java.controller;

import com.fanchen.util.CookieUtil;
import com.how2java.mapper.CarvingMapper;
import com.how2java.pojo.Carving;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Created by Administrator on 2017/8/14.
 */
@Controller
public class SearchController {

    @Autowired
    private CarvingMapper carvingMapper;

    @RequestMapping(value = "search", method = RequestMethod.GET)
    public ModelAndView get(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        ModelAndView mav = new ModelAndView();
        String s = request.getParameter("name");
        String name = "%" + s + "%";

        if (name.equals("%%")){
            mav.addObject("info", "请输入关键字");
            mav.setViewName("portfolio");
            return mav;
        }
        if (s != null) {

            CookieUtil.addCookie(response, "search", name);
            Carving carving = new Carving();
            carving.setName(name);
            List<Carving> cs = carvingMapper.search(carving);
            if (cs.size()==0){
                mav.addObject("info",name+"对不起没找到");
                mav.setViewName("portfolio");
                return mav;
            }
            mav.addObject("cs", cs);
            mav.setViewName("portfolio");
            return mav;
        }
        return mav;
    }

}
