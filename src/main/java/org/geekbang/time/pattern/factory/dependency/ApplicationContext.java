package org.geekbang.time.pattern.factory.dependency;

public interface ApplicationContext {

    Object getBean(String beanId);

}
