package info.gabi;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@Setter
@Getter
@Slf4j
class Select extends BaseElement {

    WebElement select;

    Select(String type, WebDriver driver) {
        super(driver);
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@title, '" + type + "')]")));
            this.select = driver.findElement(By.xpath("//*[contains(@title, '" + type + "')]"));
        } catch (WebDriverException e) {
            this.select = driver.findElement(By.xpath("//*[contains(text(),'" + type + "')]"));
        }
    }

    void chooseOption(String textToFind) {
        select = getSelect();
        select.click();
        log.info("Открыли селектор");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(), '" + textToFind + "')]")));
        log.info("Выбрали опцию " + textToFind);
        try {
            driver.findElement(By.xpath("(//*[(text()='" + textToFind + "')])[2]")).click();
        } catch (Exception ex) {
            driver.findElement(By.xpath("//*[contains(text(), '" + textToFind + "')]")).click();
        }
    }

    void setText(String text) {
        select.sendKeys(text);
    }

    @Override
    void refreshElement() {
        this.select = super.refreshElement(this.select);
    }
}
