package info.gabi;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@Setter
@Getter
@Slf4j
class Select extends BaseElement {

    WebElement select;

    Select(String type, WebDriver driver) {
        super(driver);
        this.select = driver.findElement(By.xpath("//span[contains(text(),'" + type + "')]"));
    }

    void chooseOption(String textToFind) {
        select.click();
        log.info("Открыли селектор");
        driver.findElement(By.xpath("//div[contains(@class, 'ui-dropdown-field-list')]/div/div/div/span[text()='" + textToFind + "']")).click();
        log.info("Выбрали опцию " + textToFind);
    }
}
