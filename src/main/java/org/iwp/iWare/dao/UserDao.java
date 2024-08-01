package org.iwp.iWare.dao;

import org.apache.ibatis.annotations.Mapper;
import org.iwp.iWare.entity.UserDo;

import java.util.List;

@Mapper
public interface UserDao {
    //单条增加用户
    Integer AddUser(UserDo user);

    //获取全部用户
    List<UserDo> GetAllUsers();
}
