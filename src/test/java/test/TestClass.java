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
    private String productSearch="Iphone 11";
    @Test
    public void Task()  {
        driver=getWebDriver();
        ebayPage=new EbayPage(driver);
        lazadaPage=new LazadaPage(driver);
        List<Attribute> atributeList0=new ArrayList<Attribute>();
        ebayPage.searchProductOfEbay(productSearch);
        atributeList0.addAll(ebayPage.getProductOfEbay());
        lazadaPage.searchProductOfLazada(productSearch);
        atributeList0.addAll(lazadaPage.getProductOfLazada());
        List<Attribute> product = sort(atributeList0);

        for (int i =0; i< product.size();i++) {
          attribute.showProduct(product.get(i));
        }
    }
}
