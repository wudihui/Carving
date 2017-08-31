package com.how2java.service;

import com.how2java.pojo.Carving;

import java.util.List;

/**
 * Created by Administrator on 2017/8/12.
 */
public interface CarvingService {

    List<Carving> list();

    List<Carving> get(String name);

    boolean add(Carving carving);

    boolean delete(Carving carving);

    boolean update(Carving carving);
}
