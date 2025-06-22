package demostoreTestProject.tests;

import com.microsoft.playwright.Page;
import demostoreTestProject.pages.CartPage;
import demostoreTestProject.pages.HomePage;
import demostoreTestProject.pages.ProductPage;
import demostoreTestProject.utils.Config;
import demostoreTestProject.utils.PlaywrightTestSetup;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public abstract class BaseTest {
    PlaywrightTestSetup setup;
    Page page;
    HomePage home;
    ProductPage product;
    CartPage cart;


    @BeforeEach
    public void setUp() {
        String browser = System.getProperty("browser", "chromium");
        setup = new PlaywrightTestSetup().setup(browser);
        page = setup.getPage();
        page.navigate(Config.baseUrl);

        home = new HomePage(page);
        product = new ProductPage(page);
        cart = new CartPage(page);
    }

    @AfterEach
    public void tearDown() {
        setup.tearDown();
    }

    protected void addProductToCart(String productName){
        home.clickProduct(productName);  // returns product page
        product.addToCart();// returns product page
        product.openCart();// returns cart page
    }
}
