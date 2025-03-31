package Pages.elements;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static helpers.Wait.*;

public class HomeButton {
    WebDriver driver;

    WebElement homeButton;

    public HomeButton(WebDriver driver){
        this.driver = driver;
    }

    @Step("Click on Home button")
    public void HomeButton_click(){
        homeButton=driver.findElement(By.className("home"));
        waitUntilClickable(driver, homeButton);
        homeButton.click();
    }
}
