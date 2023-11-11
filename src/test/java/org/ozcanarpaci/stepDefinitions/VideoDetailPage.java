package org.ozcanarpaci.stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.ozcanarpaci.base.BaseDriver;
import org.ozcanarpaci.utilities.SeleniumUtils;


public class VideoDetailPage {

    WebDriver driver;
    SeleniumUtils seleniumUtils;
     static final By searchBox= By.xpath("//input[@id=\"search\"]");
     static final By firstElement= By.xpath("(//div[@id=\"contents\" and @class=\" style-scope ytd-item-section-renderer\"]//div[@id=\"dismissible\"]//a)[1]");
     static final By searchButton= By.id("search-icon-legacy");
     static final By chanelName= By.xpath("(//div[@id=\"owner\"]//a[text()=\"100. Yıl Halısaha\"])[1]");


     @Before
    public void start() {
         driver=BaseDriver.setUp();
         seleniumUtils= new SeleniumUtils();
     }


    @Given("Youtube ana sayfası açılır")
    public void youtube_ana_sayfası_açılır() {
        seleniumUtils.openURL("https://www.youtube.com/");
    }


    @When("Arama alanına {string} değeri girilir")
    public void arama_çubuğuna_değer_girilir(String text) {
        seleniumUtils.sendKeys(searchBox,text);
    }


    @And("Arama yapılır")
    public void arama_yapılır()  {
        seleniumUtils.clickElement(searchButton);
    }

    @And("Arama yapılan videoya tıklanır")
    public void rama_yapılan_videoya_tıklanır()  {
        seleniumUtils.clickElement(firstElement);
    }

    @Then("Videonun açıldığı kontrol edilir")
    public void videonun_açıldığı_kontrol_edilir()  {
         //Daha çok validasyon yapılabilir. Gösterim için bu kadar yeterli
        Assertions.assertEquals(seleniumUtils.getElementText(chanelName),"100. Yıl Halısaha","Halı saha ismi yanlış");
    }

    @After
    public void tearDown() {
        BaseDriver.tearDown();
    }

}
