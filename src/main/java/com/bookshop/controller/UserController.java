package com.bookshop.controller;

import com.bookshop.common.Result;
import com.bookshop.common.ResultGenerator;
import com.bookshop.domain.User;
import com.bookshop.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;


@RestController  // 相比于Controller，不需要在返回值前面写ResponseBody， ResponseBody处于默认活动状态
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    private static final Logger log = Logger.getLogger(UserController.class);


    @RequestMapping("")
    public ModelAndView login() {
        return new ModelAndView("login");
    }

    @RequestMapping(value = "/sessions", method = RequestMethod.POST)
    @ResponseBody
    public Result checkLogin(@RequestBody User user, HttpServletRequest request){


        Integer flag = userService.checkUser(user);

        log.info("request: user/login , user: " + user.toString());

        if(flag == 1){
            Map data = new HashMap();
            // 设置当前登录用户
            data.put("currentUser", user);
            // 将登录信息存入session
            request.getSession().setAttribute("user", userService.getByStudentid(user.getStudentid()));

            return ResultGenerator.genSuccessResult(data);
        }else{
            return ResultGenerator.genFailResult("账号或者密码错误!");
        }
    }

    @RequestMapping(value = "/sessions",method = RequestMethod.DELETE)
    public Result logout(HttpServletRequest request) {

        request.getSession().removeAttribute("user");
        return ResultGenerator.genSuccessResult();
    }

}
