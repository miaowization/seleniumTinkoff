package info.gabi.impl;

import info.gabi.interfaces.Select;
import org.openqa.selenium.WebElement;

public class SelectImpl extends AbstractElement implements Select {
    protected SelectImpl(WebElement wrappedElement) {
        super(wrappedElement);
    }

    @Override
    public void click() {
        wrappedElement.click();
    }
}
