package info.gabi;


import lombok.Getter;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Getter
public class TextInput extends BaseElement {
    private WebElement textInput;

    TextInput(String locator, WebDriver driver) {
        super(driver);
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='" + locator + "']/../input")));
            this.textInput = driver.findElement(By.xpath("//div[text()='" + locator + "']/../input"));
        } catch (WebDriverException e) {
            this.textInput = driver.findElement(By.xpath("//input[@name='" + locator + "']"));
        }
    }

    void setText(String text) {
        textInput.sendKeys(text);
    }

    public String getText() {
        return textInput.getText();
    }

    void click() {
        textInput.click();
    }

    void clear() {
        textInput.sendKeys(Keys.chord(Keys.SHIFT, Keys.UP));
        textInput.sendKeys(Keys.BACK_SPACE);
        textInput.sendKeys(Keys.chord(Keys.SHIFT, Keys.DOWN));
        textInput.sendKeys(Keys.BACK_SPACE);
    }

    void refreshElement() {
        this.textInput = super.refreshElement(this.textInput);
    }

}
