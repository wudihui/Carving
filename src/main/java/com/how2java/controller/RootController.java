package com.how2java.controller;


import com.fanchen.util.CookieUtil;
import com.how2java.mapper.CarvingMapper;
import com.how2java.pojo.Carving;
import com.how2java.pojo.Img_url;
import com.how2java.service.TencentYunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Controller
public class RootController {
    @Autowired
    CarvingMapper carvingMapper;
    @Autowired
    TencentYunService tencentYunService;

    //main
    @RequestMapping("/main")
    public String main() {
        return "main";
    }

    //  添加
    @RequestMapping("/add_doc")
    public String add_doc() {
        return "add_doc";
    }

    @RequestMapping("/addsmall")
    public String add_img(Carving carving, Model model, HttpServletResponse response) {
        if (!carving.getName().equals("")) {
            carvingMapper.add(carving);
            /**添加缩略图id到Cookie*/
            CookieUtil.addCookie(response, "SImgId", String.valueOf(carving.getId()));
            model.addAttribute("info", "插入模板成功,添加一张缩略图吧");
            model.addAttribute("button"," <a class=\"btn btn-primary btn-outline\" href=\"/single?id="+carving.getId()+"\">跳转到该模板</a>");
            return "add_img";
        } else {
            model.addAttribute("info", "插入失败,请补全所需的数据");
            model.addAttribute("button"," <a class=\"btn btn-primary btn-outline\" href=\"/add_doc\">返回上一页</a>");
            return "info";
        }
        /**把插入的数据id放到Cookie里*/
    }

    /**
     * 直接插入图片
     */
    @RequestMapping("/addhigh")
    public String addHigh(HttpServletRequest request, Model model) {
        String HImgId = CookieUtil.getCookieByName(request, "HImgId");
        if (HImgId != null) {
            model.addAttribute("info", "该模板的id为" + HImgId);
            model.addAttribute("button","<a class=\"btn btn-primary btn-outline\" href=\"/\">返回控制台</a>");
            return "add_img";
        } else {
            model.addAttribute("info", "出错了,获取不到待插入模板的id");
            model.addAttribute("button","<a class=\"btn btn-primary btn-outline\" href=\"/add_doc\">去插入模板</a>");
            return "info";
        }
    }

    /**
     * 删除
     */
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(int id, Model model) {
        if (id<=0){
            model.addAttribute("info","获取不到id或者id不存在");
            model.addAttribute("button","<a class=\"btn btn-primary btn-outline\" href=\"/\">返回全部</a>");
            return "info";
        }
        Pattern p = Pattern.compile("(/\\d{13}.*)");

        Carving c = carvingMapper.get(id);
        /**判断id是否存在*/
        if (c==null){
            model.addAttribute("info","id不存在");
            model.addAttribute("button","<a class=\"btn btn-primary btn-outline\" href=\"/\">返回全部</a>");
            return "info";
        }
        /**删除small图*/
        if (c.getHead_img()!=null){
            Matcher mc = p.matcher(c.getHead_img());
            if (mc.find()) {
                tencentYunService.deleteFile(mc.group(1));
            }
        }

        /**删除高清图*/
        Carving carving = new Carving();
        carving.setId(id);
        List<Img_url> imgUrls = carvingMapper.getUrl(carving);
        if (imgUrls!=null){
            for (Img_url im : imgUrls) {
                System.out.println("删除了这个图片" + im.toString());
                Matcher m = p.matcher(im.getUrl());
                if (m.find()) {
                    tencentYunService.deleteFile(m.group(1));
                }
            }
        }

        /**删除数据库数据*/
        if (carvingMapper.delete(id)) {
            model.addAttribute("info", "操作成功");
            model.addAttribute("button","<a class=\"btn btn-primary btn-outline\" href=\"/\">返回全部</a>");
        } else {
            model.addAttribute("info", "操作失败,因为该id不存在");
            model.addAttribute("button","<a class=\"btn btn-primary btn-outline\" href=\"/\">返回全部</a>");
        }
        return "info";
    }
}
