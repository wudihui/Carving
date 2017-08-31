package com.how2java.mapper;

import com.how2java.pojo.Carving;
import com.how2java.pojo.Img_url;

import java.util.List;

/**
 * Created by Administrator on 2017/8/12.
 */
public interface CarvingMapper {

    List<Carving> list(Carving carving);

    List<Carving> search(Carving carving);

    List<Img_url> getUrl(Carving carving);

    Carving get(int id);

    int add(Carving carving);

    boolean addImg(Img_url img_url);

    boolean delete(int id);

    boolean update(Carving carving);

    int sum();
}
