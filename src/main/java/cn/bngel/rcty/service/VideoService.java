package cn.bngel.rcty.service;

import cn.bngel.rcty.bean.Video;

public interface VideoService {

    Integer saveVideo(Video video);

    Integer deleteVideoById(Long id);

    Integer updateVideoById(Video video);

    Video getVideoById(Long id);

}
