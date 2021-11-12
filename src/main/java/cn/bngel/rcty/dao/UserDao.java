package cn.bngel.rcty.dao;

import cn.bngel.rcty.bean.CommonResult;
import cn.bngel.rcty.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserDao {

    Integer saveUser(@Param("user") User user);

    Integer deleteUserById(@Param("id") Long id);

    User getUserById(@Param("id") Long id);

    User login(@Param("account") String account, @Param("password") String password);

    Integer updateUserById(@Param("user") User user);
}
