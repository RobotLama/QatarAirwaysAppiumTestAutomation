import com.thoughtworks.gauge.Step;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

public class Methods extends BaseTest {

    //AppiumDriver<MobileElement> appiumDriver;

    private static final Logger logger = LogManager.getLogger(AppiumDriver.class);

    int globalIndex;
    String globalFlightTime;

    public void waitBySeconds(int seconds) {

        try {
            seconds *= 1000;
            Thread.sleep(seconds);
            logger.info(seconds + " seconds waited");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    /*
    public void tapElementById(String id) {

        appiumDriver.findElement(By.id(id)).click();
        logger.info("Element that has " + id + " id tapped");

    }
    */

    public void tapElementIfVisibleSkipById(int seconds, String id) {

        waitBySeconds(seconds);

        try {

            MobileElement element = appiumDriver.findElement(By.id(id));

            if (element.isDisplayed()) {
                element.click();
                logger.info("Element that has " + id + " id tapped");
            } else
                logger.info("Element that has " + id + " is not visible");
        }catch (Exception e){
            logger.info("Element that has " + id + " is not visible");
        }

    }

    public void tapElementIfClickableById(String id) {

        WebDriverWait wait = new WebDriverWait(appiumDriver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(By.id(id)));

        appiumDriver.findElement(By.id(id)).click();

        logger.info("Element that has " + id + " id tapped");

    }

    public void tapElementIfClickableByXpath(String xpath) {

        WebDriverWait wait = new WebDriverWait(appiumDriver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));

        appiumDriver.findElement(By.xpath(xpath)).click();

        logger.info("Element that has " + xpath + " xpath tapped");

    }

    public void assertElementById(String id) {

        Boolean element = appiumDriver.findElement(By.id(id)).isEnabled();

        Assertions.assertTrue(element);

    }

    public void assertElementWithTextById(String id, String text) {

        MobileElement element = appiumDriver.findElement(By.id(id));
        String actualElementText = element.getText();
        System.out.println(actualElementText);

        Assertions.assertEquals(text, actualElementText);

    }

    public void assertElementWithTextByXpath(String xpath, String text) {

        MobileElement element = appiumDriver.findElement(By.xpath(xpath));
        String actualElementText = element.getText();
        System.out.println(actualElementText);

        Assertions.assertEquals(text, actualElementText);

    }

    public void sendKeysById(String id, String text) {

        appiumDriver.findElement(By.id(id)).sendKeys(text);
        logger.info("Sent " + text + " key to element that has " + id + " id");

    }

    public void tapRandom(String xpath) {

        List<MobileElement> elements = appiumDriver.findElements(By.xpath(xpath));
        Random random = new Random();

        int index = random.nextInt(elements.size() - 1);
        globalIndex = index;
        elements.get(index).click();

    }

    public void tapZeroIndex(String xpath) {

        List<MobileElement> elements = appiumDriver.findElements(By.xpath(xpath));

        elements.get(0).click();

    }

    public void getFlightTime(String xpath) {

        List<MobileElement> elements = appiumDriver.findElements(By.xpath(xpath));

        String flightTime =  elements.get(globalIndex).getText();
        globalFlightTime = flightTime;

    }

    public void assertFlightTime(String id) {

        List<MobileElement> element = appiumDriver.findElements(By.id(id));
        String flightTimeSecondView =  element.get(0).getText();

        Assertions.assertEquals(flightTimeSecondView, globalFlightTime);
    }

    public void getDayOfMonthPlusAndTap(long plusDay){

        int selectedDay = LocalDate.now().plusDays(plusDay).getDayOfMonth();


        String element = "//*[@resource-id = \'com.m.qr:id/rvmp_booking_calendar_day_text_view\'][@text = \"" + selectedDay + "\"]";

        tapElementIfClickableByXpath(element);
    }





}
