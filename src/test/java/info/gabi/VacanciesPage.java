package info.gabi;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@Getter
@Setter
public class VacanciesPage {

    private WebElement birthday;
    private WebElement city;
    private WebElement email;
    private WebElement phone;
    private WebElement name;
    private WebElement sendButton;


    private WebElement checkBox;
    private WebElement nameError;
    private WebElement birthdayError;
    private WebElement cityError;
    private WebElement emailError;
    private WebElement phoneError;
    private WebElement cvError;
    private WebElement checkBoxError;


    VacanciesPage(WebDriver driver) {
        name = driver.findElement(By.name("name"));
        birthday = driver.findElement(By.name("birthday"));
        city = driver.findElement(By.name("city"));
        email = driver.findElement(By.name("email"));
        phone = driver.findElement(By.name("phone"));
        checkBox = driver.findElement(By.cssSelector("svg.ui-icon-checkbox.ui-checkbox__icon"));
        sendButton = driver.findElement(By.xpath("//button[@type='submit']"));
    }

}
