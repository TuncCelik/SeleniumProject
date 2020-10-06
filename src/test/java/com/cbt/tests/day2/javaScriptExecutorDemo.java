package com.cbt.tests.day2;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class javaScriptExecutorDemo {
    WebDriver driver;
    @BeforeMethod
    public void setupMethod(){
        driver = BrowserFactory.getDriver("chrome");
    }
    @AfterMethod
    public void tearDown(){

       // driver.close();
    }

    @Test

    public void clickWithJc() throws InterruptedException {

        driver.get("http://practice.cybertekschool.com");

        WebElement dropDownLink = driver.findElement(By.linkText("Dropdown"));

        //dropDownLink.click(); // bu yolla cozemessek asagidaki JS executor u kullanarak yapabiliriz

       /*JavascriptExecutor jse = (JavascriptExecutor) driver;

        Thread.sleep(3000);

        jse.executeScript("arguments[0].click();",dropDownLink);*/

    }
    /*@Test
    public void disableBox(){
        driver.get("http://practice.cybertekschool.com/dynamic_controls");

        WebElement inputBox = driver.findElement(By.cssSelector("//form[@id=\"input-example\"]/button"));

        //inputBox.sendKeys("");

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        String str = "this is a text for disabled box";
        jse.executeScript("arguments[0].value='"+ str + "';", inputBox);

    }
    @Test
    public void gooleTest(){
        driver.get("https://google.com");

        WebElement searchBox = driver.findElement(By.xpath("//input[@title='Search']"));

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        String str = "computer";
        jse.executeScript("arguments[0].value='"+ str + "';", searchBox);)



    }
    @Test
    public void scrollDownAndUp(){
        driver.get("http://practice.cybertekschool.com/infinite_scroll");

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        for(int i=0; i<100; i++){
            jse.executeScript("window.scrollBy(0,250)");
        }
        for(int i=0; i<100; i++){
            jse.executeScript("window.scrollBy(0,250)");
        }
    }
    */
}
