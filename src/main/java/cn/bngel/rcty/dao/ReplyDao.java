package cn.bngel.rcty.dao;

import cn.bngel.rcty.bean.Reply;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ReplyDao {

    Integer saveReply(@Param("reply") Reply reply);

    Integer deleteReplyById(@Param("id") Long id);

    Reply getReplyById(@Param("id") Long id);

    Integer updateReplyById(@Param("reply") Reply reply);
}
