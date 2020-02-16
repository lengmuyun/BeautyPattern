package org.geekbang.time.pattern.factory.dependency;

import java.util.ArrayList;
import java.util.List;

public class BeanDefinition {

    private String id;
    private String className;
    private List<ConstructorArg> constructorArgs = new ArrayList<>();
    private Scope scope = Scope.SINGLETON;
    private boolean lazyInit = false;

    public boolean isSingleton() {
        return scope.equals(Scope.SINGLETON);
    }

    public enum Scope {
        SINGLETON
    }

}
