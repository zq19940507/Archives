package com.example.demo.mapper;

import com.example.demo.model.Weather;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface WeatherMapper {
    @Select("select date_format(time, '%Y-%m-%d') as time, tianqi,temperature from weather where date_format(time, '%Y-%m-%d') >= #{starttime} and date_format(time, '%Y-%m-%d') <= #{endtime}\n" +
            "order by time")
    List<Weather> queryALL_2(@Param("starttime") String starttime,
                             @Param("endtime") String endtime);
}
