package info.gabi.tests;

import info.gabi.BaseRunner;
import info.gabi.pages.TinkoffMobilePage;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class TinkoffMobileTests extends BaseRunner {

    @Test
    public void goToTinkoffMobileWebSite() {
        TinkoffMobilePage mobilePage = new TinkoffMobilePage();
        mobilePage.init(getDriver());
        mobilePage.checkAllCheckboxes(true);
    }


//        driver.get("https://google.ru");
//        Select queryLine = new Select("Поиск", driver);
//        queryLine.setText("мобайл тинькофф");
//        queryLine.chooseOption("тарифы");
//        Button linkToTinkoffMobile = new Button("//a[contains(@href,'https://www.tinkoff.ru/mobile-operator/tariffs/')]", driver);
//        linkToTinkoffMobile.click();
//        wait(2);
//        checkTabName("Тарифы Тинькофф Мобайла");
//        closePreviousTab();
//        softly.assertThat(driver.getCurrentUrl()).isEqualTo("https://www.tinkoff.ru/mobile-operator/tariffs/");
//    }
//

    @Test
    public void comparePrices() {

        TinkoffMobilePage mobilePage = new TinkoffMobilePage();
        mobilePage.init(getDriver());
        mobilePage.selectRegionOnPopup("Москва");
        mobilePage.compareMinPrices();
        mobilePage.compareMaxPrices();

    }
//    @Test
//    public void comparePrices() {
//        driver.get("https://www.tinkoff.ru/mobile-operator/tariffs/");
//        changeRegion("Москва");
//        Label region = new Label("//*[contains(@class, 'Region')]", driver);
//        softly.assertThat(region.getText().contains("Москва")).isTrue();
//
//        driver.navigate().refresh();
//        region.refreshElement();
//        softly.assertThat(region.getText().contains("Москва")).isTrue();
//
//        wait(1);
//        Label price = new Label("//*[contains(text(),'Общая цена')]", driver);
//        String priceMoscow = price.getText();
//        Select internet = new Select("Интернет", driver);
//        internet.chooseOption("Безлимитный интернет");
//        Select calls = new Select("Звонки", driver);
//        calls.chooseOption("Безлимитные минуты");
//        checkAllCheckboxes(true);
//        String maxPriceMoscow = price.getText();
//
//        changeRegion("Краснодар");
//
//        region.refreshElement();
//        softly.assertThat(region.getText().contains("Краснодар")).isTrue();
//        wait(3);
//        price.refreshElement();
//        String priceKrasnodar = price.getText();
//        internet = new Select("Интернет", driver);
//        internet.chooseOption("Безлимитный интернет");
//        calls = new Select("Звонки", driver);
//        calls.chooseOption("Безлимитные минуты");
//        checkAllCheckboxes(true);
//        String maxPriceKrasnodar = price.getText();
//
//        log.info("Москва " + priceMoscow + " Краснодар " + priceKrasnodar);
//        log.info("Москва " + maxPriceMoscow + " Краснодар " + maxPriceKrasnodar + " пакеты по максимуму");
//
//        softly.assertThat(!getInteger(priceMoscow).equals(getInteger(priceKrasnodar)));
//        softly.assertThat(getInteger(maxPriceMoscow).equals(getInteger(maxPriceKrasnodar)));
//
//    }
//
//    @Test
//    public void checkButtonActive() {
//        driver.get("https://www.tinkoff.ru/mobile-operator/tariffs/");
//        wait.until(ExpectedConditions.titleContains("Тарифы Тинькофф Мобайла"));
//        wait(5);
//        checkAllCheckboxes(false);
//        Select internet = new Select("Интернет", driver);
//        internet.chooseOption("0 ГБ");
//        Select calls = new Select("Звонки", driver);
//        calls.chooseOption("0 минут");
//        Label price = new Label("//*[contains(text(),'Общая цена')]", driver);
//        softly.assertThat(price.getText().equals("0 \u20BD"));
//        Button orderSim = new Button("//button/span/div[text()='Заказать сим-карту']", driver);
//        softly.assertThat(orderSim.getButton().isEnabled()).isTrue();
//    }
}