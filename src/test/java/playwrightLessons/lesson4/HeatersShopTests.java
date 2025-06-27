package playwrightLessons.lesson4;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class HeatersShopTests extends BaseTest {
    @Test
    public void searchByProductTest() {
        //Fill INPUT WITH TEXT "Regency Renmark Wood Heater"
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Search")).fill("Regency Renmark Wood Heater");
        //CLICK SEARCH
        page.locator(".searchsubmit").filter(new Locator.FilterOptions().setVisible(true)).click();
        //VERIFY LINK IS VISIBLE
        assertThat(page.getByText("Regency Renmark Wood Heater", new Page.GetByTextOptions().setExact(true)))
                .isVisible();
    }
}
