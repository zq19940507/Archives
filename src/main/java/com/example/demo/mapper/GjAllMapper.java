package com.example.demo.mapper;

import com.example.demo.model.Gj;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface GjAllMapper {
    @Select("select danyuan as location ,wangge as zone, dw as dw\n" +
            "     ,gjcode as code ,sum(cm) as  complaint,case_user as user_amount,round(sum(cm)/avg(case_user)*10000,1) as wtb_amount  from  gj  where" +
            " date_format(time, '%Y-%m-%d') >= #{starttime} and date_format(time, '%Y-%m-%d') <= #{endtime} and " +
            "(danyuan=#{danyuan} or #{danyuan} is null or #{danyuan}='') and (wangge=#{wangge} or #{wangge} is null or #{wangge}='') group by gjcode order by wtb_amount desc ;")
    List<Gj> queryAll(@Param("starttime") String starttime,
                      @Param("endtime") String endtime,
                      @Param("danyuan") String danyuan,
                      @Param("wangge") String wangge);
}

//public interface GjAllMapper {
//    @Select("select any_value(danyuan) as location ,any_value(wangge) as zone, any_value(dw) as dw\n" +
//            "     ,gjcode as code ,sum(cm) as  complaint,any_value(case_user) as user_amount,round(sum(cm)/avg(case_user)*10000,1) as wtb_amount  from  gj  where" +
//            " date_format(time, '%Y-%m-%d') >= #{starttime} and date_format(time, '%Y-%m-%d') <= #{endtime} and " +
//            "(danyuan=#{danyuan} or #{danyuan} is null or #{danyuan}='') and (wangge=#{wangge} or #{wangge} is null or #{wangge}='') group by gjcode order by wtb_amount desc ;")
//    List<Gj> queryAll(@Param("starttime") String starttime,
//                      @Param("endtime") String endtime,
//                      @Param("danyuan") String danyuan,
//                      @Param("wangge") String wangge);
//}
