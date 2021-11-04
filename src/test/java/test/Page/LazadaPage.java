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

public class LazadaPage extends BasePage {

        @FindBy(xpath="//button[@class='search-box__button--1oH7']")
        private WebElement buttonSearchPath;

        @FindBy(xpath="//*[@id=\"q\"]")
        private WebElement txtboxSearchPath;

        @FindBy(xpath="//div[@data-tracking='product-card']")
        private WebElement productPath;

        @FindBy(xpath="//div[@data-tracking='product-card']//a[@title]")
        private List<WebElement> urlPath;

        @FindBy(xpath="//div[@data-tracking='product-card']//a[@title]")
        private List<WebElement> nameProductPath;

        @FindBy(xpath="//div[@data-tracking='product-card']//a[@title]/../following-sibling::div[1]")
        private List<WebElement> pricePath;

        private WebDriver driver;
        public LazadaPage(WebDriver _driver){
            super(_driver);
            driver = _driver;
            PageFactory.initElements(driver, this);
        }
        @Step
        public  void openLazada(){
            getWeb("https://www.lazada.vn/");
        }
        @Step("Search product")
        public void searchProductOfLazada(String product){
            sendKeyWordToTextBox( txtboxSearchPath, product);
            clickToButton( buttonSearchPath);
        }

        @Step("Get information of products")
        public List<Attribute> getProductOfLazada(){
            List<Attribute> atributeList2=new ArrayList<Attribute>();
            for (int i=0;i<20;i++){
                String pri2=pricePath.get(i).getText().substring(1).replace(",","");
                Attribute atribute2=new Attribute(driver.getTitle().substring(57,61),nameProductPath.get(i).getText(),pri2.trim(),urlPath.get(i).getAttribute("href") );
                atributeList2.add(atribute2);
            }
            return atributeList2;
        }
}

