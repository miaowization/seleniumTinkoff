package info.gabi.impl;

import info.gabi.interfaces.Button;
import org.openqa.selenium.WebElement;

class ButtonImpl extends AbstractElement implements Button {
    protected ButtonImpl(final WebElement wrappedElement) {
        super(wrappedElement);
    }

    @Override
    public void click() {
        wrappedElement.click();
    }
}
