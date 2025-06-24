package playwrightLessons.lesson3;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class DemoStoreHeaderRaw2Test {
    Playwright playwright;
    Browser browser;
    BrowserContext context;
    Page page;

    @BeforeEach
    public void setup() {
        // Initialize Playwright and launch the browser
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                .setHeadless(true)
                .setArgs(Arrays.asList("--start-maximized")));
        context = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));

        // Create a new page and navigate to the website
        page = context.newPage();
        page.navigate("https://demoblaze.com/");
    }

    @Test
    public void demostoreHeaderTest() {
        // Locate the element by ID
        Locator headerLocator = page.locator("#nava");
        // Verify the header text
        assertThat(headerLocator).containsText("PRODUCT");
    }

    @Test
    public void checkAddToCartBtnTest() {
        //click "Samsung galaxy s6" and verify the btn "Add to cart"
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Samsung galaxy s6")).click();

        // Verify btn text
        Locator addToCartBtnLocator = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Add to cart"));
        assertThat(addToCartBtnLocator).hasText("Add to cart");
    }

    @Test
    public void checkTotalInCartTest() {
        //click "Samsung galaxy s6" and verify the btn "Add to cart"
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Samsung galaxy s6")).click();
        // Verify btn text
        Locator addToCartBtnLocator = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Add to cart"));
        addToCartBtnLocator.click();
        //Click on Cart menu
        Locator cart = page.locator("#cartur");
        cart.click();
        //Assert the total value
        assertThat(page.locator("#totalp")).hasText("360");
    }

    @AfterEach
    public void tearDown() {
        // Close the page and browser
        page.close();
        browser.close();
        // Dispose of Playwright instance
        playwright.close();
    }
}
