package info.gabi;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TextInput extends BaseElement {
    private WebElement textInput;

    TextInput(String locator, WebDriver driver) {
        super(driver);
        this.textInput = driver.findElement(By.xpath("//div[text()='" + locator + "']/../input"));
    }

    //- заполнение поля
    //- получение текущего значения

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
        while (textInput.getAttribute("value").length() > 0) {
            textInput.sendKeys(Keys.chord(Keys.SHIFT, Keys.UP));
            textInput.sendKeys(Keys.BACK_SPACE);
            textInput.sendKeys(Keys.chord(Keys.SHIFT, Keys.DOWN));
            textInput.sendKeys(Keys.BACK_SPACE);
        }
    }

    void clearPhoneField() {
        while (!textInput.getAttribute("value").contentEquals("+7(")) {
            textInput.sendKeys(Keys.chord(Keys.SHIFT, Keys.UP));
            textInput.sendKeys(Keys.BACK_SPACE);
            textInput.sendKeys(Keys.chord(Keys.SHIFT, Keys.DOWN));
            textInput.sendKeys(Keys.BACK_SPACE);
        }
    }

}
