package org.geekbang.time.pattern.state.singlemode;

import org.geekbang.time.pattern.state.branch.State;

public class SuperMario implements IMario {

    private static final SuperMario instance = new SuperMario();

    private SuperMario() {
    }

    @Override
    public State getName() {
        return State.SUPER;
    }

    @Override
    public void obtainCape(MarioStateMachine stateMachine) {
        stateMachine.setCurrentState(CapeMario.getInstance());
        stateMachine.setScore(stateMachine.getScore() + 200);
    }

    @Override
    public void obtainFireFlower(MarioStateMachine stateMachine) {
        stateMachine.setCurrentState(FireMario.getInstance());
        stateMachine.setScore(stateMachine.getScore() + 300);
    }

    @Override
    public void meetMonster(MarioStateMachine stateMachine) {
        stateMachine.setCurrentState(SmallMario.getInstance());
        stateMachine.setScore(stateMachine.getScore() - 100);
    }

    public static SuperMario getInstance() {
        return instance;
    }

}
