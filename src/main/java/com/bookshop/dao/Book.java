package com.bookshop.dao;

import java.io.Serializable;

/**
 * 图书实体类-book表
 */
public class Book implements Serializable {

    private Integer id;
    private String name;
    private Category category;  // 外键book(cid) <-> category(id)
    private Integer bookType;
    private Double price;
    private Double originalPrice;
    private User user;  // 外键book(uid) <-> user(id)
    private String author;
    private String press;
    private String version;
    private Double degree;
    private String publishDate;
    private String description;
    private String date;
    private BookImage bookImage;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Integer getBookType() {
        return bookType;
    }

    public void setBookType(Integer bookType) {
        this.bookType = bookType;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(Double originalPrice) {
        this.originalPrice = originalPrice;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Double getDegree() {
        return degree;
    }

    public void setDegree(Double degree) {
        this.degree = degree;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public BookImage getBookImage() {
        return bookImage;
    }

    public void setBookImage(BookImage bookImage) {
        this.bookImage = bookImage;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category=" + category +
                ", bookType=" + bookType +
                ", price=" + price +
                ", originalPrice=" + originalPrice +
                ", user=" + user +
                ", author='" + author + '\'' +
                ", press='" + press + '\'' +
                ", version='" + version + '\'' +
                ", degree=" + degree +
                ", publishDate='" + publishDate + '\'' +
                ", description='" + description + '\'' +
                ", date='" + date + '\'' +
                ", bookImage=" + bookImage +
                '}';
    }
}
