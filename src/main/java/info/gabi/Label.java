package info.gabi;

import lombok.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@Data
class Label extends BaseElement {
    private WebElement label;

    Label(String locator, WebDriver driver) {
        super(driver);
        this.label = driver.findElement(By.xpath(locator));
    }

    String getText() {
        label = getLabel();
        return label.getText();
    }

    @Override
    protected void refreshElement() {
        this.setLabel(super.refreshElement(this.getLabel()));
    }

}
