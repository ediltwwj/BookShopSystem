package com.bookshop.service.impl;


import com.bookshop.dao.IUserDao;
import com.bookshop.domain.User;
import com.bookshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private IUserDao userDao;

    @Override
    public User get(Integer id) {
        return userDao.get(id);
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    public User getByStudentid(String studentid) {
        return userDao.getByStudentid(studentid);
    }

    @Override
    public int checkUser(User user) {

        int flag = userDao.checkPassword(user);

        if(flag==1)
            return 1;

        return 0;
    }
}
