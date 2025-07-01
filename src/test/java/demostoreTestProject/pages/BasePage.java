package demostoreTestProject.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public abstract class BasePage {
    protected final Page page;

    public BasePage(Page page) {
        this.page = page;
    }

    public CartPage openCart() {
        page.locator("#cartur").click();
        return new CartPage(page);
    }

    public String getTitle() {
        return page.title();
    }
}