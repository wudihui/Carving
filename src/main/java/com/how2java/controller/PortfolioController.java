package com.how2java.controller;

import com.fanchen.util.CookieUtil;
import com.how2java.mapper.CarvingMapper;
import com.how2java.pojo.Carving;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by Administrator on 2017/8/14.
 */
@Controller
public class PortfolioController {

    @Autowired
    CarvingMapper carvingMapper;

    @RequestMapping(value = "/portfolio", method = RequestMethod.GET)
    public ModelAndView portfolio(HttpServletResponse response) {
        ModelAndView mav = new ModelAndView();
        CookieUtil.addCookie(response, "start", "0");
        Carving stend = new Carving();
        stend.setStart(0);
        List<Carving> cs = carvingMapper.list(stend);
        mav.addObject("cs", cs);
        mav.setViewName("portfolio");//返回的路径
        return mav;
    }
}
