package cn.bngel.rcty.controller;

import cn.bngel.rcty.bean.CommonResult;
import cn.bngel.rcty.bean.Reply;
import cn.bngel.rcty.service.ReplyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class ReplyController {

    @Autowired
    private ReplyService replyService;

    @PostMapping("/reply")
    public CommonResult saveReply(@RequestBody Reply reply) {
        Integer result = replyService.saveReply(reply);
        if (result == 1) {
            return CommonResult.getSuccessResult();
        } else {
            return CommonResult.getFailureResult();
        }
    }

    @DeleteMapping("/reply")
    public CommonResult deleteReplyById(@RequestParam("id") Long id) {
        Integer result = replyService.deleteReplyById(id);
        if (result == 1) {
            return CommonResult.getSuccessResult();
        } else {
            return CommonResult.getFailureResult();
        }
    }

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

    @GetMapping("/reply")
    public CommonResult getReplyById(@RequestParam("id") Long id) {
        Reply reply = replyService.getReplyById(id);
        if (reply != null) {
            return CommonResult.getSuccessResult();
        }
        else {
            return CommonResult.getFailureResult();
        }
    }

}