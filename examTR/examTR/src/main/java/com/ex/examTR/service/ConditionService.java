package com.ex.examTR.service;

import com.ex.examTR.model.entity.Condition;
import com.ex.examTR.model.entity.enums.ConditionNameEnum;

public interface ConditionService {
    void init();

    Condition findByConditionName(ConditionNameEnum conditionNameEnum);
}
