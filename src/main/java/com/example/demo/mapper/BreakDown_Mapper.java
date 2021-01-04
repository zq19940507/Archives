package com.example.demo.mapper;

import com.example.demo.model.BreakDown;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by 群障接口 on 2020/12/18 14:08
 */
@Mapper
public interface BreakDown_Mapper {
    @Select("select id,community,date_format(s_time, '%Y-%m-%d') as s_time from break_down " +
            "where date_format(s_time, '%Y-%m-%d') >= #{starttime} and date_format(s_time, '%Y-%m-%d') <= #{endtime} and community like concat('%',#{community},'%')")
    List<BreakDown> queryBreakDown(
            @Param("starttime") String starttime,
            @Param("endtime") String endtime,
            @Param("community") String community);
}
