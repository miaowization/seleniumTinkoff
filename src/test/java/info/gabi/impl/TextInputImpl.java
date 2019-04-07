package info.gabi.impl;

import info.gabi.interfaces.TextInput;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

@Slf4j
public class TextInputImpl extends AbstractElement implements TextInput {
    public TextInputImpl(final WebElement wrappedElement) {
        super(wrappedElement);
    }

    @Override
    public void type(final String text) {
        wait.ignoring(StaleElementReferenceException.class)
                .ignoring(ElementNotInteractableException.class)
                .until(d -> {
                    wrappedElement.sendKeys(text);
                    return true;
                });
    }

    @Override
    public void clear() {
        wrappedElement.sendKeys(Keys.chord(Keys.SHIFT, Keys.UP));
        wrappedElement.sendKeys(Keys.BACK_SPACE);
        wrappedElement.sendKeys(Keys.chord(Keys.SHIFT, Keys.DOWN));
        wrappedElement.sendKeys(Keys.BACK_SPACE);
    }

    @Override
    public void clearAndType(final String text) {
        clear();
        type(text);
    }
}

