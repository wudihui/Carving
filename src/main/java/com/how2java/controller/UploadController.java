package com.how2java.controller;

import com.fanchen.util.CookieUtil;
import com.how2java.mapper.CarvingMapper;
import com.how2java.pojo.Carving;
import com.how2java.pojo.Img_url;
import com.how2java.service.TencentYunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

/**
 * Created by Administrator on 2017/8/16.
 */
@Controller
public class UploadController {

    @Autowired
    CarvingMapper carvingMapper;
    @Autowired
    TencentYunService tencentYunService;

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String fileUpload(@RequestParam("file") CommonsMultipartFile file, HttpServletRequest request, HttpServletResponse response, Model model) {

        if (file==null){
            model.addAttribute("info","你没有选择文件...");
            model.addAttribute("button","<a class=\"btn btn-primary btn-outline\" href=\"/main\">返回控制台</a>");
            return "info";
        }
        long startTime = System.currentTimeMillis();
        /**输出上传时的名字含后缀名*/
        String filename = file.getOriginalFilename();
        System.out.println("fileName:" + filename);

        /**在临时存放在本地的地址*/
        String path = "/home/cache/" + filename;
        File newFile = new File(path);
        /**直接把CommonsMultipartFile传入的文件写入到上面设置的路径里*/
        try {
            file.transferTo(newFile);
        } catch (IOException e) {
            model.addAttribute("info", "文件上传到服务器失败,位置UploadController44行");
            model.addAttribute("button","<a class=\"btn btn-primary btn-outline\" href=\"/main\">返回控制台</a>");
            return "info";
        }
        try {
            /**上传缩略图*/
            String SImgId = CookieUtil.getCookieByName(request, "SImgId");
            if (SImgId != null) {
                System.out.println("simgid等于" + SImgId);
                String pth = tencentYunService.upDate(path, filename);
                if (pth != null) {
                    Carving carving = new Carving();
                    carving.setId(Integer.valueOf(SImgId));
                    carving.setHead_img(pth);
                    carvingMapper.update(carving);
                    long endTime = System.currentTimeMillis();
                    model.addAttribute("info", "上传成功...上传缩略图用了:" + String.valueOf(endTime - startTime) + "ms");
                    model.addAttribute("button","<a class=\"btn btn-primary btn-outline\" href=\"/\">返回全部</a>");
                    CookieUtil.deleteCookie(response,"SImgId");
                    return "info";
                } else {
                    carvingMapper.delete(Integer.parseInt(SImgId));
                    model.addAttribute("info", "高清图上传失败");
                    model.addAttribute("button","<a class=\"btn btn-primary btn-outline\" href=\"/\">返回全部</a>");
                    CookieUtil.deleteCookie(response,"SImgId");
                    return "info";
                }
            }

            /**上传高清图*/
            String HImgId = CookieUtil.getCookieByName(request, "HImgId");
            if (HImgId != null) {
                String pth = tencentYunService.upDate(path, filename);
                if (pth != null) {
                    System.out.println("地址..." + pth);
                    Img_url url = new Img_url();
                    url.setImg_id(HImgId);
                    url.setUrl(pth);
                    carvingMapper.addImg(url);
                    long endTime = System.currentTimeMillis();
                    model.addAttribute("info", "上传成功...上传高清图用了:" + String.valueOf(endTime - startTime) + "ms");
                    model.addAttribute("button","<a class=\"btn btn-primary btn-outline\" href=\"/single?id="+HImgId+"\">返回上一页</a>");
                    CookieUtil.deleteCookie(response, "HImgId");
                    return "info";
                } else {
                    model.addAttribute("info", "文件上传失败...请联系管理员...");
                    model.addAttribute("button","<a class=\"btn btn-primary btn-outline\" href=\"/single?id="+HImgId+"\">返回上一页</a>");
                    carvingMapper.delete(Integer.parseInt(HImgId));
                    CookieUtil.deleteCookie(response, "HImgId");
                    return "info";
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("info", "图片上传异常,请联系管理员...");
            model.addAttribute("button","<a class=\"btn btn-primary btn-outline\" href=\"/main\">返回控制台</a>");
            return "info";
        }
        return "info";
    }
}
