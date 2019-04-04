package info.gabi.pages;

import org.assertj.core.api.JUnitSoftAssertions;
import org.openqa.selenium.WebDriver;

public interface BasePage {
    JUnitSoftAssertions softly = new JUnitSoftAssertions();
    void init(WebDriver driver);
}
