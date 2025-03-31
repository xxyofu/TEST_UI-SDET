package Tests;

import Pages.AddCustomerMenu;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.*;


import java.util.Random;


public class AddCustomerTest extends BaseTest{

    @DataProvider(name = "Random_values")
    public Object[][] dpMethod(){
        Object[][] obj = new Object[5][2];
        Random r = new Random();
        for (int i = 0; i<5; i++){
            String s = "";
            String temp = Long.toString(1000000000L + (long) (r.nextDouble() * 9000000000L));
            obj[i][1] = temp;
            for(int j = 0; j < 5; j++){
                int t = Integer.parseInt(String.valueOf(temp.charAt(j*2))+temp.charAt(j*2+1));
                s += (char)(97+(t%26));
            }
            obj[i][0]=s;
        }
        return obj;
    }
    AddCustomerMenu addCustomerMenu;

    @Test(description = "Test: add random customer", dataProvider = "Random_values", priority = 2)
    @Severity(SeverityLevel.CRITICAL)
    public void AddCustomer_test(String name, String code){
        addCustomerMenu = managePage.AddCustomerTab_click();
        addCustomerMenu.NameBox_send(name);
        addCustomerMenu.LastNameBox_send("any");
        addCustomerMenu.PostCode_send(code);
        addCustomerMenu.AddCustomerButton_click();
        Assert.assertTrue(addCustomerMenu.IsAllertShown(), "There is no allert");
    }
}
