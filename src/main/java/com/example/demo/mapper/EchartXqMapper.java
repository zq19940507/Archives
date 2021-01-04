package com.example.demo.mapper;

import com.example.demo.model.Echart2_xq;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface EchartXqMapper {
    @Select("select a.day as day,case when b.community is null then #{community} else b.community end as community,case when b.wantoubi is null then 0 else b.wantoubi end as wantoubi from  (select distinct  day from echarts_xq where date_format(day, '%Y-%m-%d') >= #{starttime} and date_format(day, '%Y-%m-%d') <= #{endtime} ) a\n" +
            "\n" +
            "left join (select community,wantoubi,day from echarts_xq where community like concat('%',#{community},'%')\n" +
            "                                                           and date_format(day, '%Y-%m-%d') >= #{starttime} and date_format(day, '%Y-%m-%d') <= #{endtime} ) b on\n" +
            "a.day=b.day order by day;")
    List<Echart2_xq> queryCommunity(@Param("starttime") String startTime,
                                    @Param("endtime") String endTime1,
                                    @Param("community") String community);
}
