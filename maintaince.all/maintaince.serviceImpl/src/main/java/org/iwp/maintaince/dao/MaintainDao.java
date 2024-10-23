package org.iwp.maintaince.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.iwp.maintaince.dataobject.MaintainDo;

import java.time.LocalDateTime;
import java.util.List;

public interface MaintainDao extends BaseMapper<MaintainDo> {
    List<MaintainDo> getHealthDegree(LocalDateTime startTime,LocalDateTime endTime);

}
