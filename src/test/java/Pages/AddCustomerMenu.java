package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import static helpers.Wait.waitUntilVisible;
import static helpers.Wait.waitUntilClickable;

public class AddCustomerMenu extends ManagerPage{

    By NameBoxLoc = By.xpath("//input[@ng-model='fName']");
    WebElement NameBox;

    By LastNameBoxLoc = By.xpath("//input[@ng-model='lName']");
    WebElement LastNameBox;

    By PostCodeBoxLoc = By.xpath("//input[@ng-model='postCd']");
    WebElement PostCodeBox;

    By AddCustomerButtonLoc = By.xpath("//button[@type='submit']");
    WebElement AddCustomerButton;

    public AddCustomerMenu(WebDriver driver){
        super(driver);
    }
    @Step("Click on Add customer button")
    public void AddCustomerButton_click(){
        AddCustomerButton = driver.findElement(AddCustomerButtonLoc);
        waitUntilClickable(driver, AddCustomerButton);
        AddCustomerButton.click();
    }
    @Step("Write {str} into Name field")
    public void NameBox_send(String str){
        waitUntilVisible(driver, NameBoxLoc);
        NameBox = driver.findElement(NameBoxLoc);
        NameBox.sendKeys(str);
    }
    @Step("Write {str} into LastName field")
    public void LastNameBox_send(String str){
        waitUntilVisible(driver, LastNameBoxLoc);
        LastNameBox = driver.findElement(LastNameBoxLoc);
        LastNameBox.sendKeys(str);
    }
    @Step("Write {str} into Post code field")
    public void PostCode_send(String str){
        waitUntilVisible(driver, PostCodeBoxLoc);
        PostCodeBox = driver.findElement(PostCodeBoxLoc);
        PostCodeBox.sendKeys(str);
    }
    @Step("Find allert")
    public boolean IsAllertShown(){
        try{
            Alert alert = driver.switchTo().alert();
            alert.accept();
            return true;
        } catch (NoAlertPresentException e){
            return false;
        }

    }
}
