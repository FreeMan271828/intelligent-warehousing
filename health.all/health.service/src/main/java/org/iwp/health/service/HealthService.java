package org.iwp.health.service;

import org.iwp.common.model.ResponseModel;

public interface HealthService {
    ResponseModel getHealthDegree(String startYear,String startMonth,String endYear,String endMonth);
}
