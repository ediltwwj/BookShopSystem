package com.bookshop.service.impl;

import com.bookshop.dao.IBookImageDao;
import com.bookshop.domain.BookImage;
import com.bookshop.service.BookImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("bookImageService")
public class BookImageServiceImpl implements BookImageService {

    @Autowired
    private IBookImageDao iBookImageDao;

    @Override
    public BookImage getByBookId(Integer bid) {
        return iBookImageDao.getByBookId(bid);
    }

    @Override
    public BookImage get(Integer id) {
        return iBookImageDao.get(id);
    }

    @Override
    public void add(BookImage bookImage) {
        iBookImageDao.add(bookImage);
    }

    @Override
    public void update(BookImage bookImage) {
        iBookImageDao.update(bookImage);
    }

    @Override
    public void deleteByBookId(Integer bid) {
        iBookImageDao.deleteByBookId(bid);
    }

    @Override
    public void delete(Integer id) {
        iBookImageDao.delete(id);
    }
}
