package info.gabi.pages;

import info.gabi.impl.ExtendedFieldDecorator;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

@Data
@NoArgsConstructor
public abstract class AbstractBasePage {

    @NonNull
    private WebDriver driver;
    protected WebDriverWait wait;

    public final SoftAssertions softly = new SoftAssertions();

    public void init() {
        PageFactory.initElements(new ExtendedFieldDecorator(getDriver()), this);
        wait = new WebDriverWait(driver, 10);
    }

    public abstract void open();

    public void wait(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void waitForPageToLoad() {
        wait.until(d -> !d.getTitle().isEmpty());
    }

    Integer getInteger(String str) {
        str = str.replaceAll("\\D", "");
        return Integer.parseInt(str);
    }
}
