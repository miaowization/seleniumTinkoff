package info.gabi.pages;

import info.gabi.interfaces.*;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;

@Slf4j
public class TinkoffMobilePage extends AbstractBasePage {

    public TinkoffMobilePage(WebDriver driver) {
        setDriver(driver);
        init();
    }

    @Override
    public void open() {
        getDriver().navigate().to("https://www.tinkoff.ru/mobile-operator/tariffs/");
        waitForPageToLoad();
    }

    public void checkAllCheckboxes(boolean active) {
        try {
            music.setActive(active);
            messengers.setActive(active);
            video.setActive(active);
            sms.setActive(active);
            socialNets.setActive(active);
        } catch (WebDriverException e) {
            modem.setActive(active);
            sms.setActive(active);
        }
    }

    private void selectRegionOnPopup(String regionText) {
        if (!regionButton.getText().contains(regionText)) {
            try {
                changeRegionNoButton.click();
            } catch (WebDriverException e) {
                regionButton.click();
            }
            city.type(regionText);
            regionOnPopup.click();
        }
        softly.assertThat(regionButton.getText()).contains(regionText);
    }

    public void compareDefaultPrices() {
        selectRegionOnPopup("Москва");
        log.info("Выбрали регион - Москва");
        String priceMoscow = priceInTotal.getText();
        log.info("Общая цена по Москве: {}", priceMoscow);
        selectRegionOnPopup("Краснодар");
        log.info("Выбрали регион - Краснодар");
        String priceKrasnodar = priceInTotal.getText();
        log.info("Общая цена по Краснодару: {}", priceKrasnodar);
        softly.assertThat(getInteger(priceMoscow)).isNotEqualTo(getInteger(priceKrasnodar));
    }

    public void compareMaxPrices() {
        selectRegionOnPopup("Москва");
        internet.clickAndSelectOption("Безлимитный интернет");
        calls.clickAndSelectOption("Безлимитные минуты");
        checkAllCheckboxes(true);
        String maxPriceMoscow = priceInTotal.getText();
        log.info("Общая цена по Москве: {}", maxPriceMoscow);

        selectRegionOnPopup("Краснодар");
        internet.clickAndSelectOption("Безлимитный интернет");
        calls.clickAndSelectOption("Безлимитные минуты");
        checkAllCheckboxes(true);
        String maxPriceKrasnodar = priceInTotal.getText();
        log.info("Общая цена по Краснодару: {}", maxPriceKrasnodar);

        softly.assertThat(getInteger(maxPriceMoscow).equals(getInteger(maxPriceKrasnodar)));
    }

    public void selectInternetOption(String option) {
        internet.clickAndSelectOption(option);
    }

    public void selectCallsOption(String option) {
        calls.clickAndSelectOption(option);
    }

    public void checkPriceInTotal(String text) {
        softly.assertThat(priceInTotal.getText()).isEqualTo("Общая цена: " + text + " \u20BD");
        softly.assertAll();
        log.info("Проверили, что общая цена = {}", text);
    }

    public void checkOrderButtonIsClickable() {
        softly.assertThat(orderButton.isClickable()).isTrue();
        softly.assertAll();
        log.info("Проверили, что кнопка Заказа сим-карты активна");

    }

    public void checkTabName(String tabName) {
        ArrayList<String> windows = new ArrayList<>(getDriver().getWindowHandles());
        getDriver().switchTo().window(windows.get(getDriver().getWindowHandles().size() - 1));
        softly.assertThat(getDriver().getTitle()).isEqualTo(tabName);
        log.info("Проверили, что название вкладки = {}", tabName);
    }

    public void closePreviousTab() {
        String currentTab = null;
        for (String handle : getDriver().getWindowHandles())
            currentTab = handle;
        getDriver().switchTo().window(currentTab);
        String currentUrl = getDriver().getCurrentUrl();
        for (String handle : getDriver().getWindowHandles()) {
            if (!handle.equals(currentTab)) {
                getDriver().switchTo().window(handle);
                getDriver().close();
            }
        }
        getDriver().switchTo().window(currentTab);
        softly.assertThat(getDriver().getCurrentUrl()).isEqualTo(currentUrl);
        log.info("Переключились на новую вкладку");
    }

    @FindBy(xpath = "//label[contains(text(),'Музыка')]/../div")
    private CheckBox music;

    @FindBy(xpath = "//label[contains(text(),'Мессенджеры')]/../div")
    private CheckBox messengers;

    @FindBy(xpath = "//label[contains(text(),'Безлимитные СМС')]/../div")
    private CheckBox sms;

    @FindBy(xpath = "//label[contains(text(),'Видео')]/../div")
    private CheckBox video;

    @FindBy(xpath = "//label[contains(text(),'Социальные сети')]/../div")
    private CheckBox socialNets;

    @FindBy(xpath = "//label[contains(text(),'Режим модема')]/../div")
    private CheckBox modem;

    @FindBy(xpath = "//div[contains(@class,'MobileOperatorRegionsPopup__region_2eF67 MobileOperatorRegionsPopup__regionLong_iVkvT')]")
    private Button regionOnPopup;

    @FindBy(xpath = "//*[@class='MvnoRegionConfirmation__title_DOqnW']")
    private Button regionButton;

    @FindBy(xpath = "//*[text()='Нет, изменить']")
    private Button changeRegionNoButton;

    @FindBy(xpath = "//div[text()='Город']/../input")
    private TextInput city;

    @FindBy(xpath = "//*[contains(text(),'Общая цена')]")
    private Label priceInTotal;

    @FindBy(xpath = "//*[contains(text(),'Интернет')]")
    private Select internet;

    @FindBy(xpath = "//*[contains(text(),'Звонки')]")
    private Select calls;

    @FindBy(xpath = "//button/span/div[text()='Заказать сим-карту']")
    private Button orderButton;
}
