package pft.helper;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

public class Browser {
    private WebDriver driver;

    public Browser(WebDriver driver) {
        this.driver = driver;
    }

    public void openUrl(String url) {
        driver.get(url);
    }

    public void clickElement(String xpath) {
        driver.findElement(By.xpath(xpath)).click();
    }

    public void enterText(String xpath, String text) {
        driver.findElement(By.xpath(xpath)).sendKeys(Keys.chord(Keys.CONTROL + "a")+text);
    }

    public void selectItem(String xpath, String item){
        new Select (driver.findElement(By.xpath(xpath))).selectByVisibleText(item);
    }

    public void closeBrowser() {
        driver.quit();
    }


}
