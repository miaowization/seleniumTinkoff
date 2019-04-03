package info.gabi;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class BaseTestClass extends BaseRunner {

//    Integer getInteger(String str) {
//        str = str.replaceAll("\\D", "");
//        return Integer.parseInt(str);
//    }
//

//
//    void changeRegion(String region) {
//        Button regionButton = new Button("//*[@class='MvnoRegionConfirmation__title_DOqnW']", driver);
//        if (regionButton.getText().contains(region))
//            driver.findElement(By.xpath("//*[text()='Да']")).click();
//        else {
//            try {
//                driver.findElement(By.xpath("//*[text()='Нет, изменить']")).click();
//            } catch (WebDriverException ex) {
//                driver.findElement(By.xpath("//*[@class='MvnoRegionConfirmation__title_DOqnW']")).click();
//            }
//            TextInput city = new TextInput("Город", driver);
//            city.setText(region);
//            driver.findElement(By.xpath("//*[contains(text(), '" + region + "')]")).click();
//        }
//    }
//
//    void checkTabName(String tabName) {
//        ArrayList<String> windows = new ArrayList<>(driver.getWindowHandles());
//
//        driver.switchTo().window(windows.get(driver.getWindowHandles().size() - 1));
//        softly.assertThat(driver.getTitle()).isEqualTo(tabName);
//    }
//
//    void closePreviousTab() {
//        String currentTab = driver.getWindowHandle();
//        for (String handle : driver.getWindowHandles()) {
//            if (!handle.equals(currentTab)) {
//                driver.switchTo().window(handle);
//                driver.close();
//            }
//        }
//        driver.switchTo().window(currentTab);
//    }
//
//    void wait(int seconds) {
//        try {
//            TimeUnit.SECONDS.sleep(seconds);
//        } catch (InterruptedException ex) {
//            log.error(ex.getMessage());
//        }
//    }
//

//    public WebDriver getDriver(WebElement element){
//        WebDriver d = null;
//        try {
//            Field f = element.getClass().getDeclaredField("parent");
//            f.setAccessible(true);
//            Object o = f.get(element);
//            if (o instanceof WebDriver) {
//                d = (WebDriver) o;
//            }
//        }
//        catch (Exception e){
//
//        }
//        return d;
//    }
//    public WebElement refreshElement(WebElement elem){
//        if(!isElementStale(elem))
//            return elem;
//        Object lastObject = null;
//        try{
//            String[] arr = elem.toString().split("->");
//            List<String> newStr = new ArrayList<>();
//            for(String s:arr){
//                String newstr = s.trim().replaceAll("^\\[+", "").replaceAll("\\]+$","");
//                String[] parts = newstr.split(": ");
//                String key = parts[0];
//                String value = parts[1];
//                int leftBracketsCount = value.length() - value.replace("[", "").length();
//                int rightBracketscount = value.length() - value.replace("]", "").length();
//                if(leftBracketsCount-rightBracketscount==1)
//                    value = value + "]";
//                if(lastObject==null){
//                    lastObject = getDriver();
//                }else{
//                    lastObject = getWebElement(lastObject, key, value);
//                }
//            }
//        }catch(Exception e){
//            log.error("Error in Refreshing the stale Element.");
//        }
//        return (WebElement)lastObject;
//    }


//    private WebElement getWebElement(Object lastObject, String key, String value){
//        WebElement element = null;
//        try {
//            By by = getBy(key,value);
//            Method m = getCaseInsensitiveDeclaredMethod(lastObject,"findElement");
//            element = (WebElement) m.invoke(lastObject,by);
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        }
//        return element;
//    }
//
//
//    private By getBy(String key, String value) throws InvocationTargetException, IllegalAccessException {
//        By by = null;
//        Class clazz = By.class;
//        String methodName = key.replace(" ","");
//        Method m = getCaseInsensitiveStaticDeclaredMethod(clazz,methodName);
//        return (By) m.invoke(null,value);
//    }
//    private static Method getCaseInsensitiveDeclaredMethod(Object obj, String methodName) {
//        Method[] methods = obj.getClass().getMethods();
//        Method method = null;
//        for (Method m : methods) {
//            if (m.getName().equalsIgnoreCase(methodName)) {
//                method = m;
//                break;
//            }
//        }
//        if (method == null) {
//            throw new IllegalStateException(String.format("%s Method name is not found for this Class %s", methodName, obj.getClass().toString()));
//        }
//        return method;
//    }
//    private Method getCaseInsensitiveStaticDeclaredMethod(Class clazz, String methodName) {
//        Method[] methods = clazz.getMethods();
//        Method method = null;
//        for (Method m : methods) {
//            if (m.getName().equalsIgnoreCase(methodName)) {
//                method = m;
//                break;
//            }
//        }
//        if (method == null) {
//            throw new IllegalStateException(String.format("%s Method name is not found for this Class %s", methodName, clazz.toString()));
//        }
//        return method;
//    }
}
