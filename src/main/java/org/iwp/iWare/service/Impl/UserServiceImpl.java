package org.iwp.iWare.service.Impl;

import org.iwp.iWare.dao.UserDao;
import org.iwp.iWare.entity.UserDo;
import org.iwp.iWare.model.ResponseResult.Result;
import org.iwp.iWare.service.UserService;
import org.iwp.iWare.util.LogUtil;
import org.iwp.iWare.util.RedisCodeMaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;
    private final RedisCodeMaker codeMaker;
    private final LogUtil logUtil;

    @Autowired
    public UserServiceImpl(UserDao userDao, RedisCodeMaker codeMaker, LogUtil logUtil){
        this.userDao = userDao; this.codeMaker = codeMaker;
        this.logUtil = logUtil;
    }

    @Override
    public Result register(UserDo user) {
        if(StringUtils.containsWhitespace(user.getName()) ||
           StringUtils.containsWhitespace(user.getPassword())) {
            logUtil.error("");
            return Result.ParamError(null);
        }
        user.setCode(codeMaker.generateCode(UserDao.class));
        user.setStatus(1);
        Boolean ret = userDao.AddUser(user) > 0;
        return Result.success(ret);
    }

    @Override
    public Result findAll(){
        List<UserDo> userDoList = userDao.GetAllUsers();
        return Result.success(userDoList);
    }
}