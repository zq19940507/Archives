package com.example.demo.mapper;

import com.example.demo.model.Wtb;
import com.example.demo.model.Zw;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ZwMapper {
    @Select(" select location,dw,name,id,sample,round(score,1) as score,concat(round((score-1)/9*100,1),'%') as dos,sample_h5,round(score_h5,1) as score_h5 ,\n" +
            "       concat(round((score_h5-1)/9*100,1),'%') as dos_h5\n" +
            "from  zw  where date_format(time, '%Y-%m') = #{starttime} and (location=#{location} or #{location} is null or #{location}='') and (name=#{name} or #{name} is null or #{name}='') order by dos desc;")
    List<Zw> find_All(@Param("starttime") String starttime,
                      @Param("location") String location,
                      @Param("name") String name);

}

//public interface ZwMapper {
//    @Select("select location,dw,name,id,sample,ROUND(score,1) as score,case when sample=0 then '/' else\n" +
//            "\n" +
//            "       concat(round((score-1)/9*100,1),'%') end as dos,sample_h5,ROUND(score_h5,1) as  score_h5,\n" +
//            "\n" +
//            "        case when sample_h5=0 then '/' else\n" +
//            "       concat(round((score_h5-1)/9*100,1),'%') end as dos_h5 from  zw  where date_format(time, '%Y-%m') = #{starttime} and (location=#{location} or #{location} is null or #{location}='') and  name like concat('%',#{name},'%') order by dos desc;")
//    List<Zw> find_All(@Param("starttime") String starttime,
//                      @Param("location") String location,
//                      @Param("name") String name);
//
//}
