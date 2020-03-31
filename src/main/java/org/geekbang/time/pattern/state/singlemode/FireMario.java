package org.geekbang.time.pattern.state.singlemode;

import org.geekbang.time.pattern.state.branch.State;

public class FireMario implements IMario {

    private static final FireMario instance = new FireMario();

    private FireMario() {
    }

    @Override
    public State getName() {
        return State.FIRE;
    }

    @Override
    public void meetMonster(MarioStateMachine stateMachine) {
        stateMachine.setCurrentState(SmallMario.getInstance());
        stateMachine.setScore(stateMachine.getScore() - 300);
    }

    public static FireMario getInstance() {
        return instance;
    }

}
