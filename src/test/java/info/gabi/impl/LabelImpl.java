package info.gabi.impl;

import info.gabi.interfaces.Label;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LabelImpl extends AbstractElement implements Label {
    public LabelImpl(WebElement wrappedElement) {
        super(wrappedElement);
    }

    @Override
    public String getText() {
        wait.until(ExpectedConditions.visibilityOf(wrappedElement));
        return wrappedElement.getText();
    }
}
