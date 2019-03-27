package info.gabi;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;


public enum BrowserFactory {

  chrome {
    public WebDriver create() {
      WebDriverManager.chromedriver().setup();
      return new  ChromeDriver();
    }
  },
  firefox {
    public WebDriver create() {
      WebDriverManager.firefoxdriver().setup();
      return new FirefoxDriver();
    }
  },
  opera {
    public WebDriver create() {
      WebDriverManager.operadriver().setup();
      return new OperaDriver();
    }
  };


  public WebDriver create() {
    return null;
  }
}

