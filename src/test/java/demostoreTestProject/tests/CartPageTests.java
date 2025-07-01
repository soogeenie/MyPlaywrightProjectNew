package demostoreTestProject.tests;

import org.junit.jupiter.api.Test;

public class CartPageTests extends BaseTest {

    @Test
    public void verifyTotalPriceInCart() {
        addProductToCart("Samsung galaxy s6");
        cart.verifyTotalPrice("360");
    }
    @Test
    public void verifyDeleteFromCart() {
        addProductToCart("Samsung galaxy s6");
        cart.deleteFirstProduct().verifyTotalPrice("");
    }
}
