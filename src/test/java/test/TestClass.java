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
    @Test
    public void Task()  {
        driver=getWebDriver();
        ebayPage=new EbayPage(driver);
        lazadaPage=new LazadaPage(driver);
        List<Attribute> atributeList0=new ArrayList<Attribute>();
        ebayPage.searchProductOfEbay();
        ebayPage.verifyExpectAndActualOfEbay();
        atributeList0.addAll(ebayPage.getProductOfEbay());
        lazadaPage.searchProductOfLazada();
        lazadaPage.verifyExpectAndActualOfLazada();
        atributeList0.addAll(lazadaPage.getProductOfLazada());
        List<Attribute> product = sort(atributeList0);
        for (int i =0; i< product.size();i++) {
                System.out.println(product.get(i).getTitle() + " " + product.get(i).getUrl() + " " + product.get(i).getProductName() + " " + product.get(i).getProductPrice());
        }
    }
}
