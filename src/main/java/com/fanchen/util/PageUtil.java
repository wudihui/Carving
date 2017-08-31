package com.fanchen.util;

import com.how2java.mapper.CarvingMapper;
import com.how2java.pojo.Carving;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Administrator on 2017/8/14.
 */
public class PageUtil {

    public static void get(String search, Carving carving, CarvingMapper carvingMapper, ModelAndView mav) {
        if (search != null) {
            carving.setName(search);
            List<Carving> cs = carvingMapper.search(carving);
            mav.addObject("cs", cs);
            mav.setViewName("page");
        } else {
            List<Carving> cs = carvingMapper.list(carving);
            mav.addObject("cs", cs);
            mav.setViewName("page");
        }
    }
}
