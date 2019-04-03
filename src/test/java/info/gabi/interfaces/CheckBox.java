package info.gabi.interfaces;

public interface CheckBox extends BaseElement {

    void setActive(boolean active);

//    private WebElement checkbox;
//
//    private WebElement checkboxAttribute;
//
//    private Boolean checked;
//
//    CheckBox(String name, WebDriver driver) {
//        super(driver);
//        try {
//            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[contains(text(),'" + name + "')]/../div")));
//            this.checkbox = driver.findElement(By.xpath("//label[contains(text(),'" + name + "')]/../div"));
//            this.checkboxAttribute = driver.findElement(By.xpath("//label[contains(text(),'" + name + "')]/../div/div/div/input"));
//            this.checked = !(this.checkboxAttribute.getAttribute("checked") == null);
//        } catch (WebDriverException e) {
//            this.checkbox = driver.findElement(By.xpath("//*[contains(text(),'" + name + "')]/ancestor::label/div"));
//            this.checkboxAttribute = driver.findElement(By.xpath("//*[contains(text(),'" + name + "')]/ancestor::label"));
//            this.checked = this.checkboxAttribute.getAttribute("class").contains("checked");
//        }
//    }
//
//    void setActive(boolean active) {
//        boolean selected = isSelected();
//        if (active) {
//            if (!selected)
//                checkbox.click();
//            else if (selected)
//                log.info("Чекбокс уже активирован");
//        } else {
//            if (!selected)
//                log.info("Чекбокс уже деактивирован");
//            else if (selected)
//                checkbox.click();
//        }
//    }
//
//    boolean isSelected() {
//        this.checked = getChecked();
//        return checked;
//    }
//
//    String getText() {
//        return this.checkbox.getText();
//    }
//
//    @Override
//    void refreshElement() {
//        this.checkbox = super.refreshElement(this.checkbox);
//        this.checkboxAttribute = super.refreshElement(this.checkboxAttribute);
//    }
}
