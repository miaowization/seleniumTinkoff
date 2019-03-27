import org.assertj.core.api.JUnitSoftAssertions;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.By;

public class TinkoffCareerTests extends TestMethods {

  @Rule
  public JUnitSoftAssertions softly = new JUnitSoftAssertions();
  private VacanciesPage vacanciesPage;

  @Before
  public void init() {
    driver.get(baseUrl);
    vacanciesPage = new VacanciesPage(driver);
    if (vacanciesPage.getCheckBox().isEnabled())
      vacanciesPage.getCheckBox().click();
    vacanciesPage.getSendButton().click();

    vacanciesPage.setNameError(driver.findElement(By.xpath("//div[@class='ui-form__row ui-form__row_default-error-view-visible']//div[@class='ui-form-field-error-message ui-form-field-error-message_ui-form']")));
    vacanciesPage.setBirthdayError(driver.findElement(By.xpath("//div[@class='ui-form__row ui-form__row_date ui-form__row_default-error-view-visible']//div[@class='ui-form-field-error-message ui-form-field-error-message_ui-form']")));
    vacanciesPage.setEmailError(driver.findElement(By.xpath("//div[@class='ui-form__row ui-form__row_email schema__email_uTUlf ui-form__row_default-error-view-visible']/div/div[2]")));
    vacanciesPage.setCityError(driver.findElement(By.xpath("//div[@class='ui-form__row ui-form__row_dropdownRegion ui-form__row_default-error-view-visible']//div[@class='ui-form-field-error-message ui-form-field-error-message_ui-form']")));
    vacanciesPage.setPhoneError(driver.findElement(By.xpath("//div[@class='ui-form__row ui-form__row_tel ui-form__row_default-error-view-visible']//div[@class='ui-form-field-error-message ui-form-field-error-message_ui-form']")));
    vacanciesPage.setCheckBoxError(driver.findElement(By.xpath("//div[@class='ui-form__row ui-form__row_checkbox schema__checkbox_3-pEK ui-form__row_default-error-view-visible']//div[@class='ui-form-field-error-message ui-form-field-error-message_ui-form']")));
    vacanciesPage.setCvError(driver.findElement(By.xpath("//div[@class='ui-upload']/parent::div/div[2]")));
  }

  @Test
  public void clickFormFieldsAndCheckErrorMessages() {
    vacanciesPage.getName().click();
    vacanciesPage.getBirthday().click();
    vacanciesPage.getCity().click();
    vacanciesPage.getEmail().click();
    vacanciesPage.getPhone().click();
    driver.findElement(By.name("socialLink0")).click();

    if (vacanciesPage.getCheckBox().isSelected())
      vacanciesPage.getCheckBox().click();
    vacanciesPage.getSendButton().click();

    softly.assertThat(vacanciesPage.getNameError().getText()).isEqualTo("Поле обязательное");
    softly.assertThat(vacanciesPage.getBirthdayError().getText()).isEqualTo("Поле обязательное");
    softly.assertThat(vacanciesPage.getCityError().getText()).isEqualTo("Поле обязательное");
    softly.assertThat(vacanciesPage.getEmailError().getText()).isEqualTo("Поле обязательное");
    softly.assertThat(vacanciesPage.getPhoneError().getText()).isEqualTo("Поле обязательное");
    softly.assertThat(vacanciesPage.getCvError().getText()).isEqualTo("Поле обязательное");
    softly.assertThat(vacanciesPage.getCheckBoxError().getText()).isEqualTo("Поле обязательное");
  }

  @Test
  public void fillFormFieldsAndCheckErrorMessages() {
    vacanciesPage.getName().sendKeys("wreglkjernguoq3h4j3msgw");
    vacanciesPage.getPhone().click();
    vacanciesPage.setNameError(driver.findElement(By.xpath("//div[@class='ui-form__row ui-form__row_default-error-view-visible']//div[@class='ui-form-field-error-message ui-form-field-error-message_ui-form']")));
    softly.assertThat(vacanciesPage.getNameError().getText()).isEqualTo("Допустимо использовать только буквы русского алфавита и дефис");

    vacanciesPage.getName().click();

    clearField(vacanciesPage.getName());
    vacanciesPage.getName().sendKeys("ащшокашщцоуаылватфдыатлв");
    vacanciesPage.getBirthday().click();

    vacanciesPage.setNameError(driver.findElement(By.xpath("//div[@class='ui-form__row ui-form__row_default-error-view-visible']//div[@class='ui-form-field-error-message ui-form-field-error-message_ui-form']")));
    softly.assertThat(vacanciesPage.getNameError().getText()).isEqualTo("Необходимо ввести фамилию и имя через пробел");

    vacanciesPage.getBirthday().sendKeys("q48qirhgnqkj349j23fkwf");
    vacanciesPage.getCity().sendKeys("409517u2ierqhnkfj");
    vacanciesPage.getEmail().sendKeys("2390figvodnsflkvafaasdfaf");
    vacanciesPage.getName().click();
    vacanciesPage.setBirthdayError(driver.findElement(By.xpath("//div[@class='ui-form__row ui-form__row_date ui-form__row_default-error-view-visible']//div[@class='ui-form-field-error-message ui-form-field-error-message_ui-form']")));
    vacanciesPage.setEmailError(driver.findElement(By.xpath("//div[@class='ui-form__row ui-form__row_email schema__email_uTUlf ui-form__row_default-error-view-visible']/div/div[2]")));

    vacanciesPage.getPhone().sendKeys("2340592374598");
    vacanciesPage.getName().click();
    vacanciesPage.setPhoneError(driver.findElement(By.xpath("//div[@class='ui-form__row ui-form__row_tel ui-form__row_default-error-view-visible']//div[@class='ui-form-field-error-message ui-form-field-error-message_ui-form']")));
    softly.assertThat(vacanciesPage.getPhoneError().getText()).isEqualTo("Код города/оператора должен начинаться с цифры 3, 4, 5, 6, 8, 9");

    vacanciesPage.getPhone().click();
    clearPhoneField(vacanciesPage.getPhone());
    vacanciesPage.getPhone().sendKeys("234");
    vacanciesPage.getName().click();
    vacanciesPage.setPhoneError(driver.findElement(By.xpath("//div[@class='ui-form__row ui-form__row_tel ui-form__row_default-error-view-visible']//div[@class='ui-form-field-error-message ui-form-field-error-message_ui-form']")));

    softly.assertThat(vacanciesPage.getPhoneError().getText()).isEqualTo("Номер телефона должен состоять из 10 цифр, начиная с кода оператора");
    softly.assertThat(vacanciesPage.getBirthdayError().getText()).isEqualTo("Поле заполнено некорректно");
    softly.assertThat(vacanciesPage.getEmailError().getText()).isEqualTo("Введите корректный адрес эл. почты");
  }
}
