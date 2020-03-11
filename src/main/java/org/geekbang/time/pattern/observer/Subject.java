package org.geekbang.time.pattern.observer;

/**
 * 被观察者
 */
public interface Subject {

    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers(Message message);

}
