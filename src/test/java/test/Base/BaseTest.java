package test.Base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import test.Models.Attribute;
import test.Page.EbayPage;
import test.Page.LazadaPage;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BaseTest {
   public WebDriver driver;
    EbayPage ebayPage;
    LazadaPage lazadaPage;
    public List<Attribute> sort(List<Attribute> atributelist)
    {
        Attribute temp=new Attribute();
        for(int i=0; i<atributelist.size()-1; i++){
            for (int j=i+1; j<atributelist.size(); j++){

                double a=Double.parseDouble(atributelist.get(i).getProductPrice());
                double b=Double.parseDouble(atributelist.get(j).getProductPrice());
                if(a > b){
                    temp=atributelist.get(j);
                    atributelist.set(j,atributelist.get(i));
                    atributelist.set(i,temp);
                }
            }
        }
        return atributelist;
    }
    public BaseTest getPage(String url){
        driver.get(url);
        return this;
    }

    public WebDriver getWebDriver() {
        return driver;
    }
    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.ebay.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        driver.close();
    }
}
