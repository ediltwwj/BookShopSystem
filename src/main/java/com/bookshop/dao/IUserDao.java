package com.bookshop.dao;

import com.bookshop.domain.User;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;


@Repository
public interface IUserDao {

    // 获取id用户信息
    @Select("select * from user where id=#{id}")
    User get(Integer id);

    // 更新用户信息
    @Update("update user set name=#{name} where id=#{id}")
    void update(User user);

    // 核对密码,正确情况，查询条数为1
    @Select("select count(*) from user where studentid = #{studentid} and password = #{password}")
    int checkPassword(User user);

    // 根据学生id获取用户信息
    @Select("select * from user where studentid= #{studentid}")
    User getByStudentid(String studentid);
}
