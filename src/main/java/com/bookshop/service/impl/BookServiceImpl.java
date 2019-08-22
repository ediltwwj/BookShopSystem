package com.bookshop.service.impl;


import com.bookshop.dao.IBookDao;
import com.bookshop.dao.IBookImageDao;
import com.bookshop.dao.ICategoryDao;
import com.bookshop.domain.Book;
import com.bookshop.domain.Category;
import com.bookshop.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service("bookService")
public class BookServiceImpl implements BookService {

    @Autowired
    private IBookDao bookDao;

    @Autowired
    private IBookImageDao bookImageDao;

    @Autowired
    private ICategoryDao categoryDao;

    @Override
    public Integer getUserId(Integer id) {
        return bookDao.getUserId(id);
    }

    @Override
    public void add(Book book) {
        bookDao.add(book);
    }

    @Override
    public void update(Book book) {
        bookDao.update(book);
    }

    @Override
    public void delete(Integer id) {
        bookDao.delete(id);
    }

    @Override
    public Book get(Integer id) {
        Book book = bookDao.get(id);
        book.setBookImage(bookImageDao.getByBookId(id));
        return bookDao.get(id);
    }

    @Override
    public Integer getCount() {
        return bookDao.getCount();
    }

    @Override
    public List<Book> getList() {
        List<Book> books = bookDao.getList();
        for(Book book : books){
            book.setBookImage(bookImageDao.getByBookId(book.getId()));
        }
        return books;
    }

    @Override
    public List<Book> getListByBookType(Integer bookType) {
        List<Book> books = bookDao.getListByBookType(bookType);
        for(Book book : books){
            book.setBookImage(bookImageDao.getByBookId(book.getId()));
        }
        return books;
    }

    @Override
    public List<Book> getListByCategoryId(Integer bookType, Integer cid) {
        List<Book> books = bookDao.getListByCategoryId(-1, -1, bookType, cid);
        for(Book book : books){
            book.setBookImage(bookImageDao.getByBookId(book.getId()));
        }
        return books;
    }

    @Override
    public List<Book> getListByUserId(Integer uid, Integer bookType) {
        List<Book> books = bookDao.getListByUserId(uid, bookType);
        for(Book book : books){
            book.setBookImage(bookImageDao.getByBookId(book.getId()));
        }
        return books;
    }

    /**
     * @return 获取一个Key为Category，Value为对应当前Category的存放Book的List
     */
    @Override
    public Map<Category, List<Book>> getMapByCategory() {
        List<Category> categories = categoryDao.getList();
        // 使用LinkedHashMap存储，若使用HashMap则无序
        Map<Category,List<Book>> booksMap = new LinkedHashMap<>();
        for(Category category : categories){
            List<Book> books = bookDao.getListByCategoryId(0, 5, 1,category.getId());
            if (books.size() > 0) {
                // 当前的Book对象无BookImage，遍历每个Book对象并放入相应的BookImage
                for (Book book : books) {
                    book.setBookImage(bookImageDao.getByBookId(book.getId()));
                }
            }
            booksMap.put(category,books);
        }
        return booksMap;
    }
}
