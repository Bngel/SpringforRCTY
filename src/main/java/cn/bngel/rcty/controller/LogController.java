package cn.bngel.rcty.controller;

import cn.bngel.rcty.bean.CommonResult;
import cn.bngel.rcty.bean.Log;
import cn.bngel.rcty.service.LogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class LogController {

    @Autowired
    private LogService logService;

    @PostMapping("/log")
    public CommonResult saveLog(@RequestBody Log log) {
        Integer result = logService.saveLog(log);
        if (result == 1) {
            return CommonResult.getSuccessResult();
        } else {
            return CommonResult.getFailureResult();
        }
    }

    @DeleteMapping("/log")
    public CommonResult deleteLogById(@RequestParam("id") Long id) {
        Integer result = logService.deleteLogById(id);
        if (result == 1) {
            return CommonResult.getSuccessResult();
        } else {
            return CommonResult.getFailureResult();
        }
    }

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

    @GetMapping("/log")
    public CommonResult getLogById(@RequestParam("id") Long id) {
        Log log = logService.getLogById(id);
        if (log != null) {
            return CommonResult.getSuccessResult();
        }
        else {
            return CommonResult.getFailureResult();
        }
    }

}