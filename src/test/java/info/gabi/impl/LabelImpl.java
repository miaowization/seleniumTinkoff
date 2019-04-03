package info.gabi.impl;

import info.gabi.interfaces.Label;
import org.openqa.selenium.WebElement;

public class LabelImpl extends AbstractElement implements Label {
    protected LabelImpl(WebElement wrappedElement) {
        super(wrappedElement);
    }

    @Override
    public void click() {
        wrappedElement.click();
    }
}
