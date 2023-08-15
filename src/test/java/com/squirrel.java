package com;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class squirrel {

    @Test
    public void myTest(){
        WebDriver webDriver = new ChromeDriver();

        webDriver.get("https://www.selenium.dev/selenium/web/web-form.html");

        System.out.println(webDriver.getTitle());

        webDriver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

        WebElement textBox = webDriver.findElement(By.name("my-text"));
        WebElement submitButton = webDriver.findElement(By.cssSelector("button"));

        textBox.sendKeys("Selenium");
        submitButton.click();

        WebElement message = webDriver.findElement(By.id("message"));
        String value = message.getText();
        assertEquals("Received!", value);

        webDriver.quit();
    }
}
