package info.gabi;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@Slf4j
@RequiredArgsConstructor
@Getter
abstract public class BaseElement {
    @NonNull
    protected WebDriver driver;

    abstract void refreshElement();

    protected WebElement refreshElement(WebElement element) {
        WebElement element1 = null;
        if (!isElementStale(element))
            return element;
        try {
            String[] arr = element.toString().split("->");

            String xpath = arr[1].split(":")[1].trim();

            xpath = xpath.split("]")[0] + "]";
            log.info(xpath);
            element1 = driver.findElement(By.xpath(xpath));
        } catch (Exception e) {
            log.error("Error in Refreshing the stale Element.");
            log.error(e.getMessage());
        }
        return element1;
    }

    public boolean isElementStale(WebElement e) {
        try {
            e.isDisplayed();
            return false;
        } catch (StaleElementReferenceException ex) {
            return true;
        }
    }
}
