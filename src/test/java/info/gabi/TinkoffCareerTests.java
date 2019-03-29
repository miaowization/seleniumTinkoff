package info.gabi;

import org.assertj.core.api.JUnitSoftAssertions;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.By;

public class TinkoffCareerTests extends TestMethods {

    @Rule
    public JUnitSoftAssertions softly = new JUnitSoftAssertions();
    private Label nameError;
    private Label birthdayError;
    private Label emailError;
    private Label phoneError;


    @Before
    public void init() throws InterruptedException {
        driver.get(baseUrl);
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[contains(text(),'" + "согласен" + "')]/ancestor::label/div"));
        CheckBox checkBox = new CheckBox("согласен", driver);
        checkBox.setActive(false);
        checkBox.click();
        Button sendButton = new Button("//button[@type='submit']", driver);
        sendButton.click();
    }

    @Test
    public void clickFormFieldsAndCheckErrorMessages() {

        TextInput nameField = new TextInput("//input[@name='name']", driver);
        TextInput birthdayField = new TextInput("//input[@name='birthday']", driver);
        TextInput cityField = new TextInput("//input[@name='city']", driver);
        TextInput emailField = new TextInput("//input[@name='email']", driver);
        TextInput phoneField = new TextInput("//input[@name='phone']", driver);
        CheckBox checkBox = new CheckBox("//div[contains(@class,'ui-checkbox__check')]", driver);
        Button sendButton = new Button("//button[@type='submit']", driver);

        nameField.click();
        birthdayField.click();
        cityField.click();
        emailField.click();
        phoneField.click();
        checkBox.setActive(false);
        sendButton.click();

        nameError = new Label("//span[contains(text(), 'Фамилия')]/ancestor::div[contains(@class, 'ui-input_error')]/../../div[2]", driver);
        birthdayError = new Label("//span[contains(text(), 'Дата')]/ancestor::div[contains(@class, 'ui-input_error')]/../../div[2]", driver);
        emailError = new Label("//span[contains(text(), 'почта')]/ancestor::div[contains(@class, 'ui-input_error')]/../div[2]", driver);
        Label cityError = new Label("//span[contains(text(), 'Город')]/ancestor::div[contains(@class, 'ui-input_error')]/../../div[2]", driver);
        phoneError = new Label("//span[contains(text(), 'телефон')]/ancestor::div[contains(@class, 'ui-input_error')]/../div[2]", driver);
        Label cvError = new Label("//div[@class='ui-upload']/parent::div/div[2]", driver);
        Label checkboxError = new Label("//div[contains(@class, 'ui-checkbox')]/../div[2]", driver);

        softly.assertThat(nameError.getText()).isEqualTo("Поле обязательное");
        softly.assertThat(birthdayError.getText()).isEqualTo("Поле обязательное");
        softly.assertThat(cityError.getText()).isEqualTo("Поле обязательное");
        softly.assertThat(emailError.getText()).isEqualTo("Поле обязательное");
        softly.assertThat(phoneError.getText()).isEqualTo("Поле обязательное");
        softly.assertThat(cvError.getText()).isEqualTo("Поле обязательное");
        softly.assertThat(checkboxError.getText()).isEqualTo("Поле обязательное");
    }

    @Test
    public void fillFormFieldsAndCheckErrorMessages() {
        TextInput nameField = new TextInput("name", driver);
        TextInput birthdayField = new TextInput("birthday", driver);
        TextInput cityField = new TextInput("city", driver);
        TextInput emailField = new TextInput("email", driver);
        TextInput phoneField = new TextInput("phone", driver);

        nameField.setText("wreglkjernguoq3h4j3msgw");
        phoneField.click();
        nameError = new Label("//span[contains(text(), 'Фамилия')]/ancestor::div[contains(@class, 'ui-input_error')]/../../div[2]", driver);
        softly.assertThat(nameError.getText()).isEqualTo("Допустимо использовать только буквы русского алфавита и дефис");

        nameField.click();

        nameField.clear();

        nameField.setText("ащшокашщцоуаылватфдыатлв");
        birthdayField.click();

        nameError = new Label("//span[contains(text(), 'Фамилия')]/ancestor::div[contains(@class, 'ui-input_error')]/../../div[2]", driver);
        softly.assertThat(nameError.getText()).isEqualTo("Необходимо ввести фамилию и имя через пробел");

        birthdayField.setText("q48qirhgnqkj349j23fkwf");
        cityField.setText("409517u2ierqhnkfj");
        emailField.setText("2390figvodnsflkvafaasdfaf");
        nameField.click();
        birthdayError = new Label("//span[contains(text(), 'Дата')]/ancestor::div[contains(@class, 'ui-input_error')]/../../div[2]", driver);
        emailError = new Label("//span[contains(text(), 'почта')]/ancestor::div[contains(@class, 'ui-input_error')]/../div[2]", driver);

        phoneField.setText("2340592374598");
        nameField.click();
        phoneError = new Label("//span[contains(text(), 'телефон')]/ancestor::div[contains(@class, 'ui-input_error')]/../div[2]", driver);
        softly.assertThat(phoneError.getText()).isEqualTo("Код города/оператора должен начинаться с цифры 3, 4, 5, 6, 8, 9");

        phoneField.click();
        phoneField.clearPhoneField();

        phoneField.setText("234");
        nameField.click();
        phoneError = new Label("//span[contains(text(), 'телефон')]/ancestor::div[contains(@class, 'ui-input_error')]/../div[2]", driver);

        softly.assertThat(phoneError.getText()).isEqualTo("Номер телефона должен состоять из 10 цифр, начиная с кода оператора");
        softly.assertThat(birthdayError.getText()).isEqualTo("Поле заполнено некорректно");
        softly.assertThat(emailError.getText()).isEqualTo("Введите корректный адрес эл. почты");
    }
}
