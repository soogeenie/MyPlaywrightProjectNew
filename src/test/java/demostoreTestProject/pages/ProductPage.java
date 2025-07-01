package demostoreTestProject.pages;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class ProductPage extends BasePage {
    private final Locator addToCartBtn = page.getByRole(AriaRole.LINK,
            new Page.GetByRoleOptions().setName("Add to cart"));

    public ProductPage(Page page) {
        super(page);
    }

    public ProductPage verifyAddToCartIsVisible() {
        assertThat(addToCartBtn).isVisible();
        return this;
    }

    public ProductPage addToCart() {
        addToCartBtn.click();
        return new ProductPage(page);
    }
}