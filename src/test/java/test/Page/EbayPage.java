package test.Page;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import test.Base.BaseTest;
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
    public void searchProductOfEbay(String product){
            getWeb(urleBay);
            clear(txtboxSearchPath);
            sendKeyWordToTextBox( txtboxSearchPath, product);
            clickToButton( buttonSearchPath);
    }

    public List<Attribute> getProductOfEbay(){
        List<Attribute> atributeList=new ArrayList<Attribute>();
        for (int i=0;i<20;i++){
            double pri=Double.parseDouble(pricePath.get(i).getText().substring(1).split("to")[0])*23000;
            String  pricce=String.valueOf(pri);
            Attribute atribute=new Attribute(driver.getTitle(),nameProductPath.get(i).getText(),pricce.trim(),urlPath.get(i).getAttribute("href") );
            atributeList.add(atribute);
        }
        return atributeList;
    }



}
