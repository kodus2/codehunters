package hu.codehunters.observerpattern;

public interface Observer {

    public void subscribe();
    public void unSubscribe();
    public void update(String notification);
}
