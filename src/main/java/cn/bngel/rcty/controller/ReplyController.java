package cn.bngel.rcty.controller;

import cn.bngel.rcty.bean.CommonResult;
import cn.bngel.rcty.bean.Reply;
import cn.bngel.rcty.service.ReplyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@Api(tags = "意见反馈模块")
public class ReplyController {

    @Autowired
    private ReplyService replyService;

    @ApiOperation(value = "创建反馈")
    @PostMapping("/reply")
    public CommonResult saveReply(@RequestBody Reply reply) {
        Integer result = replyService.saveReply(reply);
        if (result == 1) {
            return CommonResult.getSuccessResult();
        } else {
            return CommonResult.getFailureResult();
        }
    }

    @ApiOperation(value = "删除反馈")
    @DeleteMapping("/reply")
    public CommonResult deleteReplyById(@RequestParam("id") Long id) {
        Integer result = replyService.deleteReplyById(id);
        if (result == 1) {
            return CommonResult.getSuccessResult();
        } else {
            return CommonResult.getFailureResult();
        }
    }

    @ApiOperation(value = "更新反馈")
    @PutMapping("/reply")
    public CommonResult updateReplyById(@RequestBody Reply reply) {
        if (reply.getId() == null) {
            return CommonResult.getFailureResult();
        }
        Integer result = replyService.updateReplyById(reply);
        if (result == 1) {
            return CommonResult.getSuccessResult();
        } else {
            return CommonResult.getFailureResult();
        }
    }

    @ApiOperation(value = "查询反馈")
    @GetMapping("/reply")
    public CommonResult getReplyById(@RequestParam("id") Long id) {
        Reply reply = replyService.getReplyById(id);
        if (reply != null) {
            return new CommonResult(CommonResult.SUCCESS_CODE, reply, CommonResult.SUCCESS_MSG);
        }
        else {
            return CommonResult.getFailureResult();
        }
    }

}