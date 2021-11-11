package cz.czechitas.selenium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestyAutomatizace3 {

    WebDriver prohlizec;

    @BeforeEach
    public void setUp() {
//      System.setProperty("webdriver.gecko.driver", System.getProperty("user.home") + "/Java-Training/Selenium/geckodriver");
        System.setProperty("webdriver.gecko.driver", "C:\\Java-Training\\Selenium\\geckodriver.exe");
        prohlizec = new FirefoxDriver();
        prohlizec.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }


    @Test
    public void po5nasobnemStiskuTlacikaLajkMusiBytPocetLajku5() {
        prejdiNaStrankuBudulinku();
        stiskTlacitkaLike( prohlizec, 5);
        WebElement pocetLiku = prohlizec.findElement(By.id("lvlAwesome"));
        String stPocetLiku = pocetLiku.getText();
        int intPocetLiku = Integer.parseInt(stPocetLiku);
        Assertions.assertEquals(5, intPocetLiku, "Pocet liku je ktery ocekoval ");
    }


    @Test
    public void poStiskuPridejKockuMusiBytSpravnyPocetObrazkuKocek() {
        prohlizec.navigate().to("https://automation-playground.czechitas.repl.co/adding.html");
        int expKocek = 5;
        WebElement pridejKocku = prohlizec.findElement(By.id("addItem"));
        for (int i=0; i<expKocek; i++) {
            pridejKocku.click();
        }
        List<WebElement> kocky = prohlizec.findElements(By.xpath("//div/img"));
        int pocetKocek = kocky.size();
        Assertions.assertEquals(expKocek, pocetKocek, "Pocet kocek je ");
    }


    @Test
    public void poStiskuPridejAOdeberKockuMusiBytSpravnyPocetObrazkuKocek() {
        prohlizec.navigate().to("https://automation-playground.czechitas.repl.co/adding.html");
        int expKocek = 5;
        int expKocek2 = 5;
        int rozdilExpKocek = expKocek-expKocek2;

        WebElement pridejKocku = prohlizec.findElement(By.id("addItem"));
        for (int i=0; i<expKocek; i++) {
            pridejKocku.click();
        }
        WebElement odebratKocku = prohlizec.findElement(By.id("removeItem"));
        for (int i=0; i<expKocek2; i++) {
            odebratKocku.click();
        }
        List<WebElement> kocky = prohlizec.findElements(By.xpath("//div/img"));
        int pocetKocek = kocky.size();
        Assertions.assertEquals(rozdilExpKocek, pocetKocek, "Pocet kocek je ");

    }

    public void prejdiNaStrankuBudulinku() {
        prohlizec.navigate().to("https://automation-playground.czechitas.repl.co/selectors.html");
    }
    public void stiskTlacitkaLike(WebDriver prohlizec, int kolik){
        WebElement stiskTlacitkaLajk = prohlizec.findElement(By.id("like-button"));
        for (int i=0; i<kolik; i++) {
        stiskTlacitkaLajk.click();
        }
    }

    public void generujKocky(WebDriver prohlizec, int kolik){
        WebElement pridejButton = prohlizec.findElement(By.id("addItem"));
        for (int i=0; i<kolik; i++) {
            pridejButton.click();
        }
    }


    public void vyhodnoceni (WebDriver prohlizec, int ocekovanychKocek){
        WebElement pocetKocek = prohlizec.findElement(By.id("counter"));
        String stPocetKocek = pocetKocek.getText();
        int intPocetKocek = Integer.parseInt(stPocetKocek);

    }




//    Bonusovy ukol
    @Test
    public void poStiskuPridejAOdeberKockuVicekratNezBylaPridanaMusiBytPocetKocek0() {
        prohlizec.navigate().to("https://automation-playground.czechitas.repl.co/adding.html");
        int expPocetKocek = 4;
        int delPocetKocek = 8;

        WebElement pridejButton = prohlizec.findElement(By.id("addItem"));
        WebElement odeberKocku = prohlizec.findElement(By.xpath("//button[@id='removeItem']"));


        for (int i = 0; i < expPocetKocek; i++) {
            pridejButton.click();
        }
        for (int i = 0; i < delPocetKocek; i++) {
            odeberKocku.click();
        }

        List<WebElement> kocky = prohlizec.findElements(By.xpath("//div/img"));
        Assertions.assertEquals(0, kocky.size(),"Neni spravny pocet");
    }

    @AfterEach
    public void tearDown() {
        prohlizec.quit();
    }
}
