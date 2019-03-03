package frontend.pageobject.HitWe;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class HitWeSelectGirlsOrBoysPage {

    private static final String BOYS_GIRLS_PATH = "(//android.view.View[@content-desc='%s'])[1]"; //Парни
    private static final String HAIR_PATH = "(//android.view.View[@content-desc='%s'])[1]"; //Светлые
    private static final String EYES_PATH = "(//android.view.View[@content-desc='%s'])[1]"; //Светлые
    private static final String SHAPE_PATH = "(//android.view.View[@content-desc='%s'])[1]"; //Обычная

    private AppiumDriver appiumDriver;

    public HitWeSelectGirlsOrBoysPage(final AppiumDriver appiumDriver) {
        this.appiumDriver = appiumDriver;
        appiumDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
    }

    public SignUpFormFromGirlsOrBoysPage selectTypes(final String sex, final String hair, final String eyes, final String shape) {
        selectGirlsOrBoys(sex);
        selectLightOrDarkHair(hair);
        selectEyes(eyes);
        selectShape(shape);
        return new SignUpFormFromGirlsOrBoysPage(appiumDriver);
    }

    public void selectGirlsOrBoys(final String sex) {
        final WebElement boysOrGirlsButton = appiumDriver.findElement(By.xpath(String.format(BOYS_GIRLS_PATH, sex)));
        boysOrGirlsButton.click();
    }

    public void selectLightOrDarkHair(final String hair) {
        final WebElement hairButton = appiumDriver.findElement(By.xpath(String.format(HAIR_PATH, hair)));
        hairButton.click();
    }

    public void selectEyes(final String eyes) {
        final WebElement eyesButton = appiumDriver.findElement(By.xpath(String.format(EYES_PATH, eyes)));
        eyesButton.click();
    }

    public SignUpFormFromGirlsOrBoysPage selectShape(final String shape) {
        final WebElement shapeButton = appiumDriver.findElement(By.xpath(String.format(SHAPE_PATH, shape)));
        shapeButton.click();
        return new SignUpFormFromGirlsOrBoysPage(appiumDriver);
    }

}
