package hu.codehunters.threadsafesingleton;

public class SingletonLazy2 {

    private static SingletonLazy2 singletonLazy = null;

    private SingletonLazy2() {
        if (singletonLazy != null) {
            throw new IllegalStateException("SingletonLazy2 already created!");
        }
    }

    public static SingletonLazy2 getInstance() {
        if (singletonLazy == null) {
            synchronized (SingletonLazy2.class) {
                if (singletonLazy == null) {
                    singletonLazy = new SingletonLazy2();
                }
            }
        }
        return singletonLazy;
    }
}
