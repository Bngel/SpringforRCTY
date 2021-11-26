package cn.bngel.rcty.dao;

import cn.bngel.rcty.bean.Video;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.sql.Date;
import java.util.List;

@Mapper
public interface VideoDao {

    Integer saveVideo(@Param("video") Video video);

    Integer deleteVideoById(@Param("id") Long id);

    Video getVideoById(@Param("id") Long id);

    Integer updateVideoById(@Param("video") Video video);

    List<Video> getVideosBetweenDates(@Param("dateStart") String dateStart, @Param("dateEnd") String dateEnd);

    List<Video> getAllVideos();

    List<Video> getVideosByType(@Param("type") String type);

}
