import org.assertj.core.api.JUnitSoftAssertions;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.By;

public class TinkoffCareerTests extends BaseRunner {

  @Rule
  public JUnitSoftAssertions softly = new JUnitSoftAssertions();
  private VacanciesPage vacanciesPage;

  @Before
  public void init() {
    driver.get(baseUrl);
    vacanciesPage = new VacanciesPage(driver);
    if (vacanciesPage.checkBox().isEnabled())
      vacanciesPage.checkBox().click();
    vacanciesPage.sendButton().click();

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
    vacanciesPage.name().click();
    vacanciesPage.birthday().click();
    vacanciesPage.city().click();
    vacanciesPage.email().click();
    vacanciesPage.phone().click();
    driver.findElement(By.name("socialLink0")).click();

    if (vacanciesPage.checkBox().isSelected())
      vacanciesPage.checkBox().click();
    vacanciesPage.sendButton().click();

    softly.assertThat(vacanciesPage.nameError().getText()).isEqualTo("Поле обязательное");
    softly.assertThat(vacanciesPage.birthdayError().getText()).isEqualTo("Поле обязательное");
    softly.assertThat(vacanciesPage.cityError().getText()).isEqualTo("Поле обязательное");
    softly.assertThat(vacanciesPage.emailError().getText()).isEqualTo("Поле обязательное");
    softly.assertThat(vacanciesPage.phoneError().getText()).isEqualTo("Поле обязательное");
    softly.assertThat(vacanciesPage.cvError().getText()).isEqualTo("Поле обязательное");
    softly.assertThat(vacanciesPage.checkBoxError().getText()).isEqualTo("Поле обязательное");
  }

  @Test
  public void fillFormFieldsAndCheckErrorMessages() {
    vacanciesPage.name().sendKeys("wreglkjernguoq3h4j3msgw");
    vacanciesPage.phone().click();
    vacanciesPage.setNameError(driver.findElement(By.xpath("//div[@class='ui-form__row ui-form__row_default-error-view-visible']//div[@class='ui-form-field-error-message ui-form-field-error-message_ui-form']")));
    softly.assertThat(vacanciesPage.nameError().getText()).isEqualTo("Допустимо использовать только буквы русского алфавита и дефис");

    vacanciesPage.name().click();
    clear(vacanciesPage.name());
    vacanciesPage.name().sendKeys("ащшокашщцоуаылватфдыатлв");
    vacanciesPage.birthday().click();

    vacanciesPage.setNameError(driver.findElement(By.xpath("//div[@class='ui-form__row ui-form__row_default-error-view-visible']//div[@class='ui-form-field-error-message ui-form-field-error-message_ui-form']")));
    softly.assertThat(vacanciesPage.nameError().getText()).isEqualTo("Необходимо ввести фамилию и имя через пробел");

    vacanciesPage.birthday().sendKeys("q48qirhgnqkj349j23fkwf");
    vacanciesPage.city().sendKeys("409517u2ierqhnkfj");
    vacanciesPage.email().sendKeys("2390figvodnsflkvafaasdfaf");
    vacanciesPage.name().click();
    vacanciesPage.setBirthdayError(driver.findElement(By.xpath("//div[@class='ui-form__row ui-form__row_date ui-form__row_default-error-view-visible']//div[@class='ui-form-field-error-message ui-form-field-error-message_ui-form']")));
    vacanciesPage.setEmailError(driver.findElement(By.xpath("//div[@class='ui-form__row ui-form__row_email schema__email_uTUlf ui-form__row_default-error-view-visible']/div/div[2]")));

    vacanciesPage.phone().sendKeys("2340592374598");
    vacanciesPage.name().click();
    vacanciesPage.setPhoneError(driver.findElement(By.xpath("//div[@class='ui-form__row ui-form__row_tel ui-form__row_default-error-view-visible']//div[@class='ui-form-field-error-message ui-form-field-error-message_ui-form']")));
    softly.assertThat(vacanciesPage.phoneError().getText()).isEqualTo("Код города/оператора должен начинаться с цифры 3, 4, 5, 6, 8, 9");

    vacanciesPage.phone().click();
    clearPhone(vacanciesPage.phone());
    vacanciesPage.phone().sendKeys("234");
    vacanciesPage.name().click();
    vacanciesPage.setPhoneError(driver.findElement(By.xpath("//div[@class='ui-form__row ui-form__row_tel ui-form__row_default-error-view-visible']//div[@class='ui-form-field-error-message ui-form-field-error-message_ui-form']")));

    softly.assertThat(vacanciesPage.phoneError().getText()).isEqualTo("Номер телефона должен состоять из 10 цифр, начиная с кода оператора");
    softly.assertThat(vacanciesPage.birthdayError().getText()).isEqualTo("Поле заполнено некорректно");
    softly.assertThat(vacanciesPage.emailError().getText()).isEqualTo("Введите корректный адрес эл. почты");
  }
}
