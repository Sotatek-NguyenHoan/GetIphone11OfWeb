package test;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import test.Base.BasePage;
import test.Models.Attribute;
import test.Base.BaseTest;
import test.Page.EbayPage;
import test.Page.LazadaPage;

import java.util.*;

public class TestClass extends BaseTest {
    WebDriver driver;
    EbayPage ebayPage;
    LazadaPage lazadaPage;
    Attribute attribute=new Attribute();
    @Test
    public void Task()  {
        driver=getWebDriver();
        ebayPage=new EbayPage(driver);
        lazadaPage=new LazadaPage(driver);
        List<Attribute> atributeList0=new ArrayList<Attribute>();
        ebayPage.openeBay();
        ebayPage.searchProductOfEbay("Iphone 11");
        atributeList0.addAll(ebayPage.getProductOfEbay());
        lazadaPage.openLazada();
        lazadaPage.searchProductOfLazada("Iphone 11");
        atributeList0.addAll(lazadaPage.getProductOfLazada());
        List<Attribute> product = sort(atributeList0);
        attribute.showProduct(product);
    }
}
