package org.geekbang.time.pattern.state.singlemode;

import org.geekbang.time.pattern.state.branch.State;

public class CapeMario implements IMario {

    private static final CapeMario instance = new CapeMario();

    private CapeMario() {
    }

    @Override
    public State getName() {
        return State.CAPE;
    }

    @Override
    public void meetMonster(MarioStateMachine stateMachine) {
        stateMachine.setCurrentState(SmallMario.getInstance());
        stateMachine.setScore(stateMachine.getScore() - 200);
    }

    public static CapeMario getInstance() {
        return instance;
    }

}
