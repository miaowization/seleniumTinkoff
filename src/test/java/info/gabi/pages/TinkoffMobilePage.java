package info.gabi.pages;

import info.gabi.ExtendedFieldDecorator;
import info.gabi.interfaces.CheckBox;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
}
