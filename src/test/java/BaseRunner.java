import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BaseRunner {

  WebDriver driver;
  String baseUrl;
  WebDriverWait wait;
  public String browserName = System.getProperty("browser");

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

  void clear(WebElement element) {
    while (element.getAttribute("value").length() > 0) {
      element.sendKeys(Keys.chord(Keys.SHIFT, Keys.UP));
      element.sendKeys(Keys.BACK_SPACE);
      element.sendKeys(Keys.chord(Keys.SHIFT, Keys.DOWN));
      element.sendKeys(Keys.BACK_SPACE);
    }

  }

  void clearPhone(WebElement element) {
    while (!element.getAttribute("value").contentEquals("+7(")) {
      element.sendKeys(Keys.chord(Keys.SHIFT, Keys.UP));
      element.sendKeys(Keys.BACK_SPACE);
      element.sendKeys(Keys.chord(Keys.SHIFT, Keys.DOWN));
      element.sendKeys(Keys.BACK_SPACE);
    }
  }


  @After
  public void tearDown() {
    driver.quit();
  }
}