package singleton;

public class Duck {
    private static Duck instance;

    private Duck() {
    }

    public static Duck getInstance() {
        if (instance == null) {
            instance = new Duck();
        }
        return instance;
    }
    // other methods
}