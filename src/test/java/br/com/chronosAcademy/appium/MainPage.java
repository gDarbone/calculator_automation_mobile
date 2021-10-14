package br.com.chronosAcademy.appium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {

    private WebDriver driver;

    public MainPage(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
    }

    public String pegarTextoPorLocator(By locator){
        return driver.findElement(locator).getText();
    }

    public void clicarPorLocator(By locator) {
        driver.findElement(locator).click();
    }
}
