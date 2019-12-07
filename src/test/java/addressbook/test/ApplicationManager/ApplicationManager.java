package addressbook.test.ApplicationManager;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    WebDriver wd;

    private GroupHelper groupHelper;
    private SessionHelper sessionHelper;
    private NavigationHelper navigationHelper;
    private ContactHelper contactHelper;
    private String browser;
    private Properties properties;
    private DbHelper dbHelper;

    public ApplicationManager(String browser) {
        this.browser = browser;
        properties = new Properties();
        System.out.println(browser);

    }

    public void init() throws IOException {

        properties.load(new FileReader(new File(String
                .format("src\\test\\java\\addressbook\\test\\resourses\\local.properties"))));
        dbHelper = new DbHelper();

        if ("".equals(properties.getProperty("selenium.server"))) {


            if (browser.equals(BrowserType.FIREFOX)) {
                wd = new FirefoxDriver();
            } else if (browser.equals(BrowserType.CHROME)) {
                wd = new ChromeDriver();
            } else if (browser.equals(BrowserType.IE)) {
                wd = new InternetExplorerDriver();
            }
        } else {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setBrowserName(browser);
            wd = new RemoteWebDriver(new URL(properties.getProperty("selenium.server")), capabilities);
        }


        wd.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        wd.get(properties.getProperty("web.baseUrl"));
        contactHelper = new ContactHelper(wd);
        navigationHelper = new NavigationHelper(wd);
        sessionHelper = new SessionHelper(wd);
        groupHelper = new GroupHelper(wd);
        sessionHelper.login(properties.getProperty("web.adminLogin"),
                properties.getProperty("web.adminPassword") );

    }

    public ContactHelper contact() {
        return contactHelper;
    }

    public NavigationHelper goTo() {
        return navigationHelper;
    }

    public SessionHelper getSessionHelper() {
        return sessionHelper;
    }

    public GroupHelper group() {
        return groupHelper;
    }

    public DbHelper db(){
        return dbHelper;
    }
}
