package org.geekbang.time.pattern.interpreter;

public abstract class AbstractExpression implements Expression {

    protected Expression exp1;
    protected Expression exp2;

    public AbstractExpression(Expression exp1, Expression exp2) {
        this.exp1 = exp1;
        this.exp2 = exp2;
    }

}
