package demostoreTestProject.utils;

import com.microsoft.playwright.*;

public class PlaywrightTestSetup {
    private Playwright playwright;
    private Browser browser;
    private BrowserContext context;
    private Page page;

    public PlaywrightTestSetup setup(String browserType) {
        playwright = Playwright.create();
        BrowserType bt;
        switch (browserType.toLowerCase()) {
            case "firefox": bt = playwright.firefox(); break;
            case "webkit": bt = playwright.webkit(); break;
            default: bt = playwright.chromium();
        }
        browser = bt.launch(new BrowserType.LaunchOptions()
                .setHeadless(Boolean.valueOf(System.getProperty("headless", "false"))));
        page = browser.newContext(new Browser.NewContextOptions()
                .setViewportSize(1920, 1080)).newPage();
        return this;
    }
    public Page getPage(){return this.page;}

    public void tearDown() {
        browser.close();
        playwright.close();
    }
}
