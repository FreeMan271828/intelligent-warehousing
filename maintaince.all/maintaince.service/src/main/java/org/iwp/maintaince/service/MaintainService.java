package org.iwp.maintaince.service;

import org.iwp.common.model.ResponseModel;

public interface MaintainService {
    ResponseModel getMaintainedRecord();

    ResponseModel getUnmaintainedRecord();
    ResponseModel getKeepPoint(String deviceName,int status);
}
