package info.gabi;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BaseRunner {

  WebDriver driver;
  String baseUrl;
  WebDriverWait wait;
  String browserName = System.getProperty("browser");

  @Before
  public void setUp() {
    driver = getDriver();
    baseUrl = "https://www.tinkoff.ru/career/vacancies/";
    wait = new WebDriverWait(driver, 10);
  }

  private WebDriver getDriver() {
    try {
      BrowserFactory.valueOf(System.getProperty("browser"));
      return BrowserFactory.valueOf(browserName).create();
    } catch (NullPointerException | IllegalArgumentException e) {
      return BrowserFactory.chrome.create();
    }
  }

  @After
  public void tearDown() {
    driver.quit();
  }
}