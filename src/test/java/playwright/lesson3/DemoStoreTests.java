package playwright.lesson3;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class DemoStoreTests {
    private PlaywrightTestSetup setup;
    private Page page;

    @BeforeEach
    public void setUp() {
        setup = new PlaywrightTestSetup();
        setup.setup();
        page = setup.getPage();
    }

    @AfterEach
    public void tearDown() {
        setup.tearDown();
    }

    @Test
    public void headerTest() {
        Locator headerLocator = page.locator("#nava");
        // Verify the header text
        assertThat(headerLocator).containsText("PRODUCT");
    }
}
