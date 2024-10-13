package org.iwp.user.serivce.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import org.iwp.common.model.ResponseModel;
import org.iwp.common.util.LogUtil;
import org.iwp.common.util.RedisCodeUtil;
import org.iwp.common.util.ResponseUtil;
import org.iwp.user.dao.UserDao;
import org.iwp.user.dataObject.UserDo;
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
        ResponseModel paramResponseModel = checkParam(user.getName(), user.getPassword());
        if (paramResponseModel != null) {
            return paramResponseModel;
        }
        if(ifExistName(user.getName())){
            ResponseModel responseModel = ResponseUtil.ParamError(null);
            responseModel.setMsg("用户名已存在");
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
        ResponseModel paramResponseModel = checkParam(name, password);
        if (paramResponseModel != null) {
            return paramResponseModel;
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
    public int getStatus(String name) {
        ResponseModel paramResponseModel = checkParam(name);
        if (paramResponseModel != null) {
            return -1;
        }
        QueryWrapper<UserDo> wrapper = new QueryWrapper<>();
        wrapper.eq("name", name);
        List<UserDo> list = userDao.selectList(wrapper);
        if(list.isEmpty()) {
            ResponseModel responseModel = ResponseUtil.ServerError(null);
            responseModel.setMsg("姓名错误, 找不到"+name);
            return -2;
        }
        return list.get(0).getStatus();
    }

    @Override
    public ResponseModel updateStatus(String name) {
        ResponseModel paramResponseModel = checkParam(name);
        if (paramResponseModel != null) {
            return paramResponseModel;
        }

        int status = getStatus(name);
        if(status==-2){
            ResponseModel responseModel = ResponseUtil.ServerError(null);
            responseModel.setMsg("姓名错误, 找不到"+name);
            return responseModel;
        }

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
    public ResponseModel delete(String name) {
        ResponseModel paramResponseModel = checkParam(name);
        if (paramResponseModel != null) {
            return paramResponseModel;
        }
        QueryWrapper<UserDo> wrapper = new QueryWrapper<>();
        wrapper.eq("name", name);
        int deleteRet = userDao.delete(wrapper);
        if(deleteRet<=0){
            ResponseModel responseModel = ResponseUtil.ServerError(null);
            responseModel.setMsg("删除失败");
            return responseModel;
        }
        return ResponseUtil.Success(deleteRet);
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



    /**
     * 判断参数是否合法
     * @param name 姓名
     * @param password 密码
     * @return 返回null表示不需要处理错误, 否则需要处理
     */
    private ResponseModel checkParam(String name, String password) {
        if (StringUtils.containsWhitespace(name) || StringUtils.containsWhitespace(password)) {
            LogUtil.error("用户姓名以及密码不能为空");
            ResponseModel responseModel = ResponseUtil.ParamError(null);
            responseModel.setMsg("用户姓名以及密码不能为空");
            return responseModel;
        }
        return null;
    }

    /**
     * 判断参数是否合法
     * @param name 姓名
     * @return 返回null表示不需要处理错误, 否则需要处理
     */
    private ResponseModel checkParam(String name) {
        if (StringUtils.containsWhitespace(name)) {
            LogUtil.error("姓名不能为空");
            ResponseModel responseModel = ResponseUtil.ParamError(null);
            responseModel.setMsg("姓名不能为空");
            return responseModel;
        }
        return null;
    }

    /**
     * 判断姓名是否存在
     * @param name 姓名
     * @return 若存在返回true
     */
    private boolean ifExistName(String name) {
        QueryWrapper<UserDo> wrapper = new QueryWrapper<>();
        wrapper.eq("name", name);
        return userDao.selectCount(wrapper) > 0;
    }
}