package info.gabi;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@Getter
@Setter
@Slf4j
class CheckBox extends BaseElement {

  private WebElement checkbox;

  private WebElement checkboxAttribute;

  CheckBox(String name, WebDriver driver) {
    super(driver);
    this.checkbox = driver.findElement(By.xpath("//label[contains(text(),'" + name + "')]/../div"));
    this.checkboxAttribute = driver.findElement(By.xpath("//label[contains(text(),'"+name+"')]/../div/div/div/input"));
  }

  void setActive(boolean yes) {
    boolean selected = isSelected();
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

  boolean isSelected() {
    String checked = this.checkboxAttribute.getAttribute("checked");
    return checked != null;

  }
}
