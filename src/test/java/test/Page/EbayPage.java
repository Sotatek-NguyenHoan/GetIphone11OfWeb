package test.Page;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.asserts.SoftAssert;
import test.Models.Attribute;
import test.Base.BasePage;

import java.util.ArrayList;
import java.util.List;

public class EbayPage extends BasePage {


        @FindBy(xpath="//input[@value='Search']")
        private WebElement buttonSearchPath;

        @FindBy(xpath="//input[@placeholder='Search for anything']")
        private WebElement txtboxSearchPath;

        @FindBy(xpath="//*[@id='srp-river-results']/ul/li")
        private WebElement productPath;

        @FindBy(xpath="//*[@class=\"s-item__link\"]")
        private List<WebElement> urlPath;

        @FindBy(xpath="//*[@class=\"s-item__title\"]")
        private List<WebElement> nameProductPath;

        @FindBy(xpath="//*[@class=\"s-item__price\"]")
        private List<WebElement> pricePath;

        private WebDriver driver;
        public EbayPage(WebDriver _driver){
            super(_driver);
            driver = _driver;
            PageFactory.initElements(driver, this);
        }

    @Step("Search product")
    public void searchProductOfEbay(){
            sendKeyWordToTextBox( txtboxSearchPath, "Iphone 11");
            clickToButton( buttonSearchPath);
    }

    @Step("Get title of website")
    public String getTitleOfEbay(){
        String title=driver.getTitle();
        return title;
    }
    @Step("Validate expect and actual of ebay")
    public void verifyExpectAndActualOfEbay(){
        SoftAssert softAssert = new SoftAssert();
        String title=driver.getTitle();
        softAssert.assertTrue("iphone 11".equals(title), "Iphone 11 was found");
        softAssert.assertFalse("iphone 11".equals(title), "No product of iphone 11");
    }
    public List<Attribute> getProductOfEbay(){
        List<Attribute> atributeList=new ArrayList<Attribute>();
        for (int i=0;i<20;i++){

            double pri=Double.parseDouble(pricePath.get(i).getText().substring(1).split("to")[0])*23000;
            String  pricce=String.valueOf(pri);
            Attribute atribute=new Attribute(getTitleOfEbay(),nameProductPath.get(i).getText(),pricce.trim(),urlPath.get(i).getAttribute("href") );
            atributeList.add(atribute);
        }
        return atributeList;
    }

// "$234 to $456"

}
