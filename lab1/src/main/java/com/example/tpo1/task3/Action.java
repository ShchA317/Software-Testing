package com.example.tpo1.task3;

import lombok.Getter;

import java.util.List;

@Getter
public class Action {
    private Stage stage;
    private final ActionType actionType;
    private final Actor actor;
    private List<TargetOfAction> listOfTargets;

    public Action(ActionType actionType, Actor actor){
        stage = Stage.NEW;
        this.actionType = actionType;
        this.actor = actor;
    }

    public Action(ActionType actionType, Actor actor, List<TargetOfAction> listOfTargets){
        stage = Stage.NEW;
        this.actionType = actionType;
        this.actor = actor;
        this.listOfTargets = listOfTargets;
    }

    public void start(){
        if (stage != Stage.NEW){
            throw new ActionStageException("Stage of this action != NEW");
        }
        stage = Stage.STARTED;
    }

    public void end(){
        if (stage != Stage.STARTED){
            throw new ActionStageException("Stage of this action != STARTED");
        }
        stage = Stage.ENDED;
    }
}
