package info.gabi.impl;

import info.gabi.interfaces.Select;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Slf4j
public class SelectImpl extends AbstractElement implements Select {
    public SelectImpl(WebElement wrappedElement) {
        super(wrappedElement);
    }

    public void clickAndSelectOption(String textToFind) {
        wait.until(ExpectedConditions.visibilityOf(wrappedElement));
        wrappedElement.click();
        log.info("Открыли селектор");
        try {
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//*[(text()='" + textToFind + "')])[2]"))));
            driver.findElement(By.xpath("(//*[(text()='" + textToFind + "')])[2]")).click();
        } catch (Exception ex) {
            driver.findElement(By.xpath("//*[contains(text(), '" + textToFind + "')]")).click();
        }
        log.info("Выбрали опцию {}", textToFind);
    }

    private void type(String text) {
        wait.until(ExpectedConditions.visibilityOf(wrappedElement));
        wrappedElement.sendKeys(text);
    }


}
