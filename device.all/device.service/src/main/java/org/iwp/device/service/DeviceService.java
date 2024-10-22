package org.iwp.device.service;

import org.iwp.common.model.PageModel;
import org.iwp.device.entity.Device;

import java.util.List;

public interface DeviceService {

    List<Device> getAllDevices();

    String getFacCodeByDeviceName(String deviceName);

    PageModel getElementCodeByFacCode(String facCode);


}