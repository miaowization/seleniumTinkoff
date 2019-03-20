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
        vacanciesPage.setNameError(driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Фамилия и имя'])[1]/following::div[2]")));
        vacanciesPage.setBirthdayError(driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Дата рождения'])[1]/following::div[3]")));
        vacanciesPage.setEmailError(driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Электронная почта'])[1]/following::div[2]")));
        vacanciesPage.setCityError(driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Город проживания'])[1]/following::div[3]")));
        vacanciesPage.setPhoneError(driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Мобильный телефон'])[1]/following::div[2]")));
        vacanciesPage.setCheckBoxError(driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='условиями передачи информации'])[1]/following::div[1]")));
        vacanciesPage.setCvError(driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='загрузите резюме/портфолио'])[1]/following::div[1]")));
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
        softly.assertThat(driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Фамилия и имя'])[1]/following::div[2]")).getText()).isEqualTo("Допустимо использовать только буквы русского алфавита и дефис");

        vacanciesPage.name().click();
        clear(vacanciesPage.name());
        vacanciesPage.name().sendKeys("ащшокашщцоуаылватфдыатлв");
        vacanciesPage.birthday().click();

        softly.assertThat(driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Фамилия и имя'])[1]/following::div[2]")).getText()).isEqualTo("Необходимо ввести фамилию и имя через пробел");

        vacanciesPage.birthday().sendKeys("q48qirhgnqkj349j23fkwf");
        vacanciesPage.city().sendKeys("409517u2ierqhnkfj");
        vacanciesPage.email().sendKeys("2390figvodnsflkvafaasdfaf");

        vacanciesPage.phone().sendKeys("2340592374598");
        vacanciesPage.name().click();
        softly.assertThat(driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Мобильный телефон'])[1]/following::div[2]")).getText()).isEqualTo("Код города/оператора должен начинаться с цифры 3, 4, 5, 6, 8, 9");

        vacanciesPage.phone().click();
        clearPhone(vacanciesPage.phone());
        vacanciesPage.phone().sendKeys("234");
        vacanciesPage.name().click();
        softly.assertThat(driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Мобильный телефон'])[1]/following::div[2]")).getText()).isEqualTo("Номер телефона должен состоять из 10 цифр, начиная с кода оператора");
        softly.assertThat(driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Дата рождения'])[1]/following::div[3]")).getText()).isEqualTo("Поле заполнено некорректно");
        softly.assertThat(driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Электронная почта'])[1]/following::div[2]")).getText()).isEqualTo("Введите корректный адрес эл. почты");
    }
}
