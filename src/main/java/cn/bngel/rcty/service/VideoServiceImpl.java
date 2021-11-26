package cn.bngel.rcty.service;


import cn.bngel.rcty.bean.Video;
import cn.bngel.rcty.dao.VideoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoServiceImpl implements VideoService{

    @Autowired
    private VideoDao videoDao;

    @Override
    public Integer saveVideo(Video video) {
        return videoDao.saveVideo(video);
    }

    @Override
    public Integer deleteVideoById(Long id) {
        return videoDao.deleteVideoById(id);
    }

    @Override
    public Integer updateVideoById(Video video) {
        return videoDao.updateVideoById(video);
    }

    @Override
    public Video getVideoById(Long id) {
        return videoDao.getVideoById(id);
    }

    @Override
    public List<Video> getVideosBetweenDates(String dateStart, String dateEnd){return videoDao.getVideosBetweenDates(dateStart, dateEnd);}

    @Override
    public List<Video> getAllVideos() {
        return videoDao.getAllVideos();
    }

    @Override
    public List<Video> getVideosByType(String type) {
        return videoDao.getVideosByType(type);
    }

}
