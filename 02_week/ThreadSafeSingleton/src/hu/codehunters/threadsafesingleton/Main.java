package hu.codehunters.threadsafesingleton;

import java.util.concurrent.atomic.AtomicReference;

public class Main {

    AtomicReference<Test> atomic = new AtomicReference<>();

    public void run(){
    }
}
