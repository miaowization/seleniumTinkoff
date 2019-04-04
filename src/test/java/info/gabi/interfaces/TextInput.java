package info.gabi.interfaces;


public interface TextInput extends BaseElement {
    void type(String text);

    void clear();

    void clearAndType(String text);


//    private WebElement textInput;
//
//    TextInput(String locator, WebDriver driver) {
//        super(driver);
//        try {
//            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='" + locator + "']/../input")));
//            this.textInput = driver.findElement(By.xpath("//div[text()='" + locator + "']/../input"));
//        } catch (WebDriverException e) {
//            this.textInput = driver.findElement(By.xpath("//input[@name='" + locator + "']"));
//        }
//    }


}
