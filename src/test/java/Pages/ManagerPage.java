package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static helpers.Wait.*;



public class ManagerPage extends BasePage{

    By AddCustomerTabLoc = By.xpath("//button[contains(@class, 'tab')][@ng-click='addCust()']");
    WebElement AddCustomerTab;

    By OpenAccountTabLoc = By.xpath("//button[contains(@class, 'tab')][@ng-click='openAccount()']");
    WebElement OpenAccountTab;

    By CustomersTabLoc = By.xpath("//button[contains(@class, 'tab')][@ng-click='showCust()']");
    WebElement CustomersTab;

    public ManagerPage(WebDriver driver){
        super(driver);
    }

    @Step("Pressing Add Customer")
    public AddCustomerMenu AddCustomerTab_click(){
        waitUntilVisible(driver, AddCustomerTabLoc);
        AddCustomerTab = driver.findElement(AddCustomerTabLoc);
        waitUntilClickable(driver, AddCustomerTab);
        AddCustomerTab.click();
        AddCustomerMenu addcustomermenu = new AddCustomerMenu(driver);
        return addcustomermenu;
    }

    @Step("Pressing Customers")
    public CustomersMenu CustomersTab_click(){
        waitUntilVisible(driver, CustomersTabLoc);
        CustomersTab = driver.findElement(CustomersTabLoc);
        waitUntilClickable(driver, CustomersTab);
        CustomersTab.click();
        CustomersMenu customersMenu = new CustomersMenu(driver);
        return customersMenu;

    }
}
