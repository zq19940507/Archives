package com.example.demo.mapper;

import com.example.demo.model.WorkSheet;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
*表格工单万投比展示
*/



@Mapper
public interface WorkSheetMapper {
    @Select("select danyuan as danyuan,wangge as wangge,\n" +
            "       dw as dw,community as community,id,count(1) as cm ,\n" +
            "       com_num as com_num,ROUND(count(1)/com_num*10000,1) as wtb from data_source\n" +
            "where  id is not null and danyuan is not null and com_num>=100 and  (danyuan=#{danyuan} or #{danyuan} is null or #{danyuan}='') and (wangge=#{wangge} or #{wangge} is null or #{wangge}='')\n" +
            "and community like concat('%',#{community},'%') and date_format(process_time, '%Y-%m-%d') >= #{starttime} and date_format(process_time, '%Y-%m-%d') <= #{endtime}" +
            "and type like concat('%',#{type},'%')\n" +
            "group by id ORDER BY wtb DESC limit 50")
    List<WorkSheet> query_ALL2(@Param("starttime") String starttime,
                               @Param("endtime") String endtime,
                               @Param("danyuan") String danyuan,
                               @Param("wangge") String wangge,
                               @Param("community") String community,
                               @Param("type") String type);



//    @Select("select any_value(danyuan) as danyuan,any_value(wangge) as wangge,\n" +
//            "       any_value(dw) as dw,any_value(community) as community,id,count(1) as cm ,\n" +
//            "       any_value(com_num) as com_num,ROUND(count(1)/any_value(com_num)*10000,1) as wtb from data_source\n" +
//            "where  id is not null and danyuan is not null and com_num>=100 and  (danyuan=#{danyuan} or #{danyuan} is null or #{danyuan}='') and (wangge=#{wangge} or #{wangge} is null or #{wangge}='')\n" +
//            "and community like concat('%',#{community},'%') and date_format(process_time, '%Y-%m-%d') >= #{starttime} and date_format(process_time, '%Y-%m-%d') <= #{endtime}" +
//            "and type like concat('%',#{type},'%')\n" +
//            "group by id ORDER BY wtb DESC limit 50")
//    List<WorkSheet> query_ALL2(@Param("starttime") String starttime,
//                               @Param("endtime") String endtime,
//                               @Param("danyuan") String danyuan,
//                               @Param("wangge") String wangge,
//                               @Param("community") String community,
//                               @Param("type") String type);
}
