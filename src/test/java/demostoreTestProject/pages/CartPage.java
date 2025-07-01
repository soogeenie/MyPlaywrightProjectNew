package demostoreTestProject.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class CartPage extends BasePage {
    private final Locator totalPrice = page.locator("#totalp");

    public CartPage(Page page) {
        super(page);
    }

    public CartPage verifyTotalPrice(String expected) {
        assertThat(totalPrice).hasText(expected);
        return this;
    }

    public CartPage deleteFirstProduct() {
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Delete")).first().click();
        return new CartPage(page);
    }
}
