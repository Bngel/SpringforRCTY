package cn.bngel.rcty.controller;

import cn.bngel.rcty.bean.CommonResult;
import cn.bngel.rcty.bean.Video;
import cn.bngel.rcty.service.VideoService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@Api(tags = "视频模块")
public class VideoController {

    @Autowired
    private VideoService videoService;

    @PostMapping("/video")
    public CommonResult saveVideo(@RequestBody Video video) {
        Integer result = videoService.saveVideo(video);
        if (result == 1) {
            return CommonResult.getSuccessResult();
        } else {
            return CommonResult.getFailureResult();
        }
    }

    @DeleteMapping("/video")
    public CommonResult deleteVideoById(@RequestParam("id") Long id) {
        Integer result = videoService.deleteVideoById(id);
        if (result == 1) {
            return CommonResult.getSuccessResult();
        } else {
            return CommonResult.getFailureResult();
        }
    }

    @PutMapping("/video")
    public CommonResult updateVideoById(@RequestBody Video video) {
        if (video.getId() == null) {
            return CommonResult.getFailureResult();
        }
        Integer result = videoService.updateVideoById(video);
        if (result == 1) {
            return CommonResult.getSuccessResult();
        } else {
            return CommonResult.getFailureResult();
        }
    }

    @GetMapping("/video")
    public CommonResult getVideoById(@RequestParam("id") Long id) {
        Video video = videoService.getVideoById(id);
        if (video != null) {
            return new CommonResult(CommonResult.SUCCESS_CODE, video, CommonResult.SUCCESS_MSG);
        }
        else {
            return CommonResult.getFailureResult();
        }
    }

}