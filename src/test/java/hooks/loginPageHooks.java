package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import webDriverFactory.driverFactory;


public class loginPageHooks {


    @Before
    public void setUp() {
        driverFactory.launchBrowser();
    }

    @After
    public void tearDown() {
        driverFactory.closeBrowser();
    }


}
