package frontend.pageobject.HitWe;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SignUpFormFromGirlsOrBoysPage {

    @AndroidFindBy(xpath = "//android.webkit.WebView[@content-desc='Hitwe – сайт встреч! Общение без ограничений']" +
            "/android.view.View/android.view.View[1]/android.view.View[3]/android.view.View[3]/android.view.View[1]" +
            "/android.widget.EditText")
    private MobileElement nameInput;

    @AndroidFindBy(xpath = "//android.webkit.WebView[@content-desc='Hitwe – сайт встреч! Общение без ограничений']" +
            "/android.view.View/android.view.View[1]/android.view.View[3]/android.view.View[3]/android.view.View[2]" +
            "/android.widget.EditText")
    private MobileElement emailInput;

    @AndroidFindBy(xpath = "//android.widget.Spinner[@content-desc='Кто вы']")
    private MobileElement whoAreYouPrompt;

    @AndroidFindBy(xpath = "//android.widget.Spinner[@content-desc='Возраст']")
    private MobileElement agePrompt;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout")
    private MobileElement agePopUp;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Зарегистрироваться']")
    private MobileElement signUpButton;

    private AppiumDriver appiumDriver;
    private static final String WHO_ARE_YOU_AND_AGE_PATH = "/hierarchy/android.widget.FrameLayout/android.widget." +
            "FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android." +
            "widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[%s]";

    public SignUpFormFromGirlsOrBoysPage(final AppiumDriver appiumDriver) {
        this.appiumDriver = appiumDriver;
        appiumDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
    }

    public ThanksForRegistrationPage enterSignUpValues(final String name, final String email, final String who, final Integer age) {
        enterYourName(name);
        enterEmail(email);
        selectWhoYouAre(who);
        selectAge(age);
        signUpButton.click();
        return new ThanksForRegistrationPage(appiumDriver);
    }

    public void enterYourName(final String name) {
        nameInput.sendKeys(name);
    }

    public void enterEmail(final String email) {
        emailInput.sendKeys(email);
    }

    public void selectWhoYouAre(final String who) {
        whoAreYouPrompt.click();
        final Integer num = 2;
        if (who.equals("Парень")) {
            appiumDriver.findElement(By.xpath(String.format(WHO_ARE_YOU_AND_AGE_PATH, num))).click();
        } else {
            appiumDriver.findElement(By.xpath(String.format(WHO_ARE_YOU_AND_AGE_PATH, num + 1))).click();
        }
    }

    public void selectAge(final Integer age) {
        agePrompt.click();
        Integer ageForXpath = 2;
        Integer ageStarts = 18;
        if (age >= 18 & age <= 26) {
            ageStarts = age - ageStarts;
            ageForXpath += ageStarts;
            final String ageLocator = String.format(WHO_ARE_YOU_AND_AGE_PATH, ageForXpath);
            appiumDriver.findElement(By.xpath(ageLocator)).click();
        }
    }
}
