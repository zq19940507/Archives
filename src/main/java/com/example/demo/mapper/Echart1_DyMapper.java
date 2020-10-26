package com.example.demo.mapper;

import com.example.demo.model.Echart1_dy;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface Echart1_DyMapper {

    @Select("select dy,wantoubi,day from temp2 where dy = '市区营销中心' ")

    List<Echart1_dy> getAll();
}
