import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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

    public WebElement sendButton() {
        return sendButton;
    }

    public WebElement checkBox() {
        return checkBox;
    }

    public void setNameError(WebElement nameError) {
        this.nameError = nameError;
    }

    public void setBirthdayError(WebElement birthdayError) {
        this.birthdayError = birthdayError;
    }

    public void setCityError(WebElement cityError) {
        this.cityError = cityError;
    }

    public void setEmailError(WebElement emailError) {
        this.emailError = emailError;
    }

    public void setPhoneError(WebElement phoneError) {
        this.phoneError = phoneError;
    }

    public void setCvError(WebElement cvError) {
        this.cvError = cvError;
    }

    public void setCheckBoxError(WebElement checkBoxError) {
        this.checkBoxError = checkBoxError;
    }

    public WebElement nameError() {
        return nameError;
    }

    public WebElement birthdayError() {
        return birthdayError;
    }

    public WebElement cityError() {
        return cityError;
    }

    public WebElement emailError() {
        return emailError;
    }

    public WebElement phoneError() {
        return phoneError;
    }

    public WebElement cvError() {
        return cvError;
    }

    public WebElement checkBoxError() {
        return checkBoxError;
    }

    public WebElement birthday() {
        return birthday;
    }

    public WebElement city() {
        return city;
    }

    public WebElement email() {
        return email;
    }

    public WebElement phone() {
        return phone;
    }

    public WebElement name() {
        return name;
    }

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
