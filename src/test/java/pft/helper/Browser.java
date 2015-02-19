package pft.helper;

import org.openqa.selenium.*;

public class Browser {
    private WebDriver driver;

    public Browser(WebDriver driver) {
        this.driver = driver;
    }

    public void openUrl(String url) {
        driver.get(url);
    }

    public String getpageSource() {
        return driver.getPageSource();
    }

    public void clickElement(String xpath) {
        driver.findElement(By.xpath(xpath)).click();
    }

    public void enterText(String xpath, String text) {
        driver.findElement(By.xpath(xpath)).sendKeys(Keys.chord(Keys.CONTROL + "a")+text);
    }


    public void clearField(String xpath) {
        driver.findElement(By.xpath(xpath)).sendKeys(Keys.chord(Keys.CONTROL + "a"));
        driver.findElement(By.xpath(xpath)).sendKeys(Keys.chord(Keys.DELETE));
    }

    public void clearInputWithTags(String xpath) {
        while (elementIsExist(xpath)) {
            driver.findElement(By.xpath(xpath)).click();
        }
    }

    public boolean elementIsExist(String xpath) {
        try {
            driver.findElement(By.xpath(xpath));
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }

    public boolean elementIsDisplayed(String xpath) {
        if (driver.findElement(By.xpath(xpath)).isDisplayed())
            return true;
        else
            return false;
    }

    public String getElementClass(String xpath) {
        return driver.findElement(By.xpath(xpath)).getAttribute("class");
    }

    public String getScriptContent(String xpath) {
        return driver.findElement(By.xpath(xpath)).getAttribute("innerHTML");
    }

    public void closeBrowser() {
        driver.quit();
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public String getTextOnElement(String xpath) {
        return driver.findElement(By.xpath(xpath)).getText();
    }

}
