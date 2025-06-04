package playwright.lesson2;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.junit.jupiter.api.*;


public class DemoStoreTests {
        private PlaywrightTestSetup setup;

        @BeforeEach
        public void setUp() {
            setup = new PlaywrightTestSetup();
            setup.setup();
        }

        @AfterEach
        public void tearDown() {
            setup.tearDown();
        }

        @Test
        public void headerTest() {
            BrowserContext context = setup.getContext();
            Page page = setup.getBrowser().newPage();
            page.navigate("https://demoblaze.com/");
            Locator headerLocator = page.locator("#nava");

            // Wait for the element to be visible
            headerLocator.waitFor(new Locator.WaitForOptions().setTimeout(5000));
            page.pause();
            // Verify the header text
            String headerText = headerLocator.textContent();
            System.out.println("Header Text: " + headerText);

            // Assert the header text
            if (headerText.trim().equals("PRODUCT STORE")) {
                System.out.println("Header verification passed.");
            } else {
                System.out.println("Header verification failed.");
            }
        }
    }
