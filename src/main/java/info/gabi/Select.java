package info.gabi;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Setter
@Getter
@Slf4j
class Select extends BaseElement {

    private String type;

    Select(String type, WebDriver driver) {
        super(driver);
        this.type = type;
    }

    void chooseOption(String textToFind) {
        driver.findElement(By.xpath("//span[contains(text(),'" + type + "')]")).click();
        log.info("Открыли селектор " + type);
        driver.findElement(By.xpath("//div[contains(@class, 'ui-dropdown-field-list')]/div/div/div/span[text()='" + textToFind + "']")).click();
        log.info("Выбрали опцию " + textToFind);
    }
}
