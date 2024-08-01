package org.iwp.iWare.service;

import org.iwp.iWare.entity.UserDo;
import org.iwp.iWare.model.ResponseResult.Result;

public interface UserService {

    Result register(UserDo user);

    Result findAll();
}
