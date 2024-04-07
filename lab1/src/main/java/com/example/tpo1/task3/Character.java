package com.example.tpo1.task3;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Character implements Actor, TargetOfAction {
    private String name;
    private List<KindOfAction> kindOfActionList;

    @Override
    public List<KindOfAction> getKindOfActionList() {
        return kindOfActionList;
    }
}
