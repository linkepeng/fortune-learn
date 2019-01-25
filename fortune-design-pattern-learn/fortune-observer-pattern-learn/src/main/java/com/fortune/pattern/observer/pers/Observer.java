package com.fortune.pattern.observer.pers;

/**
 * @author pinker.lin
 * @version V1.0
 * @date Created In 11:36 2019/1/25
 */
public abstract class Observer {
    protected PersSubject subject;
    public abstract void update(String personIds);
}
