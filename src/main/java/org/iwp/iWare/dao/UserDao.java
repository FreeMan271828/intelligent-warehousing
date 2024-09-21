package org.iwp.iWare.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.iwp.iWare.object.Do.UserDo;

@Mapper
public interface UserDao extends BaseMapper<UserDo> {}
