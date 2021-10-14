package br.com.chronosAcademy.appium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import static org.junit.jupiter.api.Assertions.*;
import org.openqa.selenium.WebDriver;

public class VerificationCalculadora {

    private WebDriver driver;

    public VerificationCalculadora(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
    }

    public void verificarMultiplicacao(String expect, String actual) {
        assertEquals(expect, actual);
    }
}
