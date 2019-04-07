package info.gabi.pages;

import info.gabi.interfaces.Button;
import info.gabi.interfaces.CheckBox;
import info.gabi.interfaces.Label;
import info.gabi.interfaces.TextInput;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@Slf4j
public class TinkoffCareerPage extends AbstractBasePage {

    public TinkoffCareerPage(WebDriver driver) {
        setDriver(driver);
        init();
    }

    public void clickAllFields() {
        name.click();
        log.info("Кликнули по полю 'Фамилия и имя'");
        birthday.click();
        log.info("Кликнули по полю 'Дата рождения'");
        city.click();
        log.info("Кликнули по полю 'Город проживания'");
        email.click();
        log.info("Кликнули по полю 'Электронная почта'");
        phone.click();
        log.info("Кликнули по полю 'Мобильный телефон'");
        agreement.setActive(false);
        log.info("Деактивировали чекбокс 'Согласие с условиями'");
    }

    public void fillName(String text) {
        name.clearAndType(text);
        log.info("Заполнили поле 'Имя' значением {0}", text);
    }

    public void fillPhone(String text) {
        phone.clearAndType(text);
        log.info("Заполнили поле 'Мобильный телефон' значением {0}", text);
    }

    public void fillCity(String text) {
        city.clearAndType(text);
        log.info("Заполнили поле 'Город' значением {0}", text);
    }

    public void fillBirthday(String text) {
        birthday.clearAndType(text);
        log.info("Заполнили поле 'Дата рождения' значением {0}", text);
    }

    public void fillEmail(String text) {
        email.clearAndType(text);
        log.info("Заполнили поле 'Электронная почта' значением {0}", text);
    }

    public void pressSendButton() {
        send.click();
        log.info("Нажали кнопку 'Отправить'");
    }

    public void checkNameError(String text) {
        softly.assertThat(nameError.getText()).isEqualTo(text);
        softly.assertAll();
        log.info("Проверили текст ошибки для поля 'Имя'");
    }

    public void checkPhoneError(String text) {
        softly.assertThat(phoneError.getText()).isEqualTo(text);
        softly.assertAll();
        log.info("Проверили текст ошибки для поля 'Телефон'");
    }

    public void checkCityError(String text) {
        softly.assertThat(cityError.getText()).isEqualTo(text);
        softly.assertAll();
        log.info("Проверили текст ошибки для поля 'Город'");
    }

    public void checkBirthdayError(String text) {
        softly.assertThat(birthdayError.getText()).isEqualTo(text);
        softly.assertAll();
        log.info("Проверили текст ошибки для поля 'Дата рождения'");
    }

    public void checkEmailError(String text) {
        softly.assertThat(emailError.getText()).isEqualTo(text);
        softly.assertAll();
        log.info("Проверили текст ошибки для поля 'Город'");
    }


    public void checkAllErrors(String errorMessage) {
        softly.assertThat(nameError.getText())
                .isEqualTo(errorMessage);
        softly.assertThat(birthdayError.getText())
                .isEqualTo(errorMessage);
        softly.assertThat(cityError.getText())
                .isEqualTo(errorMessage);
        softly.assertThat(emailError.getText())
                .isEqualTo(errorMessage);
        softly.assertThat(phoneError.getText())
                .isEqualTo(errorMessage);
        softly.assertThat(cvError.getText())
                .isEqualTo(errorMessage);
        softly.assertThat(checkboxError.getText())
                .isEqualTo(errorMessage);
        softly.assertAll();
        log.info("Проверили ошибки для всех полей");
    }

    @Override
    public void open() {
        getDriver().navigate().to("https://www.tinkoff.ru/career/vacancies/");
        log.info("Открыли страницу Тинькофф Вакансии");
        waitForPageToLoad();
    }

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

    @FindBy(xpath = "//input[@name='name']/../ancestor::div[contains(@class,'ui-form__field')]/div[@class='ui-form-field-error-message ui-form-field-error-message_ui-form']")
    private Label nameError;

    @FindBy(xpath = "//input[@name='birthday']/../ancestor::div[contains(@class,'ui-form__field')]/div[@class='ui-form-field-error-message ui-form-field-error-message_ui-form']")
    private Label birthdayError;

    @FindBy(xpath = "//input[@name='email']/../ancestor::div[contains(@class,'ui-form__field')]/div[@class='ui-form-field-error-message ui-form-field-error-message_ui-form']")
    private Label emailError;

    @FindBy(xpath = "//input[@name='city']/../ancestor::div[contains(@class,'ui-form__field')]/div[@class='ui-form-field-error-message ui-form-field-error-message_ui-form']")
    private Label cityError;

    @FindBy(xpath = "//input[@name='phone']/../ancestor::div[contains(@class,'ui-form__field')]/div[@class='ui-form-field-error-message ui-form-field-error-message_ui-form']")
    private Label phoneError;

    @FindBy(xpath = "//div[@class='ui-upload']/parent::div/div[@class='ui-form-field-error-message ui-form-field-error-message_ui-form']")
    private Label cvError;

    @FindBy(xpath = "//div[contains(@class, 'ui-checkbox')]/../div[@class='ui-form-field-error-message ui-form-field-error-message_ui-form']")
    private Label checkboxError;
}
