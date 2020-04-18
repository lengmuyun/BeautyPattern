package org.geekbang.time.pattern.interpreter.usage;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class AlertRuleInterpreterTest {

    @Test
    public void test() {
        String rule = "key1 > 100 && key2 < 30 || key3 < 100 || key4 == 88";
        AlertRuleInterpreter interpreter = new AlertRuleInterpreter(rule);
        Map<String, Long> stats = new HashMap<>();
        stats.put("key1", 101l);
        stats.put("key3", 121l);
        stats.put("key4", 88l);
        boolean alert = interpreter.interpret(stats);
        System.out.println(alert);
    }

}