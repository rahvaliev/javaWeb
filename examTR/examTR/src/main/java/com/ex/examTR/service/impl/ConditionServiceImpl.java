package com.ex.examTR.service.impl;

import com.ex.examTR.model.entity.Condition;
import com.ex.examTR.model.entity.enums.ConditionNameEnum;
import com.ex.examTR.repository.ConditionRepository;
import com.ex.examTR.service.ConditionService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
@Service
public class ConditionServiceImpl implements ConditionService {
    private final ConditionRepository conditionRepository;

    public ConditionServiceImpl(ConditionRepository conditionRepository) {
        this.conditionRepository = conditionRepository;
    }

    @Override
    public void init() {
        if(conditionRepository.count()==0){
            Arrays.stream(ConditionNameEnum.values())
                    .forEach(conditionNameEnum -> {
                        Condition condition=new Condition();
                        condition.setName(conditionNameEnum);
                        switch (conditionNameEnum){
                            case GOOD -> condition.setDescription("Some signs of wear and tear or minor defects");
                            case EXCELLENT -> condition.setDescription("In perfect condition");
                            case ACCEPTABLE -> condition.setDescription("The item is fairly worn but continues to function properly");
                        }
                        conditionRepository.save(condition);
                    });
        }

    }

    @Override
    public Condition findByConditionName(ConditionNameEnum conditionNameEnum) {
        return conditionRepository.findByName(conditionNameEnum).orElse(null);
    }
}
