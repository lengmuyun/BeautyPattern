package org.geekbang.time.pattern.interpreter;

public class MultiplicationExpression extends AbstractExpression {

    public MultiplicationExpression(Expression exp1, Expression exp2) {
        super(exp1, exp2);
    }

    @Override
    public long interpret() {
        return exp1.interpret() * exp2.interpret();
    }

}
