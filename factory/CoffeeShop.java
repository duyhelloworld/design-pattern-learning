package factory;

public class CoffeeShop {
    public static void main(String[] args) {
        Coffee capucino = CoffeeFactory.getCoffee(CoffeeType.CAPUCINO);
        System.out.println("Get Object : " + capucino.getCoffeeName());

        Coffee espressino = CoffeeFactory.getCoffee(CoffeeType.ESPRESSINO);
        System.out.println("Get Object : " + espressino.getCoffeeName());

        Coffee americano = CoffeeFactory.getCoffee(CoffeeType.AMERICANO);
        System.out.println("Get Object : " + americano.getCoffeeName());
    }
}
