package info.gabi.impl;

import info.gabi.interfaces.Button;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ButtonImpl extends AbstractElement implements Button {
    public ButtonImpl(final WebElement wrappedElement) {
        super(wrappedElement);
    }

    @Override
    public String getText() {
        wait.until(ExpectedConditions.visibilityOf(wrappedElement));
        return wrappedElement.getText();
    }

    @Override
    public boolean isClickable() {
        return wrappedElement.isEnabled();
    }
}
