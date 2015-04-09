package carpooling;

import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

/**
 * Created by Olivier on 09/04/2015.
 */
public class Selenium {

    @Test
    public static void testSearchJourney(){
        System.out.println("Début du test de Selenium");
        HtmlUnitDriver driver = new HtmlUnitDriver();

        System.out.println("Accès à l'adresse");
        driver.get("http://localhost:8080/");

        System.out.println("Recherche de l'input De");
        WebElement inputBox = driver.findElementById("departure");
        System.out.println("Entrée de 'Lille' dedans");
        inputBox.sendKeys("Lille");

        System.out.println("Recherche de l'input Vers");
        inputBox = driver.findElementById("arrival");
        System.out.println("Entrée de 'Paris' dedans");
        inputBox.sendKeys("Paris");

        System.out.println("Clic sur Chercher");
        driver.findElementByClassName("btn-lg").click();

        System.out.println("Affichage de l'adresse");
        System.out.println(driver.getCurrentUrl());

        driver.quit();
    }

    public static void main(String[] args) {

        testSearchJourney();
    }
}
