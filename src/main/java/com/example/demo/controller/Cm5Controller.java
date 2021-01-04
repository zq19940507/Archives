package com.example.demo.controller;

import com.example.demo.mapper.WorkSheet2Mapper;
import com.example.demo.mapper.WorkSheetMapper;
import com.example.demo.model.WorkSheet;
import com.example.demo.model.WorkSheet1;
import com.example.demo.model.Workers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class Cm5Controller {

    @Autowired
    WorkSheetMapper workSheetMapper;

    @Autowired
    WorkSheet2Mapper workSheet2Mapper;

    @GetMapping(value = "/cm5")
    public String analy(){

        return "cm5";

    }



    @GetMapping("/data4")
    @ResponseBody
    public Map<String, Object> getdataAsync1(@RequestParam(name = "start_time", required = false,defaultValue = "2020-07-01") String starTtime,
                                             @RequestParam(name = "end_time", required = false,defaultValue = "2020-07-10") String endTime,
                                             @RequestParam(name = "dan_y", required = false) String dany,
                                             @RequestParam(name = "wang_ge", required = false) String wangge,
                                             @RequestParam(name = "xiaoqu_in", required = false) String xiaoquin,
                                             @RequestParam(name = "rt", required = false) String rt,
                                             @RequestParam(name = "rt1", required = false) String rt1,
                                             HttpServletRequest request
    ) {
        Map<String, Object> map = new HashMap<>();

        List<WorkSheet1> workSheet1s=workSheet2Mapper.query_ALL3(starTtime,endTime,dany,wangge,xiaoquin,rt1);

        List<WorkSheet> workSheets=workSheetMapper.query_ALL2(starTtime,endTime,dany,wangge,xiaoquin,rt1);




//        System.out.println("xiaoqu_in2="+xiaoquin);
        map.put("workSheets",workSheets);
        map.put("workSheet1s",workSheet1s);


        System.out.println(workSheets);
//        System.out.println(workSheet1s);


        return map;
    }

}
