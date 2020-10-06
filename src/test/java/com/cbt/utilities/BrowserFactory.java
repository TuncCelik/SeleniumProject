package com.cbt.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactory {

    public static WebDriver getDriver(String browser) {
        WebDriver driver = null;
        if (browser.equalsIgnoreCase("edge")) {
            driver = null;
        } else if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("fireFoxDriver")) {
            WebDriverManager.firefoxdriver();
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("explorer")) {
            WebDriverManager.iedriver();
            driver = new InternetExplorerDriver();
        }
        return driver;


    }

}
