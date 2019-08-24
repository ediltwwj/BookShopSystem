package com.bookshop.controller;

import com.bookshop.domain.Book;
import com.bookshop.domain.Category;
import com.bookshop.domain.Page;
import com.bookshop.domain.User;
import com.bookshop.service.BookService;
import com.bookshop.service.CategoryService;;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
public class ForeController {

    @Autowired
    private BookService bookService;

    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/home.do")
    public ModelAndView goHome(){

        ModelAndView mav = new ModelAndView("home");
        Map<Integer, String> categpries = categoryService.getListByMap();
        Map<Category, List<Book>> booksMap = bookService.getMapByCategory();
        mav.addObject("categories", categpries);
        mav.addObject("booksMap", booksMap);

        return mav;
    }

    @RequestMapping("/myBookshelf.do")
    public ModelAndView goMyBookshelf(HttpServletRequest request){

        ModelAndView mav = new ModelAndView("myBookshelf");
        User user = (User) request.getSession().getAttribute("user");
        List<Book> books = bookService.getListByUserId(user.getId(), 1);
        List<Book> askBooks = bookService.getListByUserId(user.getId(), 0);
        mav.addObject("books", books);
        mav.addObject("askBooks", askBooks);

        return mav;
    }

    @RequestMapping("/goUpload.do")
    public ModelAndView upload(Book book){

        String path = book.getBookType()==1?"uploadSell":"uploadAsk";
        ModelAndView mav = new ModelAndView(path);
        Map<Integer,String> categories = categoryService.getListByMap();
        mav.addObject("categories",categories);

        return mav;
    }

    @RequestMapping("/goBookStore.do")
    public ModelAndView goBookStore(Page page, Category category){

        ModelAndView mav = new ModelAndView("bookStore");
        Map<Integer, String> categories = categoryService.getListByMap();

//        System.out.println("NULL TEST" + category);
//
//        int categoryId = category.getId();
//        Category curCategory = categoryId !=0?categoryService.get(categoryId):new Category();
        // 空指针是因为category的id没有值， 在实体类给个初值就可以解决，同时三目运算符注意自动拆箱引起空指针异常
        Category curCategory = category.getId() !=0?categoryService.get(category.getId()):new Category();
        System.out.println(curCategory);
        String categoryName = curCategory.getName() == null?"所有二手书":curCategory.getName();
        Integer total = bookService.getCount();
        page.calculateEnd(total);
        if (page.getStart() < 0) {
            page.setStart(0);
        }else if (page.getStart() > total){
            page.setEnd(page.getEnd());
        }
        PageHelper.offsetPage(page.getStart(),16);

        // PageHelper.startPage(pageNum, pageSize);这段代码表示，程序开始分页了，
        // pageNum默认值是1，pageSize默认是10，意思是从第1页开始，每页显示10条记录。
//        PageHelper.startPage(1, 10);

        List<Book> books = curCategory.getId() == 0?bookService.getListByBookType(1):bookService.getListByCategoryId(1,curCategory.getId());
//        System.out.println(books);
//        // 得到分页的结果对象
//        PageInfo<Book> p = new PageInfo<>(books);


        mav.addObject("books", books);
        mav.addObject("categoryName",categoryName);
        mav.addObject("categories",categories);

        return mav;
    }

    @RequestMapping("/goAskBookStore.do")
    public ModelAndView goAskBookStore(Page page){

        ModelAndView mav = new ModelAndView("askBookStore");
        Integer total = bookService.getCount();
        page.calculateEnd(total);
        if (page.getStart() < 0) {
            page.setStart(0);
        }else if (page.getStart() > total){
            page.setEnd(page.getEnd());
        }
        PageHelper.offsetPage(page.getStart(),16);

        // PageHelper.startPage(pageNum, pageSize);这段代码表示，程序开始分页了，
        // pageNum默认值是1，pageSize默认是10，意思是从第1页开始，每页显示10条记录。
//        PageHelper.startPage(1, 10);

        List<Book> books = bookService.getListByBookType(0);
        // 得到分页的结果对象
//        PageInfo<Book> p = new PageInfo<>(books);


        mav.addObject("books",books);

        return mav;
    }
}
