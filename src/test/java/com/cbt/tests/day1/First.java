package com.cbt.tests.day1;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class First {
    WebDriver driver;
    @BeforeMethod
    public void beforeMethod(){
        driver = BrowserFactory.getDriver("chrome");
    }
    @AfterMethod
    public void afterMethod(){

        driver.close();
    }

    @Test

    public void test1(){

        driver.get("https://google.com");

    }
    @Test

    public void test2(){

        driver.get("https://google.com");

    }


}
