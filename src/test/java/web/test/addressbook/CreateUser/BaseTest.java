package web.test.addressbook.CreateUser;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected final AppManage appManage = new AppManage();

    @BeforeMethod(alwaysRun = true)
    public void setUp() throws Exception {
        appManage.init();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        appManage.close();

    }

    public AppManage getAppManage() {
        return appManage;
    }
}
