package org.geekbang.time.pattern.interpreter;

import java.util.Deque;
import java.util.LinkedList;

public class ExpressionInterpreter {

    private Deque<Expression> numbers = new LinkedList<>();

    public long interpret(String expression) {
        String[] elements = expression.split(" ");
        int length = elements.length;
        for (int i=0; i<(length + 1)/2; ++i) {
            numbers.addLast(new NumberExpression(elements[i]));
        }

        for (int i=(length + 1)/2; i<length; ++i) {
            String operator = elements[i];
            checkOperator(expression, operator);

            Expression exp1 = numbers.pollFirst();
            Expression exp2 = numbers.pollFirst();
            Expression operatorExp = null;
            if (operator.equals("+")) {
                operatorExp = new AdditionExpression(exp1, exp2);
            } else if (operator.equals("-")) {
                operatorExp = new SubstractionExpression(exp1, exp2);
            } else if (operator.equals("*")) {
                operatorExp = new MultiplicationExpression(exp1, exp2);
            } else if (operator.equals("/")) {
                operatorExp = new DivisionExpression(exp1, exp2);
            }
            long result = operatorExp.interpret();
            numbers.addFirst(new NumberExpression(result));
        }

        if (numbers.size() != 1) {
            throw new RuntimeException("Expression is invalid: " + expression);
        }
        return numbers.pop().interpret();
    }

    private void checkOperator(String expression, String operator) {
        boolean isValid = "+".equals(operator) || "-".equals(operator)
                || "*".equals(operator) || "/".equals(operator);
        if (!isValid) {
            throw new RuntimeException("Expression is invalid: " + expression);
        }
    }

}
