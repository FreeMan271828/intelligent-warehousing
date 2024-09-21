package org.iwp.iWare.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.iwp.iWare.dao.UserDao;
import org.iwp.iWare.object.Do.UserDo;
import org.iwp.iWare.object.entity.User;
import org.iwp.iWare.object.model.ResponseModel;
import org.iwp.iWare.service.UserService;
import org.iwp.iWare.util.LogUtil;
import org.iwp.iWare.util.RedisCodeUtil;
import org.iwp.iWare.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{

    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao){
        this.userDao = userDao;
    }

    @Override
    public Boolean register(User user) {
        if(StringUtils.containsWhitespace(user.getName()) ||
           StringUtils.containsWhitespace(user.getPassword())) {
            LogUtil.error("");
            return false;
        }
        user.setCode(RedisCodeUtil.generateCode(UserDao.class));
        user.setStatus(1);
        return userDao.insert(new UserDo(user)) > 0;
    }

    @Override
    public List<User> findAll(){
        QueryWrapper<UserDo> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("code");
        List<UserDo> userDoList = userDao.selectList(null);
        return userDoList.stream()  // 创建一个Stream<UserDo>
                .map(UserDo::toUser)     // 将每个UserDo对象转换为User对象
                .collect(Collectors.toList());  // 收集转换后的结果到List<User>中
    }

}