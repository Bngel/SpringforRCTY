package cn.bngel.rcty.service;


import cn.bngel.rcty.bean.Log;
import cn.bngel.rcty.dao.LogDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogServiceImpl implements LogService{

    @Autowired
    private LogDao logDao;

    @Override
    public Integer saveLog(Log Log) {
        return logDao.saveLog(Log);
    }

    @Override
    public Integer deleteLogById(Long id) {
        return logDao.deleteLogById(id);
    }

    @Override
    public Integer updateLogById(Log Log) {
        return logDao.updateLogById(Log);
    }

    @Override
    public Log getLogById(Long id) {
        return logDao.getLogById(id);
    }

}
