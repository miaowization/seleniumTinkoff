package info.gabi.pages;

import info.gabi.ExtendedFieldDecorator;
import info.gabi.interfaces.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static java.lang.Integer.getInteger;

@Slf4j
public class TinkoffMobilePage implements BasePage {

  @Override
  public void init(final WebDriver driver) {
    PageFactory.initElements(new ExtendedFieldDecorator(driver), this);
  }

  @FindBy(xpath = "//label[contains(text(),'Музыка')]/../div")
  CheckBox music;

  @FindBy(xpath = "//label[contains(text(),'Мессенджеры')]/../div")
  CheckBox messengers;

  @FindBy(xpath = "//label[contains(text(),'Безлимитные СМС')]/../div")
  CheckBox sms;

  @FindBy(xpath = "//label[contains(text(),'Видео')]/../div")
  CheckBox video;

  @FindBy(xpath = "//label[contains(text(),'Социальные сети')]/../div")
  CheckBox socialNets;

  @FindBy(xpath = "//label[contains(text(),'Режим модема')]/../div")
  CheckBox modem;

  @FindBy(xpath = "//div[contains(@class,'MobileOperatorRegionsPopup__region_2eF67 MobileOperatorRegionsPopup__regionLong_iVkvT')]")
  Button regionOnPopup;

  @FindBy(xpath = "//*[@class='MvnoRegionConfirmation__title_DOqnW']")
  Button regionButton;

  @FindBy(xpath = "//*[text()='Да']")
  Button changeRegionYesButton;

  @FindBy(xpath = "//*[text()='Нет, изменить']")
  Button changeRegionNoButton;

  @FindBy(xpath = "//div[text()='Город']/../input")
  TextInput city;

  @FindBy(xpath = "//*[contains(text(),'Общая цена')]")
  Label priceInTotal;

  @FindBy(xpath = "//*[contains(text(),'Интернет')]")
  Select internet;

  @FindBy(xpath = "//*[contains(text(),'Звонки')]")
  Select calls;


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

  public void selectRegionOnPopup(String regionText) {
    if (regionButton.getText().contains(regionText)) {
      changeRegionYesButton.click();
    } else {
      try {
        changeRegionNoButton.click();
      } catch (WebDriverException e) {
        regionButton.click();
      }
      city.type(regionText);
      regionOnPopup.click();
    }
    Assert.assertEquals(regionButton.getText(), regionText);
  }

  public void compareMinPrices() {
    selectRegionOnPopup("Москва");
    String priceMoscow = priceInTotal.getText();
    log.info(priceMoscow);
    selectRegionOnPopup("Краснодар");
    log.info("Выбрали регион - Краснодар");
    String priceKrasnodar = priceInTotal.getText();
    log.info(priceKrasnodar);
    softly.assertThat(!getInteger(priceMoscow).equals(getInteger(priceKrasnodar)));
  }

  public void compareMaxPrices() {
    selectRegionOnPopup("Москва");
    internet.chooseOption("Безлимитный интернет");
    calls.chooseOption("Безлимитные минуты");
    checkAllCheckboxes(true);
    String maxPriceMoscow = priceInTotal.getText();
    log.info("По Москве: ", maxPriceMoscow);

    selectRegionOnPopup("Краснодар");
    internet.chooseOption("Безлимитный интернет");
    calls.chooseOption("Безлимитные минуты");
    checkAllCheckboxes(true);
    String maxPriceKrasnodar = priceInTotal.getText();
    log.info("По Краснодару", maxPriceKrasnodar);

    softly.assertThat(getInteger(maxPriceMoscow).equals(getInteger(maxPriceKrasnodar)));
  }
}
