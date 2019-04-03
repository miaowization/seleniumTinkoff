package info.gabi.impl;

import info.gabi.interfaces.TextInput;
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
        wrappedElement.clear();
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

