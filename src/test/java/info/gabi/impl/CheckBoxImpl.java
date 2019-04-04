package info.gabi.impl;

import info.gabi.interfaces.CheckBox;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;

@Slf4j
public class CheckBoxImpl extends AbstractElement implements CheckBox {
  protected CheckBoxImpl(WebElement wrappedElement) {
    super(wrappedElement);
  }

  @Override
  public void setActive(boolean active) {
    boolean selected = isSelected();
    if (active) {
      if (!selected)
        wrappedElement.click();
      else if (selected)
        log.info("Чекбокс уже активирован");
    } else {
      if (!selected)
        log.info("Чекбокс уже деактивирован");
      else if (selected)
        wrappedElement.click();
    }
  }

  @Override
  public void click() {
    wrappedElement.click();
  }

  public boolean isSelected() {
    return (wrappedElement.getAttribute("class").contains("checked") || wrappedElement.getAttribute("checked") != null);
  }

  public String getText() {
    return wrappedElement.getText();
  }
  //            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[contains(text(),'" + name + "')]/../div")));
//            this.checkbox = driver.findElement(By.xpath("//label[contains(text(),'" + name + "')]/../div"));
//            this.checkboxAttribute = driver.findElement(By.xpath("//label[contains(text(),'" + name + "')]/../div/div/div/input"));
//            this.checked = !(this.checkboxAttribute.getAttribute("checked") == null);

  //            this.checkbox = driver.findElement(By.xpath("//*[contains(text(),'" + name + "')]/ancestor::label/div"));
//            this.checkboxAttribute = driver.findElement(By.xpath("//*[contains(text(),'" + name + "')]/ancestor::label"));
//            this.checked = this.checkboxAttribute.getAttribute("class").contains("checked");

}
