package org.geekbang.time.pattern.interpreter.usage;

import java.util.Map;

public interface Expression {

    boolean interpret(Map<String, Long> stats);

}
