package org.iwp.device.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.iwp.device.dataObject.DeviceDo;

@Mapper
public interface DeviceDao extends BaseMapper<DeviceDo> {
}
