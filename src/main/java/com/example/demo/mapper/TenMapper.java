package com.example.demo.mapper;

import com.example.demo.model.TenGpon;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper


public interface TenMapper {
    @Select("select id,name,OLT,dy,time from (" +
            "select id AS id,name as name, OLT as OLT,dy as dy,date_format(time, '%Y-%m-%d') as time from ten_gpon\n" +
            "\n" +
            "where date_format(time, '%Y-%m-%d') >= #{starttime} and date_format(time, '%Y-%m-%d') <= #{endtime} group by name,time) AS A where name like concat('%',#{name},'%')")
    List<TenGpon> queryALL_1(@Param("starttime") String starttime,
                             @Param("endtime") String endtime,
                             @Param("name") String name);
}


//public interface TenMapper {
//    @Select("select id,name,OLT,dy,time from (" +
//            "select ANY_VALUE(id) AS id,any_value(name) as name, any_value(OLT) as OLT,any_value(dy) as dy,date_format(time, '%Y-%m-%d') as time from ten_gpon\n" +
//            "\n" +
//            "where date_format(time, '%Y-%m-%d') >= #{starttime} and date_format(time, '%Y-%m-%d') <= #{endtime} group by name,time) AS A where name like concat('%',#{name},'%')")
//    List<TenGpon> queryALL_1(@Param("starttime") String starttime,
//                             @Param("endtime") String endtime,
//                             @Param("name") String name);
//}
