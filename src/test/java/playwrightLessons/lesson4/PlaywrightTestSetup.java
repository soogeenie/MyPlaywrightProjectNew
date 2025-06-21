package playwrightLessons.lesson4;

import com.microsoft.playwright.*;

import java.util.Arrays;

public class PlaywrightTestSetup {
    private Playwright playwright;
    private Browser browser;
    private BrowserContext context;
    private Page page;

    public PlaywrightTestSetup setup() {
        this.playwright = Playwright.create();
        this.browser = this.playwright.chromium().launch(new BrowserType.LaunchOptions()
                .setHeadless(false)
                .setArgs(Arrays.asList("--start-maximized")));
        this.context = this.browser.newContext(new Browser.NewContextOptions()
                .setViewportSize(null));
        this.page = this.context.newPage();
        return this;
    }
    public Page getPage(){return this.page;}

    public void tearDown() {
        this.browser.close();
        this.playwright.close();
    }

}
