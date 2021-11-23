package cn.bngel.rcty.controller;

import cn.bngel.rcty.bean.CommonResult;
import cn.bngel.rcty.bean.Log;
import cn.bngel.rcty.service.LogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@Api(tags = "日志模块")
public class LogController {

    @Autowired
    private LogService logService;

    @ApiOperation(value = "创建日志")
    @PostMapping("/log")
    public CommonResult saveLog(@RequestBody Log log) {
        Integer result = logService.saveLog(log);
        if (result == 1) {
            return CommonResult.getSuccessResult();
        } else {
            return CommonResult.getFailureResult();
        }
    }

    @ApiOperation(value = "删除日志")
    @DeleteMapping("/log")
    public CommonResult deleteLogById(@RequestParam("id") Long id) {
        Integer result = logService.deleteLogById(id);
        if (result == 1) {
            return CommonResult.getSuccessResult();
        } else {
            return CommonResult.getFailureResult();
        }
    }

    @ApiOperation(value = "更新日志")
    @PutMapping("/log")
    public CommonResult updateLogById(@RequestBody Log log) {
        if (log.getId() == null) {
            return CommonResult.getFailureResult();
        }
        Integer result = logService.updateLogById(log);
        if (result == 1) {
            return CommonResult.getSuccessResult();
        } else {
            return CommonResult.getFailureResult();
        }
    }

    @ApiOperation(value = "查询日志")
    @GetMapping("/log")
    public CommonResult getLogById(@RequestParam("id") Long id) {
        Log log = logService.getLogById(id);
        if (log != null) {
            return new CommonResult(CommonResult.SUCCESS_CODE, log, CommonResult.SUCCESS_MSG);
        }
        else {
            return CommonResult.getFailureResult();
        }
    }

}