package org.geekbang.time.pattern.adapter.usage.encapsulation;

public class ParamsWrapperDefinition {

    private int paramA;
    private int paramB;

    public ParamsWrapperDefinition(int paramA, int paramB) {
        this.paramA = paramA;
        this.paramB = paramB;
    }

    public int getParamA() {
        return paramA;
    }

    public int getParamB() {
        return paramB;
    }

}
