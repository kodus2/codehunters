package hu.codehunters.observerpattern;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        Subject subject = new News(new ArrayList<Observer>());
        Observer observer = new NewsReader(subject);
        observer.subscribe();

        Reporter reporter = (Reporter) subject;
        reporter.setNotification("A monkey has born.");
        reporter.setNotification("Béla has won the lotto.");

        observer.unSubscribe();

        reporter.setNotification("Metro 3 building is finished");



    }
}