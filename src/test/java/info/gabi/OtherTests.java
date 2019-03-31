package info.gabi;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Slf4j
public class OtherTests extends BaseTestClass {

    @Test
    public void test1() {
        driver.get("https://google.ru");
        Select queryLine = new Select("Поиск", driver);
        queryLine.setText("мобайл тинькофф");
        queryLine.chooseOption("тарифы");
        driver.findElement(By.xpath("//a[contains(@href,'https://www.tinkoff.ru/mobile-operator/tariffs/')]")).click();

        wait(2);
        checkTabName("Тарифы Тинькофф Мобайла");
        closePreviousTab();
        softly.assertThat(driver.getCurrentUrl()).isEqualTo("https://www.tinkoff.ru/mobile-operator/tariffs/");
    }


    @Test
    public void test2() {
        driver.get("https://www.tinkoff.ru/mobile-operator/tariffs/");
        changeRegion("Москва");
        Label region = new Label("//*[contains(@class, 'Region')]", driver);
        softly.assertThat(region.getText().contains("Москва")).isTrue();

        Label price = new Label("//*[contains(text(),'Общая цена')]", driver);
        String priceMoscow = price.getText();
        driver.navigate().refresh();

        changeRegion("Краснодар");

        region.refreshElement();
        softly.assertThat(region.getText().contains("Краснодар")).isTrue();

        price.refreshElement();
        String priceKrasnodar = price.getText();

        System.out.println("Москва " + priceMoscow + " Краснодар " + priceKrasnodar);

        softly.assertThat(!getInteger(priceMoscow).equals(getInteger(priceKrasnodar)));

        checkAllCheckboxes(true);
    }

    @Test
    public void test3() {
        driver.get("https://www.tinkoff.ru/mobile-operator/tariffs/");
        wait.until(ExpectedConditions.titleContains("Тарифы Тинькофф Мобайла"));
        wait(5);
        checkAllCheckboxes(false);
        Select internet = new Select("Интернет", driver);
        internet.chooseOption("0 ГБ");
        Select calls = new Select("Звонки", driver);
        calls.chooseOption("0 минут");
        softly.assertThat(driver.findElement(By.xpath("//button/span/div[text()='Заказать сим-карту']"))
                .isEnabled()).isTrue();
    }

}