package demostoreTestProject.tests;

import org.junit.jupiter.api.Test;

public class HomePageTests extends BaseTest{
    @Test
    public void headerTest() {
        home.verifyHeaderContains("PRODUCT STORE");
    }
}
