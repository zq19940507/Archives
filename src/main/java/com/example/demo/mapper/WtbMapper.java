package com.example.demo.mapper;

import com.example.demo.model.Wtb;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface WtbMapper {
    @Select("select location,zone,dw,community,id,complaint,user_amount,wtb_amount from temp1")
    List<Wtb> findAll();
}
