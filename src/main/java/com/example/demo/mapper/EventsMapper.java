package com.example.demo.mapper;

import com.example.demo.model.Events;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by 小区事件 on 2020/12/22 11:40
 */
@Mapper
public interface EventsMapper {
    @Select("select dy,wg,id,community," +
            "case when s1 is null then \"\" else  s1 end as s1," +
            "case when e1 is null then \"\" else  e1 end as e1," +
            "case when s2 is null then \"\" else  s2 end as s2," +
            "case when e2 is null then \"\" else  e2 end as e2," +
            "case when s3 is null then \"\" else  s3 end as s3," +
            "case when e3 is null then \"\" else  e3 end as e3 from events where  (dy=#{dy} or #{dy} is null or #{dy}='')" +
            "and (wg=#{wg} or #{wg} is null or #{wg}='') and " +
            "community like concat('%',#{community},'%') order by dy ,wg,id desc")
    List<Events> query_events(@Param("dy") String dy,
                              @Param("wg") String wg,
                              @Param("community") String community);
}
