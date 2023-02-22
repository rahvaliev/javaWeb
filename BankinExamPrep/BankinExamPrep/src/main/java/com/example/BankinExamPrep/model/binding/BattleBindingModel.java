package com.example.BankinExamPrep.model.binding;

import jakarta.validation.constraints.Positive;

public class BattleBindingModel {
    private Long attackerId;
    private Long defenderId;
    @Positive
    public Long getAttackerId() {
        return attackerId;
    }

    public BattleBindingModel setAttackerId(Long attackerId) {
        this.attackerId = attackerId;
        return this;
    }
    @Positive
    public Long getDefenderId() {
        return defenderId;
    }

    public BattleBindingModel setDefenderId(Long defenderId) {
        this.defenderId = defenderId;
        return this;
    }
}
