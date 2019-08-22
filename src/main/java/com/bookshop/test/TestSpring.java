package com.bookshop.test;


import com.bookshop.domain.Book;
import com.bookshop.domain.Category;
import com.bookshop.domain.User;
import com.bookshop.service.BookService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Map;

public class TestSpring {

    @Test
    public void run1(){

        // 加载spring的配置文件
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        // 获取对象
        BookService bk = ac.getBean("bookService", BookService.class);
        // 调用方法
        Map<Category, List<Book>> maps = bk.getMapByCategory();

        for (Map.Entry<Category, List<Book>> entry : maps.entrySet()) {
            System.out.println(entry.getKey());
            for(Book book : entry.getValue()){
                System.out.println(book);
            }
            System.out.println();
        }
//        Book book = bk.get(1);
//        System.out.println(book);
//        List<Book> books = bk.getListByCategoryId(1, 7);
//        List<Book> books = bk.getListByBookType(1);
//
//        for(Book book: books){
//            System.out.println(book);
//        }


    }
}
