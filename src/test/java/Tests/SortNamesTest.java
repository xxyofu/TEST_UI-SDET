package Tests;

import Pages.CustomersMenu;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SortNamesTest extends BaseTest{
    @Test(description = "Test of Sorting Names", priority = 0)
    @Severity(SeverityLevel.CRITICAL)
    public void SortNames_test(){
        CustomersMenu customersMenu = managePage.CustomersTab_click();
        String[][] SortedCustomers = customersMenu.GetSortCustomers();
        Assert.assertEquals(SortedCustomers[0][0], "Albus");
    }
}
