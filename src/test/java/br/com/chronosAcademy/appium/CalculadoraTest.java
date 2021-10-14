package br.com.chronosAcademy.appium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;

import static org.junit.jupiter.api.Assertions.*;

public class CalculadoraTest {

    DriverFactory driverFactory = new DriverFactory();
    AppiumDriver<MobileElement> driver;
    MainPage mPage;
    VerificationCalculadora vCalc;


    @BeforeEach
    public void beforeEach() throws MalformedURLException {
        driverFactory.setCapabilities("Android", "ChronoMobile", "uiautomator2",
                "com.android.calculator2", "com.android.calculator2.Calculator");
        driverFactory.setDriver();
        driver = driverFactory.getDriver();
        mPage = new MainPage(driverFactory.getDriver());
        vCalc = new VerificationCalculadora(driverFactory.getDriver());
    }

    @AfterEach
    public void afterEach(){
        driver.quit();
    }

    @Test
    public void validarMultiplicacao() {
        mPage.clicarPorLocator(MobileBy.id("digit_7"));
        mPage.clicarPorLocator(MobileBy.id("op_mul"));
        mPage.clicarPorLocator(MobileBy.id("digit_9"));
        mPage.clicarPorLocator(MobileBy.id("eq"));
        String result = mPage.pegarTextoPorLocator(MobileBy.id("result"));
        vCalc.verificarMultiplicacao("63", result);
    }

    @Test
    public void validarAdicao(){
        mPage.clicarPorLocator(MobileBy.id("digit_7"));
        mPage.clicarPorLocator(MobileBy.id("op_add"));
        mPage.clicarPorLocator(MobileBy.id("digit_9"));
        mPage.clicarPorLocator(MobileBy.id("eq"));
        String result = mPage.pegarTextoPorLocator(MobileBy.id("result"));
        vCalc.verificarMultiplicacao("16", result);
    }

    @Test
    public void validarSubtracao(){
        mPage.clicarPorLocator(MobileBy.id("digit_9"));
        mPage.clicarPorLocator(MobileBy.id("op_sub"));
        mPage.clicarPorLocator(MobileBy.id("digit_7"));
        mPage.clicarPorLocator(MobileBy.id("eq"));
        String result = mPage.pegarTextoPorLocator(MobileBy.id("result"));
        vCalc.verificarMultiplicacao("2", result);
    }

    @Test
    public void validarDivisao(){
        mPage.clicarPorLocator(MobileBy.id("digit_9"));
        mPage.clicarPorLocator(MobileBy.id("op_div"));
        mPage.clicarPorLocator(MobileBy.id("digit_3"));
        mPage.clicarPorLocator(MobileBy.id("eq"));
        String result = mPage.pegarTextoPorLocator(MobileBy.id("result"));
        vCalc.verificarMultiplicacao("3", result);
    }

    @Test
    public void validarBotaoDel(){
        mPage.clicarPorLocator(MobileBy.id("digit_9"));
        mPage.clicarPorLocator(MobileBy.id("digit_3"));
        mPage.clicarPorLocator(MobileBy.id("del"));
        String formula = mPage.pegarTextoPorLocator(MobileBy.id("formula"));
        vCalc.verificarMultiplicacao("9", formula);
    }
}
