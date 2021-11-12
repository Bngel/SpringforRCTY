package cn.bngel.rcty.service;

import cn.bngel.rcty.bean.User;
import cn.bngel.rcty.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    @Override
    public Integer saveUser(User user) {
        return userDao.saveUser(user);
    }

    @Override
    public Integer deleteUserById(Long id) {
        return userDao.deleteUserById(id);
    }

    @Override
    public Integer updateUserById(User user) {
        return userDao.updateUserById(user);
    }

    @Override
    public User getUserById(Long id) {
        return userDao.getUserById(id);
    }

    @Override
    public User login(String account, String password) {
        return userDao.login(account, password);
    }

    @Override
    public Integer updateUsernameById(Long id, String username) {
        User user = new User();
        user.setId(id);
        user.setUsername(username);
        return userDao.updateUserById(user);
    }
}
