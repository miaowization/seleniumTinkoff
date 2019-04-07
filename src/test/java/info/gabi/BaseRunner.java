package info.gabi;

import org.assertj.core.api.JUnitSoftAssertions;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BaseRunner {

    protected static WebDriver driver;
    protected WebDriverWait wait;

    @Rule
    public JUnitSoftAssertions softly = new JUnitSoftAssertions();

    @Before
    public void setUp() {
        driver = createDriver();
        wait = new WebDriverWait(driver, 10);
    }

    private WebDriver createDriver() {
        return BrowserFactory.chrome.create();
    }

    public WebDriver getDriver() {
        return this.driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public static WebDriver getInstance() {
        if (driver == null) {
            driver = BrowserFactory.chrome.create();
        }
        return driver;
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}