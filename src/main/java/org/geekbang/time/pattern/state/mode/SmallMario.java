package org.geekbang.time.pattern.state.mode;

import org.geekbang.time.pattern.state.branch.State;

public class SmallMario implements IMario {

    private MarioStateMachine stateMachine;

    public SmallMario(MarioStateMachine marioStateMachine) {
        this.stateMachine = marioStateMachine;
    }

    @Override
    public State getName() {
        return State.SMALL;
    }

    @Override
    public void obtainMushRoom() {
        stateMachine.setCurrentState(new SuperMario(stateMachine));
        stateMachine.setScore(stateMachine.getScore() + 100);
    }

    @Override
    public void obtainCape() {
        stateMachine.setCurrentState(new CapeMario(stateMachine));
        stateMachine.setScore(stateMachine.getScore() + 200);
    }

    @Override
    public void obtainFireFlower() {
        stateMachine.setCurrentState(new FireMario(stateMachine));
        stateMachine.setScore(stateMachine.getScore() + 300);
    }

}
