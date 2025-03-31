package Tests;

import Pages.ManagerPage;
import helpers.PropertyProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    WebDriver driver;
    ManagerPage managePage;

    @BeforeClass
    public void init(final ITestContext context){
        String browserName = PropertyProvider.getIntance().getProperty("browser.name");
        int pageLoadTimeout = Integer.parseInt(PropertyProvider.getIntance().getProperty("page.load.timeout"));

        switch (browserName){
            case "chrome": driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*").addArguments("--disable-gpu").addArguments("--start-maximized")); break;
            default: throw new IllegalStateException("Unexpacted value: " + browserName);
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(pageLoadTimeout, TimeUnit.SECONDS);
        context.setAttribute("driver", driver);
        String webUrl = PropertyProvider.getIntance().getProperty("web.url");
        driver.get(webUrl);
        managePage = new ManagerPage(driver);

    }

    @AfterClass
    public final void tearDown(){
        driver.quit();
    }

}
