package com.example.demo.controller;

import com.example.demo.mapper.GjAllMapper;
import com.example.demo.mapper.GjMapper;
import com.example.demo.model.Echart1_dy;
import com.example.demo.model.Gj;
import com.example.demo.model.Wtb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Controller
public class Cm2Controller {

    @Autowired
    GjMapper gjMapper;

    @Autowired
    GjAllMapper gjAllMapper;


    @GetMapping("/user/cm2")
    public String getCm2(@RequestParam(name = "start_time", required = false,defaultValue = "2020-07-01") String starTtime,
                      @RequestParam(name = "end_time", required = false,defaultValue = "2020-07-10") String endTime,
                      @RequestParam(name = "dan_y", required = false) String dany,
                      @RequestParam(name = "wang_ge", required = false) String wangge
                      ){

//        List<Gj> gj = gjMapper.queryAll(starTtime,endTime);
//
//        Map<String, Object> map = new HashMap<>();
//
//        map.put("gj", gj);


        return "cm2";
    }



    @GetMapping("/data1")
    @ResponseBody
    public Map<String, Object> getdataAsync1(@RequestParam(name = "start_time", required = false,defaultValue = "2020-07-01") String starTtime,
                                            @RequestParam(name = "end_time", required = false,defaultValue = "2020-07-10") String endTime,
                                            @RequestParam(name = "dan_y", required = false) String dany,
                                            @RequestParam(name = "wang_ge", required = false) String wangge) {

        List<Gj> gj = gjMapper.queryAll(starTtime,endTime,dany,wangge);

        List<Gj> gjall = gjAllMapper.queryAll(starTtime,endTime,dany,wangge);

        Map<String, Object> map = new HashMap<>();

        map.put("gj", gj);
        map.put("gjall", gjall);

        System.out.println(map);

        return map;

    }

}


