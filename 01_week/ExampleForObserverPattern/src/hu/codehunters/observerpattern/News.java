package hu.codehunters.observerpattern;

import java.util.List;

public class News implements Subject, Reporter{

    private final List<Observer> observers;
    private String notification;

    public News(List<Observer> observers) {
        this.observers = observers;
    }

    @Override
    public void subscribeObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void unSubscribeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        System.out.println();
        observers.forEach(observer -> observer.update(notification));
    }

    public void setNotification(String notification) {
        this.notification = notification;
        notifyObservers();
    }
}
