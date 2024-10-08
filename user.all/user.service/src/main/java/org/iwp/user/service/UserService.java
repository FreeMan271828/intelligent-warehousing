package org.iwp.user.service;


import org.iwp.common.model.ResponseModel;
import org.iwp.user.entity.User;

import java.util.List;

public interface UserService {

    ResponseModel add(User user);

    ResponseModel ifExist(String name, String password);

    ResponseModel getStatus(String name);

    ResponseModel updateStatus(String name);

    List<User> findAll();
}
