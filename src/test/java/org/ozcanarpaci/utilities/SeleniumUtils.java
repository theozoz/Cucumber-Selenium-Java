package org.ozcanarpaci.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.ozcanarpaci.base.BaseDriver;

import java.time.Duration;

public class SeleniumUtils {

    WebDriver driver;
    FluentWait<WebDriver> wait;
    long waitElementTimeout = 30;
    long pollingEveryValue = 300;

    public SeleniumUtils() {
        this.driver = BaseDriver.driver;
        wait = setFluentWait(waitElementTimeout);
    }

    public FluentWait<WebDriver> setFluentWait(long timeout){

        FluentWait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver);
        fluentWait.withTimeout(Duration.ofSeconds(timeout))
                .pollingEvery(Duration.ofMillis(pollingEveryValue))
                .ignoring(NoSuchElementException.class);
        return fluentWait;
    }

    public WebElement findElement(By locator) {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));

        return element;
    }

    public void openURL(String url) {
        driver.get(url);
    }

    public void sendKeys(By locator, String text) {
        WebElement element = driver.findElement(locator);
        element.sendKeys(text);
    }

    public void clickElement(By locator) {
        findElement(locator).click();
    }

    public String getElementText(By locator) {
        return findElement(locator).getText();
    }

}
