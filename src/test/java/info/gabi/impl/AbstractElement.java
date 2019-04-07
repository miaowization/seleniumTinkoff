package info.gabi.impl;

import info.gabi.BaseRunner;
import info.gabi.interfaces.BaseElement;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@Slf4j
abstract class AbstractElement implements BaseElement {
    final WebElement wrappedElement;
    protected WebDriver driver;
    WebDriverWait wait;

    AbstractElement(final WebElement wrappedElement) {
        this.driver = BaseRunner.getInstance();
        wait = new WebDriverWait(driver, 3);
        this.wrappedElement = wrappedElement;
    }

    @Override
    public boolean isDisplayed() {
        return wrappedElement.isDisplayed();
    }

    @Override
    public void click() {
        wait.until(ExpectedConditions.visibilityOf(wrappedElement));
        wrappedElement.click();
    }

    @Override
    public String getBy() {
        String[] arr = wrappedElement.toString().split("->");
        String xpath = arr[1].split(":")[1].trim();
        xpath = xpath.split("]")[0] + "]";
        return xpath;
    }


}