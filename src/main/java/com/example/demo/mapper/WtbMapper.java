package com.example.demo.mapper;

import com.example.demo.model.Wtb;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface WtbMapper {
//    @Select("select location,zone,dw,community,id,complaint,user_amount,wtb_amount from temp1  a where date_format(day, '%Y-%m-%d') >= #{starttime} and date_format(day, '%Y-%m-%d') <= #{endtime} and  location=#{location} or #{location} is null or #{location}=''   limit 10 ")
//    List<Wtb> findAll(@Param("starttime") String starttime, @Param("endtime") String endtime, @Param("location") String location);


    @Select("select location as location,zone as zone,dw as dw,community as community,\n" +
            "    id,sum(complaint) as complaint,user_amount,round(sum(complaint)/avg(user_amount)*10000,1) as wtb_amount\n" +
            "from col\n" +
            "where date_format(day, '%Y-%m-%d') >= #{starttime} and date_format(day, '%Y-%m-%d') <= #{endtime} and user_amount>=100 and " +
            " (location=#{location} or #{location} is null or #{location}='') and (zone=#{zone} or #{zone} is null or #{zone}='')and community like concat('%',#{community},'%') group by id,user_amount order by wtb_amount desc limit 50;")

    List<Wtb> findAll(@Param("starttime") String starttime,
                      @Param("endtime") String endtime,
                      @Param("location") String location,
                      @Param("zone") String zone,
                      @Param("community") String community);

}
//public interface WtbMapper {
////    @Select("select location,zone,dw,community,id,complaint,user_amount,wtb_amount from temp1  a where date_format(day, '%Y-%m-%d') >= #{starttime} and date_format(day, '%Y-%m-%d') <= #{endtime} and  location=#{location} or #{location} is null or #{location}=''   limit 10 ")
////    List<Wtb> findAll(@Param("starttime") String starttime, @Param("endtime") String endtime, @Param("location") String location);
//
//
//    @Select("select any_value(location) as location,any_value(zone) as zone,any_value(dw) as dw,any_value(community) as community,\n" +
//            "    id,sum(complaint) as complaint,user_amount,round(sum(complaint)/avg(user_amount)*10000,1) as wtb_amount\n" +
//            "from col\n" +
//            "where date_format(day, '%Y-%m-%d') >= #{starttime} and date_format(day, '%Y-%m-%d') <= #{endtime} and user_amount>=100 and " +
//            " (location=#{location} or #{location} is null or #{location}='') and (zone=#{zone} or #{zone} is null or #{zone}='')and community like concat('%',#{community},'%') group by id,user_amount order by wtb_amount desc limit 50;")
//
//    List<Wtb> findAll(@Param("starttime") String starttime,
//                      @Param("endtime") String endtime,
//                      @Param("location") String location,
//                      @Param("zone") String zone,
//                      @Param("community") String community);
//
//}
