package org.iwp.user.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.iwp.user.dataobject.UserDo;

@Mapper
public interface UserDao extends BaseMapper<UserDo> {}
