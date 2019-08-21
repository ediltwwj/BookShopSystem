package com.bookshop.dao;

import com.bookshop.domain.BookImage;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface IBookImageDao {

    // 获取图书封面
    @Select("select * from bookimage where bid=#{bid}")
    BookImage getByBookId(Integer bid);

    @Select("select * from bookimage where id= #{id}")
    BookImage get(Integer id);

    // 添加图书封面
    @Insert("insert into bookimage ( bid ) values (#{book.id})")
    void add(BookImage bookImage);

    // 更新图书封面
    @Update("update bookimage set bid=#{book.id} where id=#{id}")
    void update(BookImage bookImage);

    // 删除图书封面
    @Update("delete from bookimage where bid= #{bid}")
    void deleteByBookId(Integer bid);

    @Update("delete from bookimage where id= #{id}")
    void delete(Integer id);
}
