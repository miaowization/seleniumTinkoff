package info.gabi.impl;

import info.gabi.interfaces.BaseElement;
import org.openqa.selenium.WebElement;

abstract class AbstractElement implements BaseElement {
    protected final WebElement wrappedElement;

    protected AbstractElement(final WebElement wrappedElement) {
        this.wrappedElement = wrappedElement;
    }

    @Override
    public boolean isDisplayed() {
        return wrappedElement.isDisplayed();
    }

    @Override
    public void click() {
        wrappedElement.click();
    }
}