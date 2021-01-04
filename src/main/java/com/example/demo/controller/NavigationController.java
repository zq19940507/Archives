package com.example.demo.controller;

import com.example.demo.mapper.*;
import com.example.demo.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;




@Controller
public class NavigationController {
    @Autowired
    Echart1_DyMapper echart1_dyMapper;

    @Autowired
    Echart2_DyMapper echart2_dyMapper;

    @Autowired
    Echart3_DyMapper echart3_dyMapper;

    @Autowired
    Echart4_DyMapper echart4_dyMapper;

    @Autowired
    Echart5_DyMapper echart5_dyMapper;

    @Autowired
    Echart6_DyMapper echart6_dyMapper;

    @Autowired
    WeatherMapper weatherMapper;

    @GetMapping("/navigation")
    public String index() {
//        model.addAttribute("name",name);
        return "navigation";

    }



    @GetMapping("/data0")
    @ResponseBody
    public Map<String, Object> getdataAsync(@RequestParam(name = "start_time", required = false) String starTtime,
                                            @RequestParam(name = "end_time", required = false) String endTime) throws ParseException {



        Map<String, Object> map = new HashMap<>();



        List<Echart1_dy> echart1_dies = echart1_dyMapper.getAllsq(starTtime,endTime);

        List<Echart1_dy> echart2_dies = echart2_dyMapper.getAllxq(starTtime,endTime);

        List<Echart1_dy> echart3_dies = echart3_dyMapper.getAlldt(starTtime,endTime);

        List<Echart1_dy> echart4_dies = echart4_dyMapper.getAlldy(starTtime,endTime);

        List<Echart1_dy> echart5_dies = echart5_dyMapper.getAllyz(starTtime,endTime);

        List<Echart1_dy> echart6_dies = echart6_dyMapper.getAlljr(starTtime,endTime);

        List<Weather> weathers=weatherMapper.queryALL_2(starTtime,endTime);

        map.put("echart1_dies",echart1_dies);

        map.put("echart2_dies",echart2_dies);

        map.put("echart3_dies",echart3_dies);

        map.put("echart4_dies",echart4_dies);

        map.put("echart5_dies",echart5_dies);

        map.put("echart6_dies",echart6_dies);

        map.put("weathers",weathers);


        return map;

    }

}


