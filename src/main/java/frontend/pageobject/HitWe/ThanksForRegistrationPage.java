package frontend.pageobject.HitWe;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class ThanksForRegistrationPage {

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Симпатии']")
    private MobileElement firstMenuButton;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Сообщения']")
    private MobileElement secondMenuButton;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Посетители']")
    private MobileElement fifthMenuButton;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Да']")
    private MobileElement acceptButtonNotifications;

    private AppiumDriver appiumDriver;

    public ThanksForRegistrationPage(final AppiumDriver appiumDriver) {
        this.appiumDriver = appiumDriver;
        appiumDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
    }

    public void acceptNotofications() {
        firstMenuButton.click();
        secondMenuButton.click();
        fifthMenuButton.click();
        firstMenuButton.click();
        acceptButtonNotifications.click();

    }
}

