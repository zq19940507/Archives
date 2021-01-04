package com.example.demo.controller;
import com.example.demo.mapper.WorkersMapper;
import com.example.demo.mapper.ZwMapper;
import com.example.demo.model.Workers;
import com.example.demo.model.Zw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class Cm4Controller {
    @Autowired
    ZwMapper zwMapper;


    @GetMapping("/cm4")
    public String cm3(){

        return "cm4";
    }

    @GetMapping("/data3")
    @ResponseBody
    public Map<String, Object> getdataAsync1(@RequestParam(name = "start_time", required = false,defaultValue = "2020-07-01") String starTtime,
                                             @RequestParam(name = "end_time", required = false,defaultValue = "2020-07-10") String endTime,
                                             @RequestParam(name = "dan_y", required = false) String dany,
                                             @RequestParam(name = "xiaoqu_in", required = false) String xiaoquin
                                             ) {

        List<Zw> zw = zwMapper.find_All(starTtime,dany,xiaoquin);

        Map<String, Object> map = new HashMap<>();

        map.put("zw", zw);

//        System.out.println(map);

        return map;

    }


}
