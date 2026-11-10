import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Ejercicio2 {
    public static void ejercicio2(){
        WebDriver dr = new ChromeDriver();
        WebDriverWait wt = new WebDriverWait(dr, Duration.ofSeconds(5));

        try{
            dr.get("https://demoqa.com/radio-button");
            dr.manage().window().maximize();

            wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("yesRadio")));
            WebElement impressive = wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("impressiveRadio")));
            wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("noRadio")));

            if(!impressive.isSelected()){
                impressive.click();
                System.out.println("el button radio ha sido seleccionado su estado es seleccionado");
            }else {
                System.out.println("el boton ya esta selecionado de anteriodidad");
            }

            String textoExitoso = wt.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("p"))).getText();

            if(textoExitoso.contains("Impressive")){
                System.out.println("la prueba se realizo con exito");
            }else {
                System.out.println("la prueba fallo en algun momento");
            }


        }finally {
            dr.quit();
        }
    }
}
