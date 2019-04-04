package info.gabi.impl;

import info.gabi.interfaces.Select;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@Slf4j
public class SelectImpl extends AbstractElement implements Select {
    protected SelectImpl(WebElement wrappedElement) {
        super(wrappedElement);
    }

    @Override
    public void click() {
        wrappedElement.click();
    }

    public void chooseOption(String textToFind) {
        wrappedElement.click();
        log.info("Открыли селектор");
//        WebDriverWait wait = new WebDriverWait(driver, 10);
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(), '" + textToFind + "')]")));
        log.info("Выбрали опцию " + textToFind);
        wrappedElement.sendKeys(textToFind);
//        try {
//
//            driver.findElement(By.xpath("(//*[(text()='" + textToFind + "')])[2]")).click();
//        } catch (Exception ex) {
//            driver.findElement(By.xpath("//*[contains(text(), '" + textToFind + "')]")).click();
//        }
    }

    void setText(String text) {
        wrappedElement.sendKeys(text);
    }
}
