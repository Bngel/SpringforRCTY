package cn.bngel.rcty.service;

import cn.bngel.rcty.bean.Video;

import java.util.List;

public interface VideoService {

    Integer saveVideo(Video video);

    Integer deleteVideoById(Long id);

    Integer updateVideoById(Video video);

    Video getVideoById(Long id);

    List<Video> getVideosBetweenDates(String dateStart, String dateEnd);

    List<Video> getAllVideos();

    List<Video> getVideosByType(String type);

}
