package org.geekbang.time.pattern.state.mode;

import org.geekbang.time.pattern.state.branch.State;

public class FireMario implements IMario {

    private MarioStateMachine stateMachine;

    public FireMario(MarioStateMachine stateMachine) {
        this.stateMachine = stateMachine;
    }

    @Override
    public State getName() {
        return State.FIRE;
    }

    @Override
    public void meetMonster() {
        stateMachine.setCurrentState(new SmallMario(stateMachine));
        stateMachine.setScore(stateMachine.getScore() - 300);
    }

}
