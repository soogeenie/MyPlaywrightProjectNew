package playwright.lesson1;

import com.microsoft.playwright.*;

public class FirstPlaywrightTest {
    public static void main(String[] args) {
//        added comment
            Playwright playwright = Playwright.create();
            Browser browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
            Page page = browser.newPage();
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
        // Close the page and browser
        page.close();
        browser.close();

        // Dispose of Playwright instance
        playwright.close();
    }
}