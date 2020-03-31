package org.geekbang.time.pattern.state.singlemode;

import org.geekbang.time.pattern.state.branch.State;

/**
 * 所有状态类的接口
 */
public interface IMario {

    State getName();

    //以下是定义的事件
    default void obtainMushRoom(MarioStateMachine stateMachine) {}

    default void obtainCape(MarioStateMachine stateMachine) {}

    default void obtainFireFlower(MarioStateMachine stateMachine) {}

    default void meetMonster(MarioStateMachine stateMachine) {}

}
