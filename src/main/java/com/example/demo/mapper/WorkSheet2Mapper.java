package com.example.demo.mapper;

import com.example.demo.model.WorkSheet1;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;


/**
 *表格工单万投比数据导出
 *
 */

@Mapper
public interface WorkSheet2Mapper {

    @Select("select danyuan as danyuan ,wangge as wangge,community as community,kind2,count(kind2) as num2,\n" +
            "       kind1,count(kind1) as num1 from data_source where id is not null and kind1 is not null  and kind2 is not null and danyuan is not null and date_format(process_time, '%Y-%m-%d') >= #{starttime} and date_format(process_time, '%Y-%m-%d') <= #{endtime} " +
            "and community like concat('%',#{community},'%') and  (danyuan=#{danyuan} or #{danyuan} is null or #{danyuan}='') and (wangge=#{wangge} or #{wangge} is null or #{wangge}='')" +
            " and type like concat('%',#{type},'%') group by kind2,kind1 order by kind2;")
    List<WorkSheet1> query_ALL3(@Param("starttime") String starttime,
                                @Param("endtime") String endtime,
                                @Param("danyuan") String danyuan,
                                @Param("wangge") String wangge,
                                @Param("community") String community,
                                @Param("type") String type);


//    @Select("select any_value(danyuan) as danyuan ,any_value(wangge) as wangge,any_value(community) as community,kind2,count(kind2) as num2,\n" +
//            "       kind1,count(kind1) as num1 from data_source where id is not null and kind1 is not null  and kind2 is not null and danyuan is not null and date_format(process_time, '%Y-%m-%d') >= #{starttime} and date_format(process_time, '%Y-%m-%d') <= #{endtime} " +
//            "and community like concat('%',#{community},'%') and  (danyuan=#{danyuan} or #{danyuan} is null or #{danyuan}='') and (wangge=#{wangge} or #{wangge} is null or #{wangge}='')" +
//            " and type like concat('%',#{type},'%') group by kind2,kind1 order by kind2;")
//    List<WorkSheet1> query_ALL3(@Param("starttime") String starttime,
//                                @Param("endtime") String endtime,
//                                @Param("danyuan") String danyuan,
//                                @Param("wangge") String wangge,
//                                @Param("community") String community,
//                                @Param("type") String type);
}
