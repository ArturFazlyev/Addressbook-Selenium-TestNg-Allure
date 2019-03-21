package sandbox.addressbook.test.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import sandbox.addressbook.test.ApplicationManager.ApplicationManager;

public class BaseTest {

    protected final ApplicationManager appManage = new ApplicationManager();

    @BeforeMethod(alwaysRun = true)
    public void setUp() throws Exception {
        appManage.init();
    }


    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        appManage.getSessionHelper().close();

    }


    public ApplicationManager getAppManage() {
        return appManage;
    }
}
