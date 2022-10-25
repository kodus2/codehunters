package hu.codehunters.threadsafesingleton;

public class SingletonLazy1 {

    private static SingletonLazy1 singletonLazy = null;

    private SingletonLazy1() {
    }

    public static synchronized SingletonLazy1 getInstance() {
        if (singletonLazy == null) {
            singletonLazy = new SingletonLazy1();
        }
        return singletonLazy;
    }
}
