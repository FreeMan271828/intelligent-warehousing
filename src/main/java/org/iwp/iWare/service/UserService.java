package org.iwp.iWare.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.iwp.iWare.object.Do.UserDo;
import org.iwp.iWare.object.entity.User;
import org.iwp.iWare.object.model.ResponseModel;

import java.util.List;

public interface UserService {

    Boolean register(User user);

    List<User> findAll();
}
