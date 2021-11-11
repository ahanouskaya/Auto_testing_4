package cz.czechitas.selenium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class DalsiTest {
    WebDriver prohlizec;

    @BeforeEach
    public void setup(){
    System.setProperty("webdriver.gecko.driver", "C:\\Java-Training\\Selenium\\geckodriver.exe");
    prohlizec = new FirefoxDriver();
    prohlizec.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
    prohlizec.navigate().to("https://cz-test-jedna.herokuapp.com/");
    }

    @Test
    public void () {
        prohlizec.navigate().to("https://automation-playground.czechitas.repl.co/selectors.html");

        WebElement pocetLiku = prohlizec.findElement(By.id("lvlAwesome"));
        String stPocetLiku = pocetLiku.getText();
        int intPocetLiku = Integer.parseInt(stPocetLiku);
        Assertions.assertEquals(5, intPocetLiku, "Pocet liku je ktery ocekoval ");
    }


    @AfterEach
    public void tearDown(){
    prohlizec.quit();
    }

}
