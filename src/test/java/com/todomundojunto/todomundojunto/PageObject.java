package com.todomundojunto.todomundojunto;

import ch.qos.logback.classic.pattern.ClassOfCallerConverter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class PageObject {

    protected WebDriver driver;

    /*public void PageObject(WebDriver driver) {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        if (driver == null){
            this.driver = new ChromeDriver();
        } else {
            this.driver = driver;
        }
    }*/

    public void esperar(WebDriver driver, String local) {
        //this.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, 5);
        if (local != ""){
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(local)));
        }
    }
}
