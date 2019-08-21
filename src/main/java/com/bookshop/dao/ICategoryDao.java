package com.bookshop.dao;

import com.bookshop.domain.Category;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICategoryDao {

    // 添加图书类别
    @Insert("insert into category (name) values (#{name})")
    void add(Category category);

    // 删除图书类别
    @Update("delete from category where id= #{id}")
    void delete(Integer id);

    // 获得单个图书类别
    @Select("select * from category where id = #{id}")
    Category get(Integer id);

    // 更新图书类别
    @Update("update category set name=#{name} where id=#{id}")
    void update(Category category);

    // 获取所有Category
    @Select("select * from category")
    List<Category> list();

    // 获取类别总数
    @Select("select count(id) from category")
    Integer count();
}
