package com.example.demo.mapper;

import com.example.demo.model.WgWtb;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by ZQ1994 on 2020/12/15 14:43
 */
@Mapper
public interface WgWtbMapper {
    @Select("select * from(select a.wangge,date_format(a.process_time, '%Y-%m-%d') day,ROUND(count(a.wangge)/b.users*10000,1) wantoubi\n" +
            "              from data_source a ,\n" +
            "                   (select sum(users) as users,wg from basic_info1 where wg is not null group by wg) b where a.wangge=b.wg and (a.wangge=#{wangge} or #{wangge} is null or #{wangge}='') and " +
            "date_format(a.process_time, '%Y-%m-%d') >= #{starttime} and date_format(a.process_time, '%Y-%m-%d') <= #{endtime} group by a.wangge,date_format(a.process_time, '%Y-%m-%d')\n" +
            "\n" +
            "              order by date_format(a.process_time, '%Y-%m-%d')) AS a")
    List<WgWtb> query_all4(@Param("starttime") String starttime,
                           @Param("endtime") String endtime,
                           @Param("wangge") String wangge);
}
