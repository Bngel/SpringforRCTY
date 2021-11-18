package cn.bngel.rcty.service;


import cn.bngel.rcty.bean.Reply;
import cn.bngel.rcty.dao.ReplyDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReplyServiceImpl implements ReplyService{

    @Autowired
    private ReplyDao replyDao;

    @Override
    public Integer saveReply(Reply reply) {
        return replyDao.saveReply(reply);
    }

    @Override
    public Integer deleteReplyById(Long id) {
        return replyDao.deleteReplyById(id);
    }

    @Override
    public Integer updateReplyById(Reply reply) {
        return replyDao.updateReplyById(reply);
    }

    @Override
    public Reply getReplyById(Long id) {
        return replyDao.getReplyById(id);
    }

}
