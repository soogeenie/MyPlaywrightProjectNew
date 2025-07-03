package demostoreTestProject.tests;

import org.junit.jupiter.api.Test;

public class ProductPageTests extends BaseTest {
    @Test
    public void verifyAddToCartBtnIsVisible() {
        home.clickProduct("Samsung galaxy s6");  // returns product page
        page.pause();
        product.verifyAddToCartIsVisible();
    }
}
