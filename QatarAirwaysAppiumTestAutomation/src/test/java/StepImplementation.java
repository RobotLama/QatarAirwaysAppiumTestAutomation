import com.thoughtworks.gauge.Step;

public class StepImplementation extends BaseTest {

    Methods methods;

    @Step("<seconds> seconds waited")
    public void waitBySeconds(int seconds){

        initMethods();
        methods.waitBySeconds(seconds);

    }

    @Step("Check the element that has <id> id")
    public void assertElementById(String id) {

        initMethods();
        methods.assertElementById(id);

    }

    @Step("Find and tap element that has <id> id")
    public void tapElementById(String id) {

        initMethods();
        methods.tapElementIfClickableById(id);

    }

    @Step("Find and tap element that has <xpath> xpath")
    public void tapElementByXpath(String xpath) {

        initMethods();
        methods.tapElementIfClickableByXpath(xpath);

    }

    @Step("Find element that has <id> id and check is it contains <text> value")
    public void assertElementWithTextById(String id, String text) {

        initMethods();
        methods.assertElementWithTextById(id, text);

    }

    @Step("Find element that has <id> id and send <text> key")
    public void sendKeysById(String id, String text) {

        initMethods();
        methods.sendKeysById(id, text);

    }

    @Step("Wait <seconds> seconds for the element that has <id> id (Visible: Tap / Not visible: Skip)")
    public void tapElementIfVisibleById(int seconds, String id) {

        initMethods();
        methods.tapElementIfVisibleSkipById(seconds, id);

    }

    @Step("Select a random element from <xpath> xpath")
    public void tapRandom(String xpath) {

        initMethods();
        methods.tapRandom(xpath);

    }

    @Step("Select first element from <xpath> xpath")
    public void tapZeroIndex(String xpath) {

        initMethods();
        methods.tapZeroIndex(xpath);
    }

    @Step("<plusDays> days from today is selected as the day")
    public void getDayOfMonthPlus(long plusDay) {

        initMethods();
        methods.getDayOfMonthPlusAndTap(plusDay);

    }

    @Step("Get flight time from <xpath> xpath")
    public void getFlightTime(String xpath) {

        initMethods();
        methods.getFlightTime(xpath);

    }

    @Step("Assert flight time from <id> id")
    public void assertFlightTime(String id) {

        initMethods();
        methods.assertFlightTime(id);

    }




        public void initMethods(){
        methods = new Methods();
    }


}
