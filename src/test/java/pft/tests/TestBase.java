package pft.tests;

import pft.helper.ApplicationManager;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {

    protected static ApplicationManager app;

    @BeforeSuite
    public void setUp() {
        app = new ApplicationManager();

    }

    @AfterSuite
    public void tearDown() {
        app.stop();
    }

}
