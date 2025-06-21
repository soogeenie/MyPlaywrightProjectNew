package playwrightLessons.lesson4;

import com.microsoft.playwright.Page;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest {
    PlaywrightTestSetup setup;
    Page page;

    @BeforeEach
    public void setUp() {
       setup = new PlaywrightTestSetup().setup();
       page = setup.getPage();
       page.navigate("https://www.homefires.com.au/");
    }

    @AfterEach
    public void tearDown() {
        setup.tearDown();
    }
}
