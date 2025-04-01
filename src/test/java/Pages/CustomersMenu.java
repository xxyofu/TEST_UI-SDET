package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;
import static helpers.Wait.waitUntilVisible;
import static helpers.Wait.waitUntilClickable;
public class CustomersMenu extends ManagerPage{

    By RowsLoc = By.xpath("//table[contains(@class, 'table')]/tbody//tr");
    List<WebElement> Rows;

    By DeleteButtonsLoc = By.xpath("//table//button[text()='Delete']");
    List<WebElement> DeleteButtons;

    public CustomersMenu(WebDriver driver){
        super(driver);
    }
    @Step("Get Sort Customers}")
    public String[][] GetSortCustomers(){
        waitUntilVisible(driver, RowsLoc);
        Rows = driver.findElements(RowsLoc);
        String[][] res = new String[Rows.size()][];
        for(int i = 0; i<Rows.size(); i++){
            List<WebElement> cells = Rows.get(i).findElements(By.xpath("td"));
            res[i] = new String[cells.size()];
            for(int j = 0; j<cells.size(); j++){
                res[i][j] = cells.get(j).getText();
            }
        }
        res = Arrays.stream(res).sorted((a, b) -> a[0].compareTo(b[0])).toArray(String[][]::new);
        return res;
    }
    @Step("Get Sort Names}")
    public String[] GetNames(){
        waitUntilVisible(driver, RowsLoc);
        Rows = driver.findElements(RowsLoc);

        String[] res = new String[Rows.size()];
        for(int i = 0; i<Rows.size(); i++){
            List<WebElement> cells = Rows.get(i).findElements(By.xpath("td"));
            res[i]=cells.get(0).getText();
        }
        return res;
    }
    @Step("Delete customer")
    public void DeleteCustomer(int id){
        waitUntilVisible(driver, RowsLoc);
        Rows = driver.findElements(RowsLoc);
        DeleteButtons = driver.findElements(DeleteButtonsLoc);
        WebElement DeleteButton = DeleteButtons.get(id);
        waitUntilClickable(driver, DeleteButton);
        DeleteButton.click();
    }
}
