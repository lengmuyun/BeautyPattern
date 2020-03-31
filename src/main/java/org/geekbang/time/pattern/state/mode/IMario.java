package org.geekbang.time.pattern.state.mode;

import org.geekbang.time.pattern.state.branch.State;

/**
 * 所有状态类的接口
 */
public interface IMario {

    State getName();

    //以下是定义的事件
    default void obtainMushRoom() {}

    default void obtainCape() {}

    default void obtainFireFlower() {}

    default void meetMonster() {}

}
