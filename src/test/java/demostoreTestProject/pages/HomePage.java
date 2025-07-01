package demostoreTestProject.pages;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class HomePage extends BasePage {
    private final Locator header = page.locator("#nava");

    public HomePage(Page page) {
        super(page);
    }

    public void verifyHeaderContains(String text) {
        assertThat(header).containsText(text);
    }

    public ProductPage clickProduct(String productName) {
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(productName)).click();
        return new ProductPage(page);
    }
}
