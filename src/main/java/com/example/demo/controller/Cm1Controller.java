package com.example.demo.controller;
import com.example.demo.mapper.*;
import com.example.demo.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.*;

@Controller
public class Cm1Controller {
    @Autowired
    WtbMapper wtbMapper;

    @Autowired
    WtbAllMapper wtbAllMapper;

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
    EchartXqMapper echartXqMapper;

    @Autowired
    TenMapper tenMapper;

    @Autowired
    WeatherMapper weatherMapper;

    @Autowired
    WgWtbMapper wgWtbMapper;

    @Autowired
    EchartAll_DyMapper echartAll_dyMapper;

    @Autowired
    BreakDown_Mapper breakDown_mapper;

//    @GetMapping("/cm1")
//    public String queryALL_cm1(Map<String, Object> map,
//                               Model model){
//        //查询整张表, 返回List集合
//        List<Wtb> wtbs = wtbMapper.findAll();
//
//        map.put("wtbs", wtbs);
//
////        获取json格式
//        String result = JSON.toJSONString(map);
//
//        System.out.println("map 转 jsonString:" +result+"\n");
//        return "cm1";
//
//    }

    @GetMapping(value = "/user/cm1")
//    @GetMapping("/get_data")
    public String getdata(@RequestParam(name = "start_time", required = false,defaultValue = "2020-07-01") String starTtime,
                          @RequestParam(name = "end_time", required = false,defaultValue = "2020-07-10") String endTime,
                          @RequestParam(name = "dan_y", required = false) String dany,
                          @RequestParam(name = "wang_ge", required = false) String wangge,
                          @RequestParam(name = "xiaoqu_in", required = false) String xiaoquin,
                          Map<String, Object> map) {

//        List<Wtb> wtbs = wtbMapper.findAll(starTtime,endTime,dany,wangge,xiaoquin);
//
//        map.put("wtbs", wtbs);
//
//        List<Echart1_dy> echart1_dies = echart1_dyMapper.getAllsq(starTtime,endTime);
//
//        List<Echart1_dy> echart2_dies = echart2_dyMapper.getAllxq(starTtime,endTime);
//
//        List<Echart1_dy> echart3_dies = echart3_dyMapper.getAlldt(starTtime,endTime);
//
//        List<Echart1_dy> echart4_dies = echart4_dyMapper.getAlldy(starTtime,endTime);
//
//        List<Echart1_dy> echart5_dies = echart5_dyMapper.getAllyz(starTtime,endTime);
//
//        List<Echart1_dy> echart6_dies = echart6_dyMapper.getAlljr(starTtime,endTime);
//
//        map.put("echart1_dies",echart1_dies);
//
//        map.put("echart2_dies",echart2_dies);
//
//        map.put("echart3_dies",echart3_dies);
//
//        map.put("echart3_dies",echart4_dies);
//
//        map.put("echart4_dies",echart5_dies);
//
//        map.put("echart5_dies",echart6_dies);
//
//
//
//        System.out.println(echart1_dies);
//        System.out.println(wtbs);
////        System.out.println(map);
//
//        System.out.println(starTtime + "\n" + endTime + '\n' + dany + '\n' + wangge + '\n' + xiaoquin);


        return "cm1";

    }

    @GetMapping("/data")
    @ResponseBody
    public Map<String, Object> getdataAsync(@RequestParam(name = "start_time", required = false) String starTtime,
                                            @RequestParam(name = "end_time", required = false) String endTime,
                                            @RequestParam(name = "dan_y", required = false) String dany,
                                            @RequestParam(name = "wang_ge", required = false) String wangge,
                                            @RequestParam(name = "xiaoqu_in", required = false) String xiaoquin) throws ParseException {

        List<Wtb> wtbs = wtbMapper.findAll(starTtime,endTime,dany,wangge,xiaoquin);

        List<Wtb> wtbsall = wtbAllMapper.findAll(starTtime,endTime,dany,wangge,xiaoquin);

        List<Echart2_xq> echart2_xqs=echartXqMapper.queryCommunity(starTtime,endTime,xiaoquin);

        List<TenGpon> tenGpons=tenMapper.queryALL_1(starTtime,endTime,xiaoquin);

        List<Weather> weathers=weatherMapper.queryALL_2(starTtime,endTime);

        List<WgWtb> wgWtbs=wgWtbMapper.query_all4(starTtime,endTime,wangge);

        List<Echart1_dy> echartdy= echartAll_dyMapper.getAllqq(starTtime,endTime,dany);

        List<BreakDown> breakDowns = breakDown_mapper.queryBreakDown(starTtime,endTime,xiaoquin);

        Map<String, Object> map = new HashMap<>();

        map.put("echartdy", echartdy);

        map.put("wtbsall", wtbsall);

        map.put("echart2_xqs",echart2_xqs);

        map.put("wtbs", wtbs);

        map.put("tenGpons",tenGpons);

        map.put("weathers",weathers);

        map.put("wgWtbs",wgWtbs);

        map.put("breakDowns",breakDowns);


        List<Echart1_dy> echart1_dies = echart1_dyMapper.getAllsq(starTtime,endTime);

        List<Echart1_dy> echart2_dies = echart2_dyMapper.getAllxq(starTtime,endTime);

        List<Echart1_dy> echart3_dies = echart3_dyMapper.getAlldt(starTtime,endTime);

        List<Echart1_dy> echart4_dies = echart4_dyMapper.getAlldy(starTtime,endTime);

        List<Echart1_dy> echart5_dies = echart5_dyMapper.getAllyz(starTtime,endTime);

        List<Echart1_dy> echart6_dies = echart6_dyMapper.getAlljr(starTtime,endTime);

        map.put("echart1_dies",echart1_dies);

        map.put("echart2_dies",echart2_dies);

        map.put("echart3_dies",echart3_dies);

        map.put("echart4_dies",echart4_dies);

        map.put("echart5_dies",echart5_dies);

        map.put("echart6_dies",echart6_dies);

        //遍历日期
//        SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
//        Date sdate=df.parse(starTtime);
//        Date eDate=df.parse(endTime);
//        Calendar c = Calendar.getInstance();
//        List<String> list=new ArrayList<String>();
//        while (sdate.getTime()<=eDate.getTime()) {
//            list.add(df.format(sdate));
//            System.out.println(df.format(sdate));
//            c.setTime(sdate);
//            c.add(Calendar.DATE, 1); // 日期加1天
//            sdate = c.getTime();
//        }
//        System.out.println(list);

//        System.out.println(tenGpons);




        return map;

    }

}


