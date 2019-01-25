package com.fortune.pattern.observer.pers;

/**
 * @author pinker.lin
 * @version V1.0
 * @date Created In 11:44 2019/1/25
 */
public class ObserverTest {

    public static void main(String[] args){
        PersSubject persSubject = new PersSubject();
        String personId = "helloworld!";
        persSubject.notifyAllObservers(personId);
    }
}
