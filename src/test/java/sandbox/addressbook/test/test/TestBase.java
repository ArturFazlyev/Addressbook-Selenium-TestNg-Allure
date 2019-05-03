package sandbox.addressbook.test.test;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import sandbox.addressbook.test.ApplicationManager.ApplicationManager;

public class TestBase {

    protected static ApplicationManager appManage = new ApplicationManager(BrowserType.CHROME);

    @BeforeSuite(alwaysRun = true)
    public void setUp() throws Exception {
        appManage.init();
    }


    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        appManage.getSessionHelper().close();

    }


    public ApplicationManager getAppManage() {
        return appManage;
    }
}
