public class Shop {
    public static void main(String[] args) {
        ShopFacade shopFacade = ShopFacade.getInstance();

        shopFacade.buyByCashingWithExpressShip("mailtruong@huce.edu.vn", "012345678");
        
        System.out.println();
        shopFacade.buyByPayPalWithFreeShip("email@email");
    }
}
