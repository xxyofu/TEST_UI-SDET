package Tests;

import Pages.CustomersMenu;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;


public class DeleteTest extends BaseTest
{
    @Test(description = "Deleting Test", priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    public void Delete_test() {
        CustomersMenu customersMenu = managePage.CustomersTab_click();
        String[] customersNames = customersMenu.GetNames();
        double midArith = Arrays.stream(customersNames)
                .mapToInt(String::length)
                .average()
                .orElse(0);
        int indexToDelete = IntStream.range(0, customersNames.length)
                .boxed()
                .min(Comparator.comparingDouble(i -> Math.abs(customersNames[i].length() - midArith)))
                .orElse(-1);
        if (indexToDelete != -1) {
            Assert.assertEquals(customersNames[indexToDelete], "Harry");
            customersMenu.DeleteCustomer(indexToDelete);
        }
    }
}
