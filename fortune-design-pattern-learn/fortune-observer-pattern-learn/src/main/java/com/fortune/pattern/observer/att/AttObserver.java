package com.fortune.pattern.observer.att;

import com.fortune.pattern.observer.pers.Observer;
import com.fortune.pattern.observer.pers.PersSubject;

/**
 * @author pinker.lin
 * @version V1.0
 * @date Created In 11:40 2019/1/25
 */
public class AttObserver extends Observer {

    public AttObserver(PersSubject subject){
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update(String personIds) {

    }

    public static void main(String[] args){
        PersSubject persSubject = new PersSubject();
        AttObserver attObserver = new AttObserver(persSubject);
    }
}
