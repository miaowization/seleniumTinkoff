package info.gabi.tests;

import info.gabi.BaseRunner;
import info.gabi.pages.TinkoffCareerPage;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class TinkoffCareerTests extends BaseRunner {

    private TinkoffCareerPage careerPage;

    @Test
    public void clickFormFieldsAndCheckErrorMessages() {
        careerPage = new TinkoffCareerPage(getDriver());
        careerPage.open();
        careerPage.clickAllFields();
        careerPage.pressSendButton();
        careerPage.checkAllErrors("Поле обязательное");
    }

    @Test
    public void fillFormFieldsAndCheckErrorMessages() {
        careerPage = new TinkoffCareerPage(getDriver());
        careerPage.open();
        careerPage.fillName("wreglkjernguoq3h4j3msgw");
        careerPage.fillPhone("2340592374598");
        careerPage.fillCity("409517u2ierqhnkfj");
        careerPage.fillBirthday("q48qirhgnqkj349j23fkwf");
        careerPage.fillEmail("2390figvodnsflkvafaasdfaf");

        careerPage.clickAllFields();
        careerPage.checkNameError("Допустимо использовать только буквы русского алфавита и дефис");
        careerPage.checkPhoneError("Код города/оператора должен начинаться с цифры 3, 4, 5, 6, 8, 9");
        careerPage.checkBirthdayError("Поле заполнено некорректно");
        careerPage.checkEmailError("Введите корректный адрес эл. почты");

        careerPage.fillPhone("234");
        careerPage.fillName("ащшокашщцоуаылватфдыатлв");

        careerPage.clickAllFields();

        careerPage.checkPhoneError("Номер телефона должен состоять из 10 цифр, начиная с кода оператора");
        careerPage.checkNameError("Необходимо ввести фамилию и имя через пробел");
    }
}
