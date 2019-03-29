package info.gabi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

class Label extends BaseElement {
    private WebElement label;

    Label(String locator, WebDriver driver) {
        super(driver);
        this.label = driver.findElement(By.xpath(locator));
    }

    String getText() {
        return label.getText();
    }
}
