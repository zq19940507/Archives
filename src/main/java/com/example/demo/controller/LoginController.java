package com.example.demo.controller;

import com.example.demo.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Created by 登录 on 2020/12/31 14:44
 */
@Controller
public class LoginController {
    //    @RequestMapping(value = "/user/login",method = RequestMethod.POST)
//    用requestparam标注的数据，没有收到请求就会直接报错

    @GetMapping(value="/")
    public String loginPage(){
        return "index";
    }


    @PostMapping(value = "/user/navigation")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Model model, HttpSession session) {

        System.out.println(username);
        if (!StringUtils.isEmpty(username) && "123456".equals(password)) {


//            System.out.println(username);

            session.setAttribute("user",password);



            //登陆成功
            System.out.println("if-----------");

            return "navigation";
//            return username;

        } else {
            //登录失败
            model.addAttribute("msg","账号密码错误");

            return "index";
        }


    }



}
