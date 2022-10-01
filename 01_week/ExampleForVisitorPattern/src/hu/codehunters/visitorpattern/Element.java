package hu.codehunters.visitorpattern;

public interface Element {
    public void accept(Visitor visitor);
}
