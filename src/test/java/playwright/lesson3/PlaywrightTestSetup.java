package playwright.lesson3;

import com.microsoft.playwright.*;

import java.nio.file.Paths;
import java.util.Arrays;

public class PlaywrightTestSetup {
    private Playwright playwright;
    private Browser browser;
    private BrowserContext context;
    private Page page;


    public Browser getBrowser() {
        return browser;
    }
    public Page getPage() {
        return page;
    }

    public void setup() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                .setHeadless(false)
                .setArgs(Arrays.asList("--start-maximized")));
        context = browser.newContext(new Browser.NewContextOptions()
                .setViewportSize(null));

        context.tracing().start(new Tracing.StartOptions()
                .setScreenshots(true)
                .setSnapshots(true));

        page = getBrowser().newPage();
        page.navigate("https://demoblaze.com/");
    }

    public void tearDown() {
        context.tracing().stop(new Tracing.StopOptions()
                .setPath(Paths.get("trace.zip")));
        browser.close();
        playwright.close();
    }

}
