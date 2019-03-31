package info.gabi;

import org.assertj.core.api.JUnitSoftAssertions;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BaseRunner {

  WebDriver driver;
  String baseUrl;
  WebDriverWait wait;
  JUnitSoftAssertions softly;
  String browserName = System.getProperty("browser");

  @Before
  public void setUp() {
    driver = createDriver();
    baseUrl = "https://www.tinkoff.ru/career/vacancies/";
    wait = new WebDriverWait(driver, 10);
    softly = new JUnitSoftAssertions();
  }

  private WebDriver createDriver() {
    try {
      BrowserFactory.valueOf(System.getProperty("browser"));
      return BrowserFactory.valueOf(browserName).create();
    } catch (NullPointerException | IllegalArgumentException e) {
      return BrowserFactory.chrome.create();
    }
  }

  public WebDriver getDriver() {
    return this.driver;
  }

  @After
  public void tearDown() {
    driver.quit();
  }
}