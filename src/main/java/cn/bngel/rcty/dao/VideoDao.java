package cn.bngel.rcty.dao;

import cn.bngel.rcty.bean.Video;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface VideoDao {

    Integer saveVideo(@Param("Video") Video video);

    Integer deleteVideoById(@Param("id") Long id);

    Video getVideoById(@Param("id") Long id);

    Integer updateVideoById(@Param("video") Video video);
}
