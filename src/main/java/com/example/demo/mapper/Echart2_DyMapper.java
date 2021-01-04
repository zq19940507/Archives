package com.example.demo.mapper;

import com.example.demo.model.Echart1_dy;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface Echart2_DyMapper {
    @Select("select wantoubi,dy from echarts where date_format(day, '%Y-%m-%d') >= #{startTime1} and date_format(day, '%Y-%m-%d') <= #{endTime1} and dy='新区分公司'  " )
    List<Echart1_dy> getAllxq(@Param("startTime1") String startTime, @Param("endTime1") String endTime1);
}
