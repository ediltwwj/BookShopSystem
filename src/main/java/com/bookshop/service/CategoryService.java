package com.bookshop.service;


import com.bookshop.domain.Category;

import java.util.List;
import java.util.Map;

public interface CategoryService {

    void add(Category category);

    void delete(Integer id);

    Category get(Integer id);

    void update(Category category);

    List<Category> getList();

    Integer getCount();

    // 获取一个Key为CategoryId，Value为CategoryName的Map
    Map<Integer,String> getListByMap();
}
