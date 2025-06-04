package playwright.lesson1;

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
        context.setDefaultTimeout(5000);

        // Start tracing with screenshots and DOM snapshots
        context.tracing().start(new Tracing.StartOptions()
                .setScreenshots(true)
                .setSnapshots(true));

        // Create a new page and navigate to the website
        Page page = context.newPage();
        page.navigate("https://demoblaze.com/");

        // Locate the element by ID
        Locator headerLocator = page.locator("#nava");

        // Wait for the element to be visible
        headerLocator.waitFor(new Locator.WaitForOptions().setTimeout(5000));

        // Verify the header text
        String headerText = headerLocator.textContent();
        System.out.println("Header Text: " + headerText);

        // Assert the header text
        if (headerText.trim().equals("PRODUCT STORE")) {
            System.out.println("Header verification passed.");
        } else {
            System.out.println("Header verification failed.");
        }

        assertThat(headerLocator).hasText("PRODUCT STORE");
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Samsung galaxy s6")).click();
//        page.onceDialog(dialog -> {
//                    System.out.println(String.format("Dialog message: %s", dialog.message()));
//                    dialog.dismiss();
//                });
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Add to cart")).click();
//        page.onceDialog(dialog -> {
//                    System.out.println(String.format("Dialog message: %s", dialog.message()));
//                    dialog.dismiss();
//                });
//              // Stop tracing and save the trace to a file
        context.tracing().stop(new Tracing.StopOptions()
                .setPath(Paths.get("trace.zip")));

        // Close the page and browser
        page.close();
        browser.close();

        // Dispose of Playwright instance
        playwright.close();
    }
}
