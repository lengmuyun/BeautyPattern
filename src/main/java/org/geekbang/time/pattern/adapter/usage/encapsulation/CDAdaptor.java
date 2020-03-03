package org.geekbang.time.pattern.adapter.usage.encapsulation;

public class CDAdaptor extends CD implements ITarget {

    @Override
    public void function1() {
        staticFunction1();
    }

    @Override
    public void function2() {
        uglgNamingFunction2();
    }

    @Override
    public void function3(ParamsWrapperDefinition paramsWrapper) {
        tooManyParamsFunction3(paramsWrapper.getParamA(), paramsWrapper.getParamB());
    }

    @Override
    public void function4() {
        // reimplement it
    }

}
