package com.bookshop.service;

import com.bookshop.domain.Book;
import com.bookshop.domain.Category;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BookService {


    Integer getUserId(Integer id);

    void add(Book book);

    void update(Book book);

    void delete(Integer id);

    Book get(Integer id);

    Integer getCount();

    List<Book> getList();

    List<Book> getListByBookType(Integer bookType);

    List<Book> getListByCategoryId(@Param("bookType") Integer bookType, @Param("cid") Integer cid);

    List<Book> getListByUserId(Integer uid, Integer bookType);

    /**
     * @return 获取一个Key为Category，Value为对应当前Category的存放Book的List
     */
    Map<Category,List<Book>> getMapByCategory();
}
