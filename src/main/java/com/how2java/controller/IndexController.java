package com.how2java.controller;

import com.how2java.mapper.CarvingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Administrator on 2017/8/14.
 */
@Controller
public class IndexController {
    @Autowired
    CarvingMapper carvingMapper;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("sum",carvingMapper.sum());
        return "index";
    }
}
