package com.cbt.tests.day3WebTables;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Tables {

    WebDriver driver;
    @BeforeMethod
    public void setupMethod(){
        driver = BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/tables");
    }
    @AfterMethod
    public void afterMethod() throws InterruptedException {
         Thread.sleep(4000);
        // driver.close();
    }

    @Test

    public void printTable() throws InterruptedException {

        WebElement table = driver.findElement(By.xpath("//table[@id='table']"));

        System.out.println(table.getText());

        Assert.assertTrue(table.getText().contains("jsmith@gmail.com"));

    }
    @Test
    public void getAllHeaders(){
        List<WebElement> headers = driver.findElements(By.xpath("//table[@id='table1']//th"));

        for( WebElement header : headers ){
            System.out.println(header.getText());
        }
    }
    @Test
    public void printTableSize(){
        // get the size of headers(colums size)
        List<WebElement> headers = driver.findElements(By.xpath("//table[@id='table1']//th"));
        System.out.println(headers.size());

        //
        List<WebElement> allRowsWithHeader = driver.findElements(By.xpath("//table[@id='table1']//tr"));
        System.out.println(allRowsWithHeader.size());

        //
        List<WebElement> allRowsWithOutHeader = driver.findElements(By.xpath("//table[@id='table1']//tbody/tr"));
        System.out.println(allRowsWithOutHeader.size());
    }

    @Test
    public void getRow(){

        WebElement secondRow = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[2]"));
        System.out.println(secondRow.getText());

        List<WebElement> allRowsWithOutHeader =  driver.findElements(By.xpath("//table[@id='table1']/tbody/tr[2]"));

       /* for(int i = 0; i < allRowsWithOutHeader.size(); i++){
            System.out.println(allRowsWithOutHeader.get(i).getText());
        }*/
        for(int i = 1; i <= allRowsWithOutHeader.size(); i++){
            WebElement row = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + i + "]"));
            System.out.println("The information of " + i + ", row " + row.getText());

        }
    }
    @Test
    public void getAllCellInOneRow(){
        List<WebElement> allCellInOneRow = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr[1]/td"));

        for(WebElement cell : allCellInOneRow){
            System.out.println(cell.getText());
        }
    }
    @Test
    public void getASingleCellByIndex(){
        WebElement singleCell = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[4]/td[5]"));
        System.out.println(singleCell.getText());
    }
    //write a method that returns the number of columns of table

    public int getNumberOfColumns(){
        List<WebElement> headers = driver.findElements(By.xpath("//table[@id='table1'/tbody/tr]"));
        return headers.size();
    }
    //write a method that returns the number of row without header of size

    public int getNumberOfRows(){
        List<WebElement> allRows = driver.findElements(By.xpath(""));
        return allRows.size();
    }
    @Test
    public void getAllCellsByIndex(){

        int rowNumber = getNumberOfRows();
        int colNumber = getNumberOfColumns();

        System.out.println(rowNumber);
        System.out.println(colNumber);

        for(int i = 1; i <= rowNumber; i++){

            for (int j = 1; j <=colNumber ; j++) {
                String cellXPath = "//table[@id='table1']/tbody/tr[" + i + "]/td[" + j + "]";
                System.out.println(cellXPath);
                WebElement cell = driver.findElement(By.xpath(cellXPath));
                System.out.println(cell.getText());
            }
        }

    }

}
