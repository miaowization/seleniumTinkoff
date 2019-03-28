package info.gabi;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.JUnitSoftAssertions;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;

@Slf4j
public class OtherTests extends TestMethods {

  @Rule
  public JUnitSoftAssertions softly = new JUnitSoftAssertions();

  @Test
  public void test1() throws InterruptedException {
    driver.get("https://google.ru");
    driver.findElement(By.xpath("//input[@title='Поиск']")).sendKeys("мобайл тинькофф");
    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(), 'тарифы')]")));
    driver.findElement(By.xpath("//*[contains(text(), 'тарифы')]")).click();
    driver.findElement(By.xpath("//a[contains(@href,'https://www.tinkoff.ru/mobile-operator/tariffs/')]")).click();

    Thread.sleep(1000);
    ArrayList<String> windows = new ArrayList<>(driver.getWindowHandles());

    driver.switchTo().window(windows.get(driver.getWindowHandles().size() - 1));
    softly.assertThat(driver.getTitle()).isEqualTo("Тарифы Тинькофф Мобайла");
    String currentTab = driver.getWindowHandle();
    for (String handle : driver.getWindowHandles()) {
      if (!handle.equals(currentTab)) {
        driver.switchTo().window(handle);
        driver.close();
      }
    }
    driver.switchTo().window(currentTab);
    softly.assertThat(driver.getCurrentUrl()).isEqualTo("https://www.tinkoff.ru/mobile-operator/tariffs/");
  }

  @Test
  public void test2() throws InterruptedException {
    driver.get("https://www.tinkoff.ru/mobile-operator/tariffs/");
    changeRegion("Москва");
    softly.assertThat(driver.findElement(By.xpath("//*[contains(@class, 'Region')]"))
            .getText().contains("Москва")).isTrue();

    String priceMoscow = driver.findElement(By.xpath("//h3[contains(text(),'Общая цена')]")).getText();
    driver.navigate().refresh();

    changeRegion("Краснодар");
    softly.assertThat(driver.findElement(By.xpath("//*[contains(@class, 'Region')]"))
            .getText().contains("Краснодар")).isTrue();

    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h3[contains(text(),'Общая цена')]")));
    String priceKrasnodar = driver.findElement(By.xpath("//h3[contains(text(),'Общая цена')]")).getText();

    System.out.println("Москва " + priceMoscow + " Краснодар " + priceKrasnodar);

    softly.assertThat(!getInteger(priceMoscow).equals(getInteger(priceKrasnodar)));

    checkAllCheckboxes(true);
    Thread.sleep(4000);

  }

  @Test
  public void test3() throws InterruptedException {
    driver.get("https://www.tinkoff.ru/mobile-operator/tariffs/");
    wait.until(ExpectedConditions.titleContains("Тарифы Тинькофф Мобайла"));
    Thread.sleep(10000);
    checkAllCheckboxes(false);
    Select internet = new Select("Интернет", driver);
    internet.chooseOption("0 ГБ");
    Select calls = new Select("Звонки", driver);
    calls.chooseOption("0 минут");
    softly.assertThat(driver.findElement(By.xpath("//button/span/div[text()='Заказать сим-карту']"))
            .isEnabled()).isTrue();
  }
}
