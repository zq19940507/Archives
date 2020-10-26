package com.example.demo.controller;
import com.alibaba.fastjson.JSON;
import com.example.demo.mapper.Echart1_DyMapper;
import com.example.demo.mapper.WtbMapper;
import com.example.demo.model.Echart1_dy;
import com.example.demo.model.Wtb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;



@Controller
public class Cm1Controller {
    @Autowired
    WtbMapper wtbMapper;

    @Autowired
    Echart1_DyMapper echart1_dyMapper;

    @GetMapping("/cm1")
    public String queryALL_cm1(Map<String, Object> map,
                               Model model){
        //查询整张表, 返回List集合
        List<Wtb> wtbs = wtbMapper.findAll();

        map.put("wtbs", wtbs);


        
        List<Echart1_dy> echart1_dies = echart1_dyMapper.getAll();



        map.put("echart1_dies",echart1_dies);


//        获取json格式
        String result = JSON.toJSONString(map);

        System.out.println("map 转 jsonString:" +result+"\n");

//        System.out.println(map);

        return "cm1";

    }

//    @RequestMapping("/ch_dy")
//    public void get_danyuan(HttpServletRequest request ){
//        String query = request.getQueryString();
//        String danyuan = request.getParameter("danyuan");
//
//
//        System.out.println(query);
//        System.out.println(danyuan);
//
//    }

    @RequestMapping("/cm1")
    public void get_dany(HttpServletRequest request, HttpServletResponse response ) {



    }




}


