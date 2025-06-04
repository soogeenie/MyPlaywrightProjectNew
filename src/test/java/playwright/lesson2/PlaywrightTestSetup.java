package playwright.lesson2;

import com.microsoft.playwright.*;

import java.nio.file.Paths;
import java.util.Arrays;

public class PlaywrightTestSetup {
    private Playwright playwright;
    private Browser browser;
    private BrowserContext context;

    public void setup() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                .setHeadless(false)
                .setArgs(Arrays.asList("--start-maximized")));
        context = browser.newContext(new Browser.NewContextOptions()
                .setViewportSize(1280, 720));
        context.setDefaultTimeout(5000);

        context.tracing().start(new Tracing.StartOptions()
                .setScreenshots(true)
                .setSnapshots(true));
    }

    public void tearDown() {
        context.tracing().stop(new Tracing.StopOptions()
                .setPath(Paths.get("trace.zip")));
        browser.close();
        playwright.close();
    }

    public BrowserContext getContext() {
        return context;
    }

    public Browser getBrowser() {
        return browser;
    }

    public Playwright getPlaywright() {
        return playwright;
    }
}
