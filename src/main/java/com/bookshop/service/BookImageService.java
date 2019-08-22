package com.bookshop.service;


import com.bookshop.domain.BookImage;

public interface BookImageService {

    BookImage getByBookId(Integer bid);

    BookImage get(Integer id);

    void add(BookImage bookImage);

    void update(BookImage bookImage);

    void deleteByBookId(Integer bid);

    void delete(Integer id);
}
