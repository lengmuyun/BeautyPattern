package org.geekbang.time.pattern.state;

import org.geekbang.time.pattern.state.branch.MarioStateMachine;
import org.geekbang.time.pattern.state.branch.State;

public class ApplicationDemo {

    public static void main(String[] args) {
        MarioStateMachine mario = new MarioStateMachine();
        mario.obtainMushRoom();
        int score = mario.getScore();
        State state = mario.getCurrentState();
        System.out.println("mario score: " + score + "; state: " + state);
    }

}
