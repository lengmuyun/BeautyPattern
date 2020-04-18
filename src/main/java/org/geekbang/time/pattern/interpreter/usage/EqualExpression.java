package org.geekbang.time.pattern.interpreter.usage;

import java.util.Map;

public class EqualExpression implements Expression {

    private String key;
    private long value;

    public EqualExpression(String key, long value) {
        this.key = key;
        this.value = value;
    }

    public EqualExpression(String strExpression) {
        String[] elements = strExpression.trim().split("\\s+");
        if (elements.length != 3 || !elements[1].trim().equals("==")) {
            throw new RuntimeException("Expression is invalid: " + strExpression);
        }
        this.key = elements[0].trim();
        this.value = Long.parseLong(elements[2].trim());
    }

    @Override
    public boolean interpret(Map<String, Long> stats) {
        if (!stats.containsKey(key)) {
            return false;
        }
        Long statValue = stats.get(key);
        return statValue == value;
    }
}
