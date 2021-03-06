package com.bookshop.dao;

import com.bookshop.domain.Book;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

// 针对一对一，注解写法太过于复杂，因此采用xml方式实现注入
// 要使用一对一，一对多，感觉没有XML清晰好写
@Repository
public interface IBookDao {

    /**
     * 根据查询条件获取相应书本的List
     * @param start 起始图书ID
     * @param count 需要的书的总数
     * @param bookType 书的类型（图书信息1/求书信息0）
     * @param cid CategoryId
     * @return 符合条件的List
     */
    List<Book> getListByCategoryId(@Param("start") Integer start, @Param("count") Integer count,
                                            @Param("bookType") Integer bookType, @Param("cid") Integer cid);

    /**
     * 根据图书Id获取上传者Id
     * @param id 图书Id
     * @return 上传者Id
     */
    Integer getUserId(Integer id);

    // 添加图书
    void add(Book book);

    // 更新图书
    void update(Book book);

    // 计算图书的总数
    Integer getCount();

    // 删除图书
    void delete(Integer id);

    // 获取图书
    Book get(Integer id);

    // 获取所有图书并放入List
    List<Book> getList();

    // 根据书的类型（图书信息1/求书信息0）获取所有图书
    List<Book> getListByBookType(Integer bookType);

    /**
     * 根据条件获取所有图书
     * @param uid 用户Id
     * @param bookType 书的类型（图书信息1/求书信息0）
     * @return 相应的List
     */
    List<Book> getListByUserId(@Param("uid") Integer uid, @Param("bookType") Integer bookType);
}
