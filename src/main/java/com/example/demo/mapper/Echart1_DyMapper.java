package com.example.demo.mapper;
import com.example.demo.model.Echart1_dy;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface Echart1_DyMapper {

    @Select("select wantoubi,dy from echarts where date_format(day, '%Y-%m-%d') >= #{startTime} and date_format(day, '%Y-%m-%d') <= #{endTime} and dy='市区分公司'  " )
    List<Echart1_dy> getAllsq(@Param("startTime") String startTime, @Param("endTime") String endTime);



}
