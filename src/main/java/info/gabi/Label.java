package info.gabi;

import lombok.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Data
class Label extends BaseElement {
    private WebElement label;

    Label(String locator, WebDriver driver) {
        super(driver);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
        this.label = driver.findElement(By.xpath(locator));
    }

    String getText() {
        label = getLabel();
        return label.getText();
    }

    @Override
    protected void refreshElement() {
        this.label = super.refreshElement(this.getLabel());
    }

}
