package com.how2java.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Administrator on 2017/8/15.
 */
@Controller
public class AboutController {
    @RequestMapping(value = "about", method = RequestMethod.GET)
    public String about() {
        return "about";
    }
}
