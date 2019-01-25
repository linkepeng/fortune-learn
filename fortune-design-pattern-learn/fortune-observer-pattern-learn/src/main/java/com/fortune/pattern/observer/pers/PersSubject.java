package com.fortune.pattern.observer.pers;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pinker.lin
 * @version V1.0
 * @date Created In 11:35 2019/1/25
 */
public class PersSubject {

    private List<Observer> observers
            = new ArrayList<Observer>();

    private String personId;

    public String getPersonId() {
        return personId;
    }

    public void setState(String personId) {
        this.personId = personId;
        notifyAllObservers(personId);
    }

    public void attach(Observer observer){
        observers.add(observer);
    }

    public void notifyAllObservers(String personId){
        for (Observer observer : observers) {
            observer.update(personId);
        }
    }
}
