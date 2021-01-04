package com.example.demo.mapper;

import com.example.demo.model.Echart1_dy;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by ZQ1994 on 2020/12/15 15:11
 */
@Mapper
public interface EchartAll_DyMapper {
    @Select("select wantoubi,dy from echarts where date_format(day, '%Y-%m-%d') >= #{startTime1} and date_format(day, '%Y-%m-%d') <= #{endTime1} and (dy=#{dy} or #{dy} is null or #{dy}='')  " )
    List<Echart1_dy> getAllqq(@Param("startTime1") String startTime,
                              @Param("endTime1") String endTime1,
                              @Param("dy") String dy);
}
