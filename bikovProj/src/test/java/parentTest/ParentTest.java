package parentTest;

import io.qameta.allure.Attachment;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.EditSparesPage;
import pages.HomePage;
import pages.LoginPage;
import pages.SparesPage;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class ParentTest {

    Logger logger = Logger.getLogger(getClass());
    WebDriver webDriver;
    protected LoginPage loginPage;
    protected HomePage homePage;
    protected SparesPage sparesPage;
    protected EditSparesPage editSparesPage;
    private String browser = System.getProperty("browser");

    @Before
    public void setUp() {
        if ("chrome".equals(browser) || browser == null) {
            File file = new File("/usr/local/bin/chromedriver");
            System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
            webDriver = new ChromeDriver();
        } else if ("ie".equals(browser)) {
            logger.info("IE will be started");
            File file1 = new File("./src/drivers/IEDriverServer.exe");
            System.setProperty("webdriver.ie.driver", file1.getAbsolutePath());
            DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
            capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
            capabilities.setCapability("ignoreZoomSetting", true);
            capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
            webDriver = new InternetExplorerDriver();
            logger.info(" IE is started");
        } else if ("fireFox".equals(browser)) {
            logger.info("FireFox will be started");
            File fileFF = new File(".././drivers/geckodriver");
            System.setProperty("webdriver.gecko.driver", fileFF.getAbsolutePath());
            FirefoxOptions profile = new FirefoxOptions();
            profile.addPreference("browser.startup.page", 0); // Empty start page
            profile.addPreference("browser.startup.homepage_override.mstone", "ignore"); // Suppress the "What's new" page
            webDriver = new FirefoxDriver(profile);
            logger.info(" FireFox is started");
        }

        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        loginPage = new LoginPage(webDriver);
        homePage = new HomePage(webDriver);
        sparesPage = new SparesPage(webDriver);
        editSparesPage = new EditSparesPage(webDriver);
    }

    @After
    public void tearDown() {

//        webDriver.quit();
    }

    protected void checkAC(String message, boolean actual, boolean expected) {
        if (!(actual == expected)) {
            logger.error("AC failed: " + message);
        }
        Assert.assertEquals(message, expected, actual);
    }

    @Rule
    public TestWatcher watchman = new TestWatcher() {
        String fileName;

        @Override
        protected void failed(Throwable e, Description description) {
            screenshot();
        }

        @Attachment(value = "Page screenshot", type = "image/png")
        public byte[] saveScreenshot(byte[] screenShot) {
            return screenShot;
        }

        public void screenshot() {
            if (webDriver == null) {
                logger.info("Driver for screenshot not found");
                return;
            }

            saveScreenshot(((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES));

        }

        @Override
        protected void finished(Description description) {
            logger.info(String.format("Finished test: %s::%s", description.getClassName(), description.getMethodName()));
            try {
                webDriver.quit();
            } catch (Exception e) {
                logger.error(e);
            }
        }
    };
}

