package info.gabi.impl;

import info.gabi.interfaces.CheckBox;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Slf4j
public class CheckBoxImpl extends AbstractElement implements CheckBox {
    public CheckBoxImpl(WebElement wrappedElement) {
        super(wrappedElement);
    }

    @Override
    public void setActive(boolean active) {
        wait.until(ExpectedConditions.visibilityOf(wrappedElement));
        boolean selected = isSelected();
        if (active) {
            if (!selected)
                wrappedElement.click();
            else if (selected)
                log.info("Чекбокс уже активирован");
        } else {
            if (!selected)
                log.info("Чекбокс уже деактивирован");
            else if (selected)
                wrappedElement.click();
        }
    }

    private boolean isSelected() {
        WebElement parent;
        try {
            String parentStr = getBy() + "/ancestor::label";
            parent = driver.findElement(By.xpath(parentStr));
        } catch (WebDriverException e) {
            String parentStr = getBy() + "/../div";
            parent = driver.findElement(By.xpath(parentStr));
        }
        return parent.getAttribute("class").contains("checked") || parent.getAttribute("checked") != null;
    }

    public String getText() {
        wait.until(ExpectedConditions.visibilityOf(wrappedElement));
        return wrappedElement.getText();
    }

}
