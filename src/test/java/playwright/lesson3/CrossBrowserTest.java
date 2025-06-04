package playwright.lesson3;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

public class CrossBrowserTest {

    private Playwright playwright;
    private Browser browser;
    private Page page;

    void setup(String browserType) {
        playwright = Playwright.create();
        switch (browserType) {
            case "firefox":
                browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(true));
                break;
            case "webkit":
                browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(true));
                break;
            case "chromium":
            default:
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(true));
                break;
        }
        page = browser.newPage();
    }

    @AfterEach
    void teardown() {
        if (page != null) {
            page.close();
        }
        if (browser != null) {
            browser.close();
        }
        if (playwright != null) {
            playwright.close();
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"chromium", "firefox", "webkit"})
    void testHeaderText(String browserType) {
        setup(browserType);  // call setup with parameter here

        page.navigate("https://demoblaze.com/");
        Locator headerLocator = page.locator("#nava");
        headerLocator.waitFor(new Locator.WaitForOptions().setTimeout(5000));
        String headerText = headerLocator.textContent();
        page.pause();
        Assertions.assertEquals("PRODUCT STORE", headerText.trim());
    }
}
