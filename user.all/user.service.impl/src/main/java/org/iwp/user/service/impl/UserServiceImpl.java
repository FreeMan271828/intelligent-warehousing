package org.iwp.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.iwp.common.util.LogUtil;
import org.iwp.common.util.RedisCodeUtil;
import org.iwp.user.dao.UserDao;
import org.iwp.user.dataobject.UserDo;
import org.iwp.user.entity.User;
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