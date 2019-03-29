package info.gabi;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;

@Slf4j
class TestMethods extends BaseRunner {


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
        log.info(messengers.getText());
        video.setActive(active);
        sms.setActive(active);
        socialNets.setActive(active);
    }

    void changeRegion(String region) {
        if (driver.findElement(By.xpath("//*[contains(@class, 'Region')]")).getText().contains(region))
            driver.findElement(By.xpath("//*[text()='Да']")).click();
        else {
            try {
                driver.findElement(By.xpath("//*[text()='Нет, изменить']")).click();
            } catch (WebDriverException ex) {
                driver.findElement(By.xpath("//*[contains(@class, 'Region')]")).click();
            }
            TextInput city = new TextInput("Город", driver);
            city.setText(region);
            driver.findElement(By.xpath("//*[contains(text(), '" + region + "')]")).click();
        }
    }
}
