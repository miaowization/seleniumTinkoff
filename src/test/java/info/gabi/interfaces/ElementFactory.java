package info.gabi.interfaces;

import org.openqa.selenium.WebElement;

public interface ElementFactory {
    <E extends BaseElement> E create(Class<E> elementClass, WebElement wrappedElement);
}