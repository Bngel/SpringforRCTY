package cn.bngel.rcty.controller;

import cn.bngel.rcty.bean.CommonResult;
import cn.bngel.rcty.bean.Video;
import cn.bngel.rcty.service.VideoService;
import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.http.HttpProtocol;
import com.qcloud.cos.model.PutObjectResult;
import com.qcloud.cos.region.Region;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@RestController
@Slf4j
@Api(tags = "视频模块")
public class VideoController {

    @Autowired
    private VideoService videoService;

    @ApiOperation(value = "创建视频")
    @PostMapping("/video")
    public CommonResult saveVideo(@RequestBody Video video) {
        Integer result = videoService.saveVideo(video);
        if (result == 1) {
            return CommonResult.getSuccessResult();
        } else {
            return CommonResult.getFailureResult();
        }
    }

    @ApiOperation(value = "删除视频")
    @DeleteMapping("/video")
    public CommonResult deleteVideoById(@RequestParam("id") Long id) {
        Integer result = videoService.deleteVideoById(id);
        if (result == 1) {
            return CommonResult.getSuccessResult();
        } else {
            return CommonResult.getFailureResult();
        }
    }

    @ApiOperation(value = "修改视频")
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

    @ApiOperation(value = "查询视频")
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

    @ApiOperation(value = "上传视频文件")
    @PostMapping("/video/upload")
    public CommonResult uploadVideo(@RequestParam("file") MultipartFile file) throws IOException {
        COSClient cosClient = getCosClient();
        String filepath = System.getProperty("user.dir");
        String bucketName = "rcty-1302039980";
        String fileName = file.getOriginalFilename();
        System.out.println(filepath);
        File dest = new File(filepath + '\\' + fileName);
        file.transferTo(dest);
        cosClient.putObject(bucketName, fileName, dest);
        return new CommonResult(CommonResult.SUCCESS_CODE, cosClient.getObjectUrl(bucketName, fileName).toString(), CommonResult.SUCCESS_MSG);
    }



}