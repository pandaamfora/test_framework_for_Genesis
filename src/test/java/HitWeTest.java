import frontend.pageobject.HitWe.HitWeSelectGirlsOrBoysPage;
import frontend.pageobject.HitWe.SignUpFormFromGirlsOrBoysPage;
import frontend.pageobject.HitWe.ThanksForRegistrationPage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;


public class HitWeTest {

    private DesiredCapabilities capabilities = new DesiredCapabilities();
    private AppiumDriver<MobileElement> appiumDriver = null;
//    private WebDriver driver;
    private AppiumServiceBuilder serviceBuilder;
    private AppiumDriverLocalService appiumDriverLocalService;

    @Before
    public void setUpAppium() throws MalformedURLException {
        capabilities.setCapability("deviceName", "Nexus_5X_API_25");
//        capabilities.setCapability("avd","Nexus_5X_API_25");
        capabilities.setCapability("udid", "emulator-5554");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appPackage", "com.android.chrome");
        capabilities.setCapability("appActivity", "com.google.android.apps.chrome.Main");
        capabilities.setCapability("unicodeKeyboard", "true");
        capabilities.setCapability("resetKeyboard", "true");
        serviceBuilder = new AppiumServiceBuilder();
        serviceBuilder.withIPAddress("127.0.0.1");
        serviceBuilder.usingPort(4723);
        serviceBuilder.withCapabilities(capabilities);
        serviceBuilder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
        serviceBuilder.withArgument(GeneralServerFlag.LOG_LEVEL, "error");
        appiumDriver = new AndroidDriver(capabilities);
        appiumDriverLocalService = AppiumDriverLocalService.buildService(serviceBuilder);
        appiumDriverLocalService.start();
    }

    @Test
    public void signInTrowLongSteps() throws MalformedURLException {
        ChromeNavigation chrome = new ChromeNavigation(appiumDriver);
        chrome.hideWelcomeToChrome();
        chrome.typeAddress("https://m.hitwe.com/landing/inter?p=15276");
        HitWeSelectGirlsOrBoysPage hitWeChooseGirlsOrBoysPage = new HitWeSelectGirlsOrBoysPage(appiumDriver);
        SignUpFormFromGirlsOrBoysPage signUpFormFromGirlsOrBoysPage = hitWeChooseGirlsOrBoysPage.selectTypes("Парни",
                "Светлые", "Темные",
                "Спортивная");
        ThanksForRegistrationPage thanksForRegistrationPage = signUpFormFromGirlsOrBoysPage.enterSignUpValues("Alina",
                "a1672in@testmail.com", "Девушка", 25);
        thanksForRegistrationPage.acceptNotofications();
    }

    private void terminateAppium() {
        appiumDriverLocalService.stop();
    }

    @After
    public void tearDownAppium() {
        terminateAppium();
    }
}



