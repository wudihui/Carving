package com.how2java.test;


import com.how2java.mapper.CarvingMapper;
import com.how2java.pojo.Carving;
import com.how2java.pojo.Img_url;
import com.how2java.service.TencentYunService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class MybatisTest {

    @Autowired
    CarvingMapper carvingMapper;

    @Autowired
    TencentYunService tencentYunService;

    @Test
    public void add() {
        Carving carving = new Carving();
        carving.setName("草泥马");
        carving.setDetailed("傻袍子");
        carvingMapper.add(carving);
        System.out.println(carving.getId());
    }

    @Test
    public void search() {
        String name = "%张三%";
        Carving carving = new Carving();
        carving.setName(name);
        List<Carving> list = carvingMapper.search(carving);
        for (Carving car : list
                ) {
            System.out.println(car.toString());
        }
    }

    @Test
    public void more() {
        Carving carving = new Carving();
        carving.setStart(0);
        List<Carving> list = carvingMapper.list(carving);
        for (Carving car : list
                ) {
            System.out.println(car.toString());
        }
    }

    @Test
    public void sum() {
        System.out.println(carvingMapper.sum());
    }

    @Test
    public void get() {
        int i = 10;
        System.out.println(carvingMapper.get(i).toString());
    }

    @Test
    public void getUrl() {
        Carving c = new Carving();
        c.setId(1);
        for (Img_url img : carvingMapper.getUrl(c)
                ) {
            System.out.println(img.getUrl());
        }
    }

    @Test
    public void deleteFile() {
        System.out.println(tencentYunService.deleteFile("1502896489091.jpg"));
    }


}
