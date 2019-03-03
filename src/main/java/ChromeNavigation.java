import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class ChromeNavigation {

    @AndroidFindBy(id = "com.android.chrome:id/terms_accept")
    private MobileElement acceptAndContinueChromeButton;

    @AndroidFindBy(id = "com.android.chrome:id/negative_button")
    private MobileElement noThanksButton;

    @AndroidFindBy(id = "com.android.chrome:id/menu_button")
    private MobileElement menuButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='New incognito tab']")
    private MobileElement newIncornitoTab;

    @AndroidFindBy(id = "com.android.chrome:id/url_bar")
    private MobileElement urlBar;

    public ChromeNavigation(final AppiumDriver appiumDriver) {
        appiumDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
    }

    public void hideWelcomeToChrome() {
        acceptAndContinueChromeButton.click();
        noThanksButton.click();
    }

    public void typeAddress(final String link) {
        menuButton.click();
        newIncornitoTab.click();
        urlBar.sendKeys(link + "\n");
    }
}
