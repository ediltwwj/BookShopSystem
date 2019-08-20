package com.bookshop.dao;

import java.io.Serializable;

/**
 * 图书封面图片实体类-bookimage表
 */
public class BookImage implements Serializable {

    private Integer id;
    private Book book;  // 外键bookimage(bid) <-> book(id)
    private Integer type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
