package com.example.tpo1.task3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ActionTests {

    @Test
    public void stagesOfActionTest(){
        Action action = new Action(ActionType.P2O, new Character());
        assertEquals(Stage.NEW, action.getStage());

        action.start();
        assertEquals(Stage.STARTED, action.getStage());

        action.end();
        assertEquals(Stage.ENDED, action.getStage());
    }

    @Test
    public void twiceStartTest(){
        Action action = new Action(ActionType.P2O, new Character());
        action.start();
        assertThrows(ActionStageException.class, action::start);
    }

    @Test
    public void startEndedTest(){
        Action action = new Action(ActionType.P2O, new Character());
        action.start();
        action.end();
        ActionStageException actionStageException = assertThrows(ActionStageException.class, action::start);
        assertEquals("Stage of this action != NEW", actionStageException.getMessage());
    }

    @Test
    public void endNotStartedTest(){
        Action action = new Action(ActionType.P2O, new Character());
        ActionStageException actionStageException = assertThrows(ActionStageException.class, action::end);
        assertEquals("Stage of this action != STARTED", actionStageException.getMessage());
    }

    @Test
    public void twiceEndTest(){
        Action action = new Action(ActionType.P2O, new Character());
        action.start();
        action.end();
        assertThrows(ActionStageException.class, action::end);
    }
}
