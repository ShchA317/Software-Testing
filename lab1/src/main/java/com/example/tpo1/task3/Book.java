package com.example.tpo1.task3;

import java.util.List;

public class Book extends Thing {
    private final static List<KindOfAction> kindOfActionList =
            List.of(KindOfAction.TAKE, KindOfAction.OPEN, KindOfAction.CLOSE);

    @Override
    public List<KindOfAction> getKindOfActionList() {
        return kindOfActionList;
    }
}
