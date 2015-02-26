package pft.helper;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

public abstract class BaseHelper {
    protected ApplicationManager manager;
    protected WebDriver driver;

    public BaseHelper(ApplicationManager manager) {
        this.manager = manager;
        this.driver = manager.driver;
    }

    public void openUrl(String url) {
        driver.get(url);
    }

    public void click(String xpath) {
        driver.findElement(By.xpath(xpath)).click();
    }

    public void enterText(String xpath, String text) {
        if (text != null) {
            driver.findElement(By.xpath(xpath)).clear();
            driver.findElement(By.xpath(xpath)).sendKeys(text);
        }
    }

    public void selectByText(String xpath, String item) {
        new Select(driver.findElement(By.xpath(xpath))).selectByVisibleText(item);
    }

    public int countElements(String xpath){
           return driver.findElements(By.xpath(xpath)).size();
    }
}
