package singleton;

public class DuckShop {
    public static void main(String[] args) {
        // Duck duck1 = new Duck();
        // Duck duck2 = new Duck();

        Duck _duck1 = Duck.getInstance();
        Duck _duck2 = Duck.getInstance();
        System.out.println(_duck1.equals(_duck2));  // true

    }
}
