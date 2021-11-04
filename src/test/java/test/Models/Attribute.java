package test.Models;
import test.Base.BasePage;
import test.Base.BaseTest;

import java.util.List;
public class Attribute {
   BaseTest baseTest=new BaseTest();
    public String title,url, productName; String productPrice;


    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public String getUrl() {
        return url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }



    public Attribute() {
    }

    public Attribute(String title, String productName, String productPrice, String url) {
        this.title = title;
        this.url = url;
        this.productName = productName;
        this.productPrice = productPrice;
    }
    public void showProduct(Attribute product){

            System.out.println(product.getTitle() + " " + product.getUrl() + " " + product.getProductName() + " " + product.getProductPrice() +" "+ baseTest.verifyExpectAndActual("Apple iPhone 11",product.getProductName()));
        }
    }

