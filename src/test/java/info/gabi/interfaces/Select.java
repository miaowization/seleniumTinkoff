package info.gabi.interfaces;

public interface Select extends BaseElement {

  void chooseOption(String textToFind);

//            this.select = driver.findElement(By.xpath("//*[contains(@title, '" + type + "')]"));
//            this.select = driver.findElement(By.xpath("//*[contains(text(),'" + type + "')]"));

}
