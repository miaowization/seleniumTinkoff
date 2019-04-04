package info.gabi.impl;

import info.gabi.interfaces.TextInput;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

class TextInputImpl extends AbstractElement implements TextInput {
    protected TextInputImpl(final WebElement wrappedElement) {
        super(wrappedElement);
    }

    @Override
    public void type(final String text) {
        wrappedElement.sendKeys(text);
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

    @Override
    public void click() {
        wrappedElement.click();
    }
}

