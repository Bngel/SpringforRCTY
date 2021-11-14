package cn.bngel.rcty.dao;

import cn.bngel.rcty.bean.Log;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface LogDao {

    Integer saveLog(@Param("Log") Log Log);

    Integer deleteLogById(@Param("id") Long id);

    Log getLogById(@Param("id") Long id);

    Log login(@Param("account") String account, @Param("password") String password);

    Integer updateLogById(@Param("Log") Log Log);
}
