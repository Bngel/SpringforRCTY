package cn.bngel.rcty.service;

import cn.bngel.rcty.bean.Log;

public interface LogService {

    Integer saveLog(Log Log);

    Integer deleteLogById(Long id);

    Integer updateLogById(Log Log);

    Log getLogById(Long id);

}
