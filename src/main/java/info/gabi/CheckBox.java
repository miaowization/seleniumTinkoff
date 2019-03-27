package info.gabi;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@Getter
@Setter
@Slf4j
public class CheckBox {

  private WebElement checkbox;
  private WebDriver driver;
  private WebElement checkboxAttribute;

  public CheckBox(String name, WebDriver driver) {
    this.checkbox = driver.findElement(By.xpath("//label[contains(text(),'" + name + "')]/../div"));
    this.driver = driver;
    this.checkboxAttribute = driver.findElement(By.xpath("//label[contains(text(),'"+name+"')]/../div/div/div/input"));
  }

  public void setActive(boolean yes) {
    Boolean selected = isSelected();
    if (yes) {
      if (!selected)
        checkbox.click();
      else if (selected)
        log.info("Чекбокс уже активирован");
    } else {
      if (!selected)
        log.info("Чекбокс уже деактивирован");
      else if (selected)
        checkbox.click();
    }
  }

  private boolean isSelected() {
//    JavascriptExecutor executor = (JavascriptExecutor) driver;
//    Object aa = executor.executeScript("var items = {}; for (index = 0; index < arguments[0].attributes.length; ++index) { items[arguments[0].attributes[index].name] = arguments[0].attributes[index].value }; return items;", checkbox);
//    System.out.println(aa.toString());
    String checked = this.checkboxAttribute.getAttribute("checked");
    return checked != null;

  }
}
