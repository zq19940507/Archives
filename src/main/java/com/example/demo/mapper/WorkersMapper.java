package com.example.demo.mapper;

import com.example.demo.model.Gj;
import com.example.demo.model.Workers;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface WorkersMapper {
    @Select("select location as location ,dw as dw,name as name,id,sum(comp) as complaint,\n" +
            "       wh_users as wh_users,round(sum(comp)/wh_users*10000,1) as wtb_amount,\n" +
            "      concat(round(sum(in_time)/sum(comp)*100,1),'%') as promptness\n" +
            "from  workers where date_format(time, '%Y-%m-%d') >= #{starttime} and date_format(time, '%Y-%m-%d') <= #{endtime} and " +
            "(location=#{location} or #{location} is null or #{location}='') and  name like concat('%',#{name},'%') group by id order by wtb_amount desc ")
    List<Workers> query_All(@Param("starttime") String starttime,
                            @Param("endtime") String endtime,
                            @Param("location") String location,
                            @Param("name") String name);
}


//public interface WorkersMapper {
//    @Select("select any_value(location) as location ,any_value(dw) as dw,any_value(name) as name,id,sum(comp) as complaint,\n" +
//            "       any_value(wh_users) as wh_users,round(sum(comp)/any_value(wh_users)*10000,1) as wtb_amount,\n" +
//            "      concat(round(sum(in_time)/sum(comp)*100,1),'%') as promptness\n" +
//            "from  workers where date_format(time, '%Y-%m-%d') >= #{starttime} and date_format(time, '%Y-%m-%d') <= #{endtime} and " +
//            "(location=#{location} or #{location} is null or #{location}='') and  name like concat('%',#{name},'%') group by id order by wtb_amount desc ")
//    List<Workers> query_All(@Param("starttime") String starttime,
//                           @Param("endtime") String endtime,
//                            @Param("location") String location,
//                            @Param("name") String name);
//}
