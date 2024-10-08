package org.iwp.user.service.impl;


import org.iwp.user.entity.User;

import java.util.List;

public interface UserService {

    Boolean register(User user);

    List<User> findAll();
}
