package com.example.tpo1.task3;

import java.util.List;

public abstract class Thing implements TargetOfAction {
    protected final static List<KindOfAction> kindOfActionList = List.of(KindOfAction.TAKE);

    @Override
    public List<KindOfAction> getKindOfActionList() {
        return kindOfActionList;
    }
}
