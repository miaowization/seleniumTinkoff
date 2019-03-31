package info.gabi;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Getter
class Button extends BaseElement {

    private WebElement button;

    Button(String locator, WebDriver driver) {
        super(driver);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
        this.button = driver.findElement(By.xpath(locator));
    }

    void click() {
        button.click();
    }

    @Override
    void refreshElement() {
        this.button = super.refreshElement(this.button);
    }

    String getText() {
        return this.button.getText();
    }

}
