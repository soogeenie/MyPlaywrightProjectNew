package demostoreTestProject.utils;

import com.microsoft.playwright.*;

import java.util.Arrays;

public class PlaywrightTestSetup {
    private Playwright playwright;
    private Browser browser;
    private BrowserContext context;
    private Page page;

    public PlaywrightTestSetup setup() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                .setHeadless(Config.headless)
                .setArgs(Arrays.asList("--start-maximized")));
        page = browser.newContext(new Browser.NewContextOptions()
                .setViewportSize(null)).newPage();
        return this;
    }
    public Page getPage(){return this.page;}

    public void tearDown() {
        browser.close();
        playwright.close();
    }
}
