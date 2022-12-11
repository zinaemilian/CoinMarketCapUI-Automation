package com.CoinMarket.Utilities;


import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class BrowserUtils {


    public static void waitFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static WebElement waitForVisibility(WebElement element, Duration timeToWaitInSec) {
        WebDriverWait wait = new WebDriverWait(Driver.get(), timeToWaitInSec);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }


    public static WebElement waitForClickablility(WebElement element, Duration timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.get(), timeout);
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void clickWithTimeOut(WebElement element, int timeout) {
        for (int i = 0; i < timeout; i++) {
            try {
                element.click();
                return;
            } catch (WebDriverException e) {
                waitFor(2);
            }
        }
    }

    public static void clickWithJS(WebElement element) {
        ((JavascriptExecutor) Driver.get()).executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor) Driver.get()).executeScript("arguments[0].click();", element);
    }

    public static void scrollToElement(WebElement element) {
        ((JavascriptExecutor) Driver.get()).executeScript("arguments[0].scrollIntoView(true);", element);
    }


public static void ScrollDown() throws InterruptedException {


    JavascriptExecutor jse = (JavascriptExecutor) Driver.get();

    for (int i = 0; i < 10; i++) {
        Thread.sleep(1000);
        jse.executeScript("window.scrollBy(100,350)");


    }
    }
    public static void ScrollUp() throws InterruptedException {


    JavascriptExecutor jse = (JavascriptExecutor) Driver.get();

    for (int i = 0; i < 10; i++) {
        Thread.sleep(1000);
        jse.executeScript("window.scrollBy(0,-350)");

     }
    }

    public static void ClickAddFilterOption(String optionText, List<WebElement> optionWE) {
        List<String> options = new ArrayList<String>();
        Iterator<WebElement> itertorAllProdcs = optionWE.iterator();
        while (itertorAllProdcs.hasNext()) {
            WebElement product = itertorAllProdcs.next();
            if (product.getText().toUpperCase().contentEquals(optionText.toUpperCase())) {
                waitForVisibility(product,Duration.ofSeconds(5));
                waitFor(3);
                product.click();
                break;
            }
        }

   }

    public static void waitForPageToLoad(Duration timeOutInSeconds) {
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        };
        try {
            WebDriverWait wait = new WebDriverWait(Driver.get(), timeOutInSeconds);
            wait.until(expectation);
        } catch (Throwable error) {
            error.printStackTrace();
        }

    }
    public static void clickWithWait(By by, int attempts) {
        int counter = 0;
        while (counter < attempts) {
            try {
                clickWithJS(Driver.get().findElement(by));
                break;
            } catch (WebDriverException e) {

                e.printStackTrace();
                ++counter;
                waitFor(1);
            }
        }
    }
    public static void doubleClick(WebElement element) {
        new Actions(Driver.get()).doubleClick(element).build().perform();
    }
}
