package addressbook.test.test;

import addressbook.test.ApplicationManager.ApplicationManager;
import addressbook.test.model.ContactData;
import addressbook.test.model.Contacts;
import addressbook.test.model.GroupData;
import addressbook.test.model.Groups;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class TestBase {

    Logger logger = LoggerFactory.getLogger(TestBase.class);

    protected static ApplicationManager app =
            new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));

    @BeforeSuite(alwaysRun = true)
    public void setUp(ITestContext context ) throws Exception {
        app.init();
        context.setAttribute("app", app);
    }


    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        app.getSessionHelper().close();

    }

    @BeforeMethod
    public void logTestStart(Method m, Object[] p) {
        logger.info("Start test " + m.getName() + "with parameters" + Arrays.asList(p));
    }

    @AfterMethod(alwaysRun = true)
    public void logTestStop(Method m, Object[] p) {
        logger.info("Stop test " + m.getName() + "with parameters" + Arrays.asList(p));

    }


    public ApplicationManager getAppManage() {
        return app;
    }

    public void verifyGroupListInUI() {
        if (Boolean.getBoolean("verifyUI")) {
            Groups dbGroups = app.db().groups();
            Groups uiGroups = app.group().all();
            assertThat(uiGroups, equalTo(dbGroups.stream().map((g)
                    -> new GroupData().withId(g.getId()).withName(g.getName()))
                    .collect(Collectors.toSet())));
        }

    }

    public void verifyContactListInUI () {
        if (Boolean.getBoolean("verifyUI")) {
            Contacts dbContacts = app.db().contacts();
            Groups uiContacts = app.group().all();
            assertThat(uiContacts, equalTo(dbContacts.stream().map((c)
                    -> new ContactData()
                    .withFirstname(c.getFirstname()).withLastname(c.getLastname()))
                    .collect(Collectors.toSet())));
        }
    }


}

