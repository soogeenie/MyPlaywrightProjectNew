package playwrightLessons.lesson2;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

import java.nio.file.Paths;
import java.util.Arrays;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class FirstPlaywrightTestWithTrace {
    public static void main(String[] args) {
        // Initialize Playwright and launch the browser
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                .setHeadless(false)
                .setArgs(Arrays.asList("--start-maximized")));
        BrowserContext context = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));

        // Start tracing with screenshots and DOM snapshots
        context.tracing().start(new Tracing.StartOptions()
                .setScreenshots(true)
                .setSnapshots(true));

        // Create a new page and navigate to the website
        Page page = context.newPage();
        page.navigate("https://demoblaze.com/");

        // Locate the element by ID
        Locator headerLocator = page.locator("#nava");

        // Verify the header text
        assertThat(headerLocator).containsText("PRODUCT");

        //click "Samsung galaxy s6" and verify the btn "Add to cart"
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Samsung galaxy s6")).click();

        // Verify btn text
        Locator addToCartBtnLocator = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Add to cart"));
        assertThat(addToCartBtnLocator).hasText("Add to cart");

        // Stop tracing and save the trace to a file
        context.tracing().stop(new Tracing.StopOptions()
                .setPath(Paths.get("trace.zip")));

        // Close the page and browser
        page.close();
        browser.close();

        // Dispose of Playwright instance
        playwright.close();
    }
}
