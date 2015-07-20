package UI_SHOP;

/**
 * Created by rabota on 19.07.15.
 */
public class Launcher {
    public static void main(String[] args) {
        BirdsShop birdsShop = new BirdsShop();
        BirdsShopUI ui = new BirdsShopUI(birdsShop);
    }
}
