package parentTest;

import libs.ConfigProperties;
import org.aeonbits.owner.ConfigFactory;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import pajes.EditSparesPage;
import pajes.HomePage;
import pajes.LoginPage;
import pajes.SparesPage;

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
    protected static ConfigProperties configProperties = ConfigFactory.create(ConfigProperties.class);

    @Before
    public void setUp() {
        if ("chrome".equals(browser)|| browser== null) {
            File file = new File("./src/drivers/chromedriver.exe");
            System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
            webDriver = new ChromeDriver();
        }
            else if ("FireFox".equals(browser)) {
                logger.info("FireFox will be started");
                File fileFF = new File("./src/drivers/geckodriver");
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
        editSparesPage = new EditSparesPage (webDriver);
    }

    @After
    public void tearDown() { webDriver.quit();}
    protected void checkAC(String message,boolean actual,boolean expected){

        if (!(actual == expected)){
            logger.error("AC failed:" + message);
        }
        Assert.assertEquals(message,expected,actual);
    }



}
