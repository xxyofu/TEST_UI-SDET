package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Wait {

    public static void waitUntilClickable(WebDriver driver, WebElement elem){
        new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(PropertyProvider.getIntance().getProperty("explicit.timeout")))).until(ExpectedConditions.elementToBeClickable(elem));
    }
    public static void waitUntilVisible(WebDriver driver, By elem){
        new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(PropertyProvider.getIntance().getProperty("explicit.timeout")))).until(ExpectedConditions.visibilityOfElementLocated(elem));
    }
}
