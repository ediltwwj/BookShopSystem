package com.bookshop.service.impl;


import com.bookshop.dao.ICategoryDao;
import com.bookshop.domain.Category;
import com.bookshop.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private ICategoryDao categoryDao;

    @Override
    public void add(Category category) {
        categoryDao.add(category);
    }

    @Override
    public void delete(Integer id) {
        categoryDao.delete(id);
    }

    @Override
    public Category get(Integer id) {
        return categoryDao.get(id);
    }

    @Override
    public void update(Category category) {
        categoryDao.update(category);
    }

    @Override
    public List<Category> getList() {
        return null;
    }

    @Override
    public Integer getCount() {
        return categoryDao.getCount();
    }

    @Override
    public Map<Integer, String> getListByMap() {

        List<Category> categories = categoryDao.getList();
        Map<Integer, String> categoriesMap = new HashMap<>();
        for (Category category : categories) {
            categoriesMap.put(category.getId(),category.getName());
        }
        return categoriesMap;
    }

}
