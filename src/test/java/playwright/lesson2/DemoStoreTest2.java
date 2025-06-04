package playwright.lesson2;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import java.util.*;

public class DemoStoreTest2 {

    public static void main(String[] args) {
//            try (Playwright playwright = Playwright.create()) {
//                Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
//                        .setHeadless(false));
//                BrowserContext context = browser.newContext();
//                page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("About us")).click();
//                page.locator("#videoModal").getByLabel("Close").click();
//                page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Samsung galaxy s6")).click();
//                page.onceDialog(dialog -> {
//                    System.out.println(String.format("Dialog message: %s", dialog.message()));
//                    dialog.dismiss();
//                });
//                page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Add to cart")).click();
//                page.onceDialog(dialog -> {
//                    System.out.println(String.format("Dialog message: %s", dialog.message()));
//                    dialog.dismiss();
//                });
//                page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Add to cart")).click();
//                page.onceDialog(dialog -> {
//                    System.out.println(String.format("Dialog message: %s", dialog.message()));
//                    dialog.dismiss();
//                });
//                page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Add to cart")).click();
//                page.onceDialog(dialog -> {
//                    System.out.println(String.format("Dialog message: %s", dialog.message()));
//                    dialog.dismiss();
//                });
//                page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Add to cart")).click();
//                page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Add to cart")).click(new Locator.ClickOptions()
//                        .setButton(MouseButton.RIGHT));
//                page.onceDialog(dialog -> {
//                    System.out.println(String.format("Dialog message: %s", dialog.message()));
//                    dialog.dismiss();
//                });
//                page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Add to cart")).click();
//                assertThat(page.locator("#tbodyid")).containsText("Add to cart");
//            }

    }
}
