package web.test.addressbook.CreateUser.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import web.test.addressbook.CreateUser.applicationmanager.AppManage;

public class BaseTest {

    protected final AppManage appManage = new AppManage();

    @BeforeMethod(alwaysRun = true)
    public void setUp() throws Exception {
        appManage.init();
    }


    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        appManage.getSessionHelper().close();

    }


    public AppManage getAppManage() {
        return appManage;
    }
}
