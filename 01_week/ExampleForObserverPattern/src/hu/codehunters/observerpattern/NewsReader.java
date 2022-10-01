package hu.codehunters.observerpattern;

public class NewsReader implements Observer {

    private final Subject subject;
    private String notification;

    public NewsReader(Subject subject) {
        this.subject = subject;
    }

    @Override
    public void subscribe() {
        this.subject.subscribeObserver(this);
        System.out.println("User subscribed to news.");
    }

    @Override
    public void unSubscribe() {
        this.subject.unSubscribeObserver(this);
        System.out.println("User unsubscribed from news.");
    }

    @Override
    public void update(String notification) {
        this.notification = notification;
        System.out.println("User get the notification: " + notification);
    }
}
