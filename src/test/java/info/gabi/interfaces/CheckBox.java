package info.gabi.interfaces;

public interface CheckBox extends BaseElement {

    void setActive(boolean active);

//            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[contains(text(),'" + name + "')]/../div")));
//            this.checkbox = driver.findElement(By.xpath("//label[contains(text(),'" + name + "')]/../div"));
//            this.checkboxAttribute = driver.findElement(By.xpath("//label[contains(text(),'" + name + "')]/../div/div/div/input"));
//            this.checked = !(this.checkboxAttribute.getAttribute("checked") == null);


//            this.checkbox = driver.findElement(By.xpath("//*[contains(text(),'" + name + "')]/ancestor::label/div"));
//            this.checkboxAttribute = driver.findElement(By.xpath("//*[contains(text(),'" + name + "')]/ancestor::label"));
//            this.checked = this.checkboxAttribute.getAttribute("class").contains("checked");

//
//    @Override
//    void refreshElement() {
//        this.checkbox = super.refreshElement(this.checkbox);
//        this.checkboxAttribute = super.refreshElement(this.checkboxAttribute);
//    }
}
