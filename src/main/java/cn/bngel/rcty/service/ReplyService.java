package cn.bngel.rcty.service;

import cn.bngel.rcty.bean.Reply;

public interface ReplyService {

    Integer saveReply(Reply reply);

    Integer deleteReplyById(Long id);

    Integer updateReplyById(Reply reply);

    Reply getReplyById(Long id);

}
