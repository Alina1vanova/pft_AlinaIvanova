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

    public void click(By by) {
        driver.findElement(by).click();
    }

    public void enterText(By by, String text) {
        if (text != null) {
            driver.findElement(by).clear();
            driver.findElement(by).sendKeys(text);
        }
    }

    public void selectByText(By by, String text) {
        if (text != null) {
            new Select(driver.findElement(by)).selectByVisibleText(text);
        }
    }

    public int countElements(String xpath) {
        return driver.findElements(By.xpath(xpath)).size();
    }

    public String getText(By by) {
        return driver.findElement(by).getText();
    }
}
