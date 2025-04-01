package Pages;

import Pages.elements.HomeButton;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@Getter
public class BasePage {
    WebDriver driver;
    HomeButton homeButton;

    By labelLoc = By.xpath("//strong[@class='mainHeading']");
    WebElement label;

    public BasePage(WebDriver driver){
        this.driver = driver;
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(labelLoc));
        label = driver.findElement(labelLoc);
        homeButton = new HomeButton(this.driver);
    }
}