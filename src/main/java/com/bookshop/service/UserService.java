package com.bookshop.service;

import com.bookshop.domain.User;


public interface UserService {

    User get(Integer id);

    void update(User user);

    User getByStudentid(String studentid);

    // checkPassword()
    int checkUser(User user);
}
