package factory;

public class CoffeeFactory {
    private CoffeeFactory() {};

    public static Coffee getCoffee(CoffeeType coffeeType){
        switch (coffeeType) {
            case AMERICANO:
                return new Americano();
            case ESPRESSINO:
                return new Espressino();
            case CAPUCINO:
                return new Capucino();
            default:
                throw new IllegalArgumentException("Error, we don't supply this coffee type");
        }
    }
}
