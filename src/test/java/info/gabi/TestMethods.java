package info.gabi;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

class TestMethods extends BaseRunner {

    void clearField(WebElement element) {
        while (element.getAttribute("value").length() > 0) {
            element.sendKeys(Keys.chord(Keys.SHIFT, Keys.UP));
            element.sendKeys(Keys.BACK_SPACE);
            element.sendKeys(Keys.chord(Keys.SHIFT, Keys.DOWN));
            element.sendKeys(Keys.BACK_SPACE);
        }
    }

    void clearPhoneField(WebElement element) {
        while (!element.getAttribute("value").contentEquals("+7(")) {
            element.sendKeys(Keys.chord(Keys.SHIFT, Keys.UP));
            element.sendKeys(Keys.BACK_SPACE);
            element.sendKeys(Keys.chord(Keys.SHIFT, Keys.DOWN));
            element.sendKeys(Keys.BACK_SPACE);
        }
    }

    Integer getInteger(String str) {
        str = str.replaceAll("\\D", "");
        return Integer.parseInt(str);
    }

    void checkAllCheckboxes(boolean active) {
        CheckBox music = new CheckBox("Музыка", driver);
        CheckBox messengers = new CheckBox("Мессенджеры", driver);
        CheckBox sms = new CheckBox("Безлимитные СМС", driver);
        CheckBox video = new CheckBox("Видео", driver);
        CheckBox socialNets = new CheckBox("Социальные сети", driver);
        music.setActive(active);
        messengers.setActive(active);
        video.setActive(active);
        sms.setActive(active);
        socialNets.setActive(active);
    }
}
