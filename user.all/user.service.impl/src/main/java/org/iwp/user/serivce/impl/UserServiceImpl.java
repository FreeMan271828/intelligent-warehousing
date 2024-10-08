package org.iwp.user.serivce.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import org.iwp.common.model.ResponseModel;
import org.iwp.common.util.LogUtil;
import org.iwp.common.util.RedisCodeUtil;
import org.iwp.common.util.ResponseUtil;
import org.iwp.user.dao.UserDao;
import org.iwp.user.dataobject.UserDo;
import org.iwp.user.entity.User;
import org.iwp.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao){
        this.userDao = userDao;
    }

    @Override
    public ResponseModel add(User user) {
        if(StringUtils.containsWhitespace(user.getName()) ||
           StringUtils.containsWhitespace(user.getPassword())) {
            LogUtil.error("用户姓名以及密码不能为空");
            ResponseModel responseModel = ResponseUtil.ParamError(null);
            responseModel.setMsg("用户姓名以及密码不能为空");
            return responseModel;
        }
        user.setCode(RedisCodeUtil.generateCode(UserDao.class));
        user.setStatus(1);
        boolean ret = userDao.insert(new UserDo(user)) > 0;
        if (!ret){
            LogUtil.error("插入失败");
            ResponseModel responseModel = ResponseUtil.ServerError(null);
            responseModel.setMsg("插入失败");
            return responseModel;
        }
        return ResponseUtil.Success(true);
    }

    @Override
    public ResponseModel ifExist(String name, String password) {
        if(StringUtils.containsWhitespace(name) || StringUtils.containsWhitespace(password)) {
            LogUtil.error("用户姓名以及密码不能为空");
            ResponseModel responseModel = ResponseUtil.ParamError(null);
            responseModel.setMsg("用户姓名以及密码不能为空");
            return responseModel;
        }
        QueryWrapper<UserDo> wrapper = new QueryWrapper<>();
        wrapper.eq("name", name);
        wrapper.eq("password", password);
        List<UserDo> list = userDao.selectList(wrapper);
        if(list.isEmpty()) {
            ResponseModel responseModel = ResponseUtil.ServerError(null);
            responseModel.setMsg("姓名或密码错误");
            return responseModel;
        }
        return ResponseUtil.Success(true);
    }

    @Override
    public ResponseModel getStatus(String name) {
        if(StringUtils.containsWhitespace(name)) {
            LogUtil.error("姓名不能为空");
            ResponseModel responseModel = ResponseUtil.ParamError(null);
            responseModel.setMsg("姓名不能为空");
            return responseModel;
        }
        QueryWrapper<UserDo> wrapper = new QueryWrapper<>();
        wrapper.eq("name", name);
        List<UserDo> list = userDao.selectList(wrapper);
        if(list.isEmpty()) {
            ResponseModel responseModel = ResponseUtil.ServerError(null);
            responseModel.setMsg("姓名错误, 找不到"+name);
            return responseModel;
        }
        return ResponseUtil.Success(list.get(0).getStatus());
    }

    @Override
    public ResponseModel updateStatus(String name) {

        if(StringUtils.containsWhitespace(name)) {
            LogUtil.error("姓名不能为空");
            ResponseModel responseModel = ResponseUtil.ParamError(null);
            responseModel.setMsg("姓名不能为空");
            return responseModel;
        }

        QueryWrapper<UserDo> wrapper = new QueryWrapper<>();
        wrapper.eq("name", name);
        List<UserDo> queryRet = userDao.selectList(wrapper);
        if(queryRet.isEmpty()) {
            ResponseModel responseModel = ResponseUtil.ServerError(null);
            responseModel.setMsg("姓名错误, 找不到"+name);
            return responseModel;
        }
        int status = queryRet.get(0).getStatus();

        UpdateWrapper<UserDo> userDoUpdateWrapper = new UpdateWrapper<>();
        userDoUpdateWrapper.eq("name", name);
        UserDo userDo = new UserDo();
        userDo.setStatus(status==1?0:1);
        int updateRet = userDao.update(userDo, userDoUpdateWrapper);

        if(updateRet<0){
            ResponseModel responseModel = ResponseUtil.ServerError(null);
            responseModel.setMsg("插入失败");
            return responseModel;
        }

        return ResponseUtil.Success(true);
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