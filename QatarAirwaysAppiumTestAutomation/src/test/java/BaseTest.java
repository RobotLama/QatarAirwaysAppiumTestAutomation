import com.thoughtworks.gauge.AfterScenario;
import com.thoughtworks.gauge.BeforeScenario;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.remote.DesiredCapabilities;

public class BaseTest {

    protected static AppiumDriver<MobileElement> appiumDriver;

    // Device name capability for Android
    private String deviceName = "emulator-5554";

    // Capabilities for Qatar Airways Android Application
    private String appPackage = "com.m.qr";
    private String appActivity = "com.m.qr.home.main.ui.HomeActivity";

    private static final Logger logger = LogManager.getLogger(AppiumDriver.class);

    // Defined that test run on an Android device
    protected boolean androidTest = true;

    @BeforeScenario
    public void beforeScenario() throws MalformedURLException {

        if (androidTest) {

            logger.info("---------- Android Test Started ----------");

            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
            desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME,deviceName);
            desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,appPackage);
            desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,appActivity);
            desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,3000);

            URL url = new URL("http://127.0.0.1:4723/wd/hub");
            appiumDriver = new AndroidDriver(url,desiredCapabilities);

        } else {

            logger.info("---------- iOS Test Started ----------");

            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.IOS);
            desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"XCUITest");
            desiredCapabilities.setCapability(MobileCapabilityType.UDID,"--- UDID ---");
            desiredCapabilities.setCapability(IOSMobileCapabilityType.BUNDLE_ID,"--- Bundle ID ---");
            desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"--- Device Name ---");
            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"--- Platform Version ---");
            desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,3000);

            URL url = new URL("http://127.0.0.1:4723/wd/hub");
            appiumDriver = new IOSDriver(url,desiredCapabilities);

        }

    }

    @AfterScenario
    public void afterScenario() {

        logger.info("---------- Driver Closed ----------");

        appiumDriver.quit();

    }


}
