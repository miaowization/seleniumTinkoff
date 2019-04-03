package info.gabi.impl;

import info.gabi.interfaces.CheckBox;
import org.openqa.selenium.WebElement;

public class CheckBoxImpl extends AbstractElement implements CheckBox {
    protected CheckBoxImpl(WebElement wrappedElement) {
        super(wrappedElement);
    }

    @Override
    public void setActive(boolean active) {

    }

    @Override
    public void click() {
        wrappedElement.click();
    }
}
