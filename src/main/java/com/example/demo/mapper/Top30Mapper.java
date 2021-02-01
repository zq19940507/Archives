package com.example.demo.mapper;

import com.example.demo.model.WorkSheet1;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by top 30小区类型 on 2021/1/7 16:09
 */
@Mapper
public interface Top30Mapper {
    @Select("select danyuan as danyuan ,wangge as wangge,community as community,kind2,count(kind2) as num2, kind1,count(kind1) as num1 from (\n" +
            "\n" +
            "select * from data_source where community in ( SELECT community FROM (\n" +
            "\n" +
            "    select*from (select location as location,zone as zone,dw as dw,community as community,\n" +
            "                id,sum(complaint) as complaint,user_amount,round(sum(complaint)/avg(user_amount)*10000,1) as wtb_amount\n" +
            "                from col\n" +
            "                where date_format(day, '%Y-%m-%d') >= #{starttime} and date_format(day, '%Y-%m-%d') <= #{endtime} and user_amount>=100\n" +
            "                and location=\"市区分公司\" and community is not null group by id,user_amount order by wtb_amount desc limit 5) a  union all\n" +
            "\n" +
            "\n" +
            "    select*from (select location as location,zone as zone,dw as dw,community as community,\n" +
            "                id,sum(complaint) as complaint,user_amount,round(sum(complaint)/avg(user_amount)*10000,1) as wtb_amount\n" +
            "                from col\n" +
            "                where date_format(day, '%Y-%m-%d') >= #{starttime} and date_format(day, '%Y-%m-%d') <= #{endtime} and user_amount>=100\n" +
            "                and location=\"新区分公司\" and community is not null group by id,user_amount order by wtb_amount desc limit 5) b union all\n" +
            "\n" +
            "\n" +
            "    select*from (select location as location,zone as zone,dw as dw,community as community,\n" +
            "                id,sum(complaint) as complaint,user_amount,round(sum(complaint)/avg(user_amount)*10000,1) as wtb_amount\n" +
            "                from col\n" +
            "                where date_format(day, '%Y-%m-%d') >= #{starttime} and date_format(day, '%Y-%m-%d') <= #{endtime} and user_amount>=100\n" +
            "                and location=\"丹徒分公司\" and community is not null group by id,user_amount order by wtb_amount desc limit 5) c union all\n" +
            "\n" +
            "    select*from (select location as location,zone as zone,dw as dw,community as community,\n" +
            "                        id,sum(complaint) as complaint,user_amount,round(sum(complaint)/avg(user_amount)*10000,1) as wtb_amount\n" +
            "                 from col\n" +
            "                 where date_format(day, '%Y-%m-%d') >= #{starttime} and date_format(day, '%Y-%m-%d') <= #{endtime} and user_amount>=100\n" +
            "                   and location=\"丹阳分公司\" and community is not null group by id,user_amount order by wtb_amount desc limit 5) d union all\n" +
            "\n" +
            "    select*from (select location as location,zone as zone,dw as dw,community as community,\n" +
            "                        id,sum(complaint) as complaint,user_amount,round(sum(complaint)/avg(user_amount)*10000,1) as wtb_amount\n" +
            "                 from col\n" +
            "                 where date_format(day, '%Y-%m-%d') >= #{starttime} and date_format(day, '%Y-%m-%d') <= #{endtime} and user_amount>=100\n" +
            "                   and location=\"句容分公司\" and community is not null group by id,user_amount order by wtb_amount desc limit 5) e union all\n" +
            "\n" +
            "    select*from (select location as location,zone as zone,dw as dw,community as community,\n" +
            "                        id,sum(complaint) as complaint,user_amount,round(sum(complaint)/avg(user_amount)*10000,1) as wtb_amount\n" +
            "                 from col\n" +
            "                 where date_format(day, '%Y-%m-%d') >= #{starttime} and date_format(day, '%Y-%m-%d') <= #{endtime} and user_amount>=100\n" +
            "                   and location=\"扬中分公司\" and community is not null group by id,user_amount order by wtb_amount desc limit 5) f ) aa) and\n" +
            "\n" +
            "       date_format(process_time, '%Y-%m-%d') >= #{starttime} and date_format(process_time, '%Y-%m-%d') <= #{endtime} and kind1 is not null  and kind2 is not null)\n" +
            "    bb   group by bb.kind2,bb.kind1,bb.community ;")
    List<WorkSheet1> query_top30(@Param("starttime") String starttime,
                                 @Param("endtime") String endtime);
}
