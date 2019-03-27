import org.assertj.core.api.JUnitSoftAssertions;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;

public class OtherTests extends TestMethods {

    @Rule
    public JUnitSoftAssertions softly = new JUnitSoftAssertions();

    @Test
    public void test1() throws InterruptedException {
        driver.get("https://google.ru");
        driver.findElement(By.xpath("//input[@title='Поиск']")).sendKeys("мобайл тинькофф");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(), 'тарифы')]")));
        driver.findElement(By.xpath("//*[contains(text(), 'тарифы')]")).click();
        driver.findElement(By.xpath("//a[contains(@href,'https://www.tinkoff.ru/mobile-operator/tariffs/')]")).click();
        Thread.sleep(1000);

        ArrayList<String> windows = new ArrayList<>(driver.getWindowHandles());

        driver.switchTo().window(windows.get(driver.getWindowHandles().size() - 1));
        softly.assertThat(driver.getTitle()).isEqualTo("Тарифы Тинькофф Мобайла");
        String currentTab = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(currentTab)) {
                driver.switchTo().window(handle);
                driver.close();
            }
        }
        driver.switchTo().window(currentTab);
        softly.assertThat(driver.getCurrentUrl()).isEqualTo("https://www.tinkoff.ru/mobile-operator/tariffs/");
    }

    @Test
    public void test2() {
        driver.get("https://www.tinkoff.ru/mobile-operator/tariffs/");
        if (driver.findElement(By.xpath("//*[contains(text(), 'Москва')]")).isDisplayed())
            driver.findElement(By.xpath("//*[text()='Да']")).click();
        softly.assertThat(driver.findElement(By.xpath("//div[@name='desktopMvnoRegionConfirmation']//div[(contains(text(),'Москва'))]"))
                .isDisplayed());
        String priceMoscow = driver.findElement(By.xpath("//h3[contains(text(),'Общая цена')]")).getText();
        driver.navigate().refresh();
        softly.assertThat(driver.findElement(By.xpath("//div[@name='desktopMvnoRegionConfirmation']//div[(contains(text(),'Москва'))]"))
                .isDisplayed());
        driver.findElement(By.xpath("//*[contains(text(), 'Москва')]")).click();
        driver.findElement(By.xpath("//div[text()='Город']/../input")).sendKeys("Краснодар");
        driver.findElement(By.xpath("//*[contains(text(), 'Краснодар')]")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@name='desktopMvnoRegionConfirmation']//div[(contains(text(),'Краснодарский край'))]")));
        softly.assertThat(driver.findElement(By.xpath("//div[@name='desktopMvnoRegionConfirmation']//div[(contains(text(),'Краснодарский край'))]"))
                .isDisplayed());

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h3[contains(text(),'Общая цена')]")));
        String priceKrasnodar = driver.findElement(By.xpath("//h3[contains(text(),'Общая цена')]")).getText();

        System.out.println("Москва " + priceMoscow + " Краснодар " + priceKrasnodar);

        softly.assertThat(!getInteger(priceMoscow).equals(getInteger(priceKrasnodar)));

        WebElement element = driver.findElement(By.xpath("//label[contains(text(),'Мессенджеры')]/../div"));


        if (!driver.findElement(By.xpath("//label[contains(text(),'Мессенджеры')]/../div")).isSelected())
            driver.findElement(By.xpath("//label[contains(text(),'Мессенджеры')]/../div")).click();

        if (!driver.findElement(By.xpath("//label[contains(text(),'Социальные сети (59 \u20BD)')]/../div")).isSelected())
            driver.findElement(By.xpath("//label[contains(text(),'Социальные сети (59 \u20BD)')]/../div")).click();

        if (!driver.findElement(By.xpath("//label[contains(text(),'Безлимитные СМС (49 \u20BD)')]/../div")).isSelected())
            driver.findElement(By.xpath("//label[contains(text(),'Безлимитные СМС (49 \u20BD)')]/../div")).click();

        if (!driver.findElement(By.xpath("//label[contains(text(),'Музыка (59 \u20BD)')]/../div")).isSelected())
            driver.findElement(By.xpath("//label[contains(text(),'Музыка (59 \u20BD)')]/../div")).click();

        if (!driver.findElement(By.xpath("//label[contains(text(),'Видео (159 \u20BD)')]/../div")).isSelected())
            driver.findElement(By.xpath("//label[contains(text(),'Видео (159 \u20BD)')]/../div")).click();


    }


}
