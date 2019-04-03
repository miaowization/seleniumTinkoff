package info.gabi.pages;

import info.gabi.interfaces.Button;
import info.gabi.interfaces.CheckBox;
import info.gabi.ExtendedFieldDecorator;
import info.gabi.interfaces.TextInput;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TinkoffCareerPage implements BasePage {

    //            this.textInput = driver.findElement(By.xpath("//div[text()='" + locator + "']/../input"));
//        } catch (WebDriverException e) {
//            this.textInput = driver.findElement(By.xpath("//input[@name='" + locator + "']"));
//        }
//    TextInput nameField = new TextInput("name", driver);
//    TextInput birthdayField = new TextInput("birthday", driver);
//    TextInput cityField = new TextInput("city", driver);
//    TextInput emailField = new TextInput("email", driver);
//    TextInput phoneField = new TextInput("phone", driver);
//    CheckBox checkBox = new CheckBox("согласен", driver);
//    Button sendButton = new Button("//button[@type='submit']", driver);

    @FindBy(xpath = "//button[@type='submit']")
    private Button send;

    @FindBy(xpath = "//input[@name='name']")
    private TextInput name;

    @FindBy(xpath = "//input[@name='birthday']")
    private TextInput birthday;

    @FindBy(xpath = "//input[@name='city']")
    private TextInput city;

    @FindBy(xpath = "//input[@name='email']")
    private TextInput email;

    @FindBy(xpath = "//input[@name='phone']")
    private TextInput phone;

    @FindBy(xpath = "//*[contains(text(),'согласен')]/ancestor::label/div")
    private CheckBox agreement;

    public void clickAllAndPressButton() {
        name.click();
        birthday.click();
        city.click();
        email.click();
        phone.click();
        agreement.setActive(false);
        send.click();
    }

    @Override
    public void init(final WebDriver driver) {
        PageFactory.initElements(new ExtendedFieldDecorator(driver), this);
    }
}
