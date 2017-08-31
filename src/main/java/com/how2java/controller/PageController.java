package com.how2java.controller;

import com.fanchen.util.CookieUtil;
import com.fanchen.util.PageUtil;
import com.how2java.mapper.CarvingMapper;
import com.how2java.pojo.Carving;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Created by Administrator on 2017/8/14.
 */
@Controller
public class PageController {

    @Autowired
    CarvingMapper carvingMapper;

    /**
     * 下一页
     */
    @RequestMapping(value = "portfolio/page_next")
    public ModelAndView page_next(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        ModelAndView mav = new ModelAndView();
        Carving carving = new Carving();
        String oldpage = CookieUtil.getCookieByName(request, "start");
        String cokSearch = CookieUtil.getCookieByName(request, "search");
        /**一公152 3*10=120 */
        if (oldpage != null) {
            Integer i = carvingMapper.sum();
            /**判断是否还有下一页*/
            if ((Integer.parseInt(oldpage) + 40) >= i) {
                Integer sum = i - i % 40;
                CookieUtil.addCookie(response, "start", String.valueOf(sum));
                carving.setStart(sum);
                PageUtil.get(cokSearch, carving, carvingMapper, mav);
            } else {
                int sum = Integer.parseInt(oldpage) + 40;
                String start = String.valueOf(i);
                CookieUtil.addCookie(response, "start", start);
                carving.setStart(sum);
                PageUtil.get(cokSearch, carving, carvingMapper, mav);
            }

        } else {
            String s = "40";
            CookieUtil.addCookie(response, "start", s);
            carving.setStart(40);
            List<Carving> cs = carvingMapper.list(carving);
            mav.addObject("cs", cs);
            mav.setViewName("page");
        }
        return mav;

    }

    /**
     * 上一页
     */

    @RequestMapping(value = "portfolio/page_last")
    public ModelAndView page_last(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        Carving carving = new Carving();
        ModelAndView mav = new ModelAndView();
        String oldpage = CookieUtil.getCookieByName(request, "start");
        String cokSearch = CookieUtil.getCookieByName(request, "search");
        if (oldpage != null) {
            if (Integer.parseInt(oldpage) <= 0) {
                CookieUtil.addCookie(response, "start", "0");
                carving.setStart(0);
            } else {
                String start = String.valueOf(Integer.parseInt(oldpage) - 40);
                CookieUtil.addCookie(response, "start", start);
                carving.setStart(Integer.parseInt(start));
            }
            /**判断是否存在Search*/
            PageUtil.get(cokSearch, carving, carvingMapper, mav);
        } else {
            CookieUtil.addCookie(response, "start", "0");
            carving.setStart(0);
            List<Carving> cs = carvingMapper.list(carving);
            mav.addObject("cs", cs);
            mav.setViewName("page");
        }
        return mav;
    }
}
