package info.gabi.pages;

import info.gabi.impl.ButtonImpl;
import info.gabi.interfaces.Button;
import info.gabi.interfaces.TextInput;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@Slf4j
public class GooglePage extends AbstractBasePage {

    public GooglePage(WebDriver driver) {
        setDriver(driver);
        init();
    }

    @Override
    public void open() {
        getDriver().navigate().to("https://google.ru");
        waitForPageToLoad();
    }

    @FindBy(xpath = "//input[@title='Поиск']")
    private TextInput queryLine;

    public void searchFor(String option) {
        queryLine.type(option);
        log.info("Ввели текст {} в строку поиска", option);
        wait(1);
        getDriver().findElement(By.xpath("//*[contains(text(),'" + option + "')]")).click();
        log.info("Выбрали опцию {} из выпадающего списка", option);
    }

    public void chooseLinkFromSearchResults(String link) {
        Button linkTo = new ButtonImpl(getDriver().findElement(By.xpath("//a[contains(@href,'" + link + "')]")));
        linkTo.click();
        log.info("Перешли по ссылке {}", link);
        wait(2);
    }
}
