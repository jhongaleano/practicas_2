import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Ejercicio3 {
    public static void ejercicio3(){
        WebDriver dr =  new ChromeDriver();
        WebDriverWait wt = new WebDriverWait(dr, Duration.ofSeconds(5));

        try {
            dr.get("https://www.selenium.dev/selenium/web/web-form.html");
            dr.manage().window().maximize();

            wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("my-text-id"))).sendKeys("Prueba ADSO");
            wt.until(ExpectedConditions.visibilityOfElementLocated(By.name("my-password"))).sendKeys("Sena2026");
            wt.until(ExpectedConditions.visibilityOfElementLocated(By.name("my-textarea"))).sendKeys("Automatización con Selenium");

            wt.until(ExpectedConditions.elementToBeClickable(By.tagName("button"))).click();

            Boolean message = wt.until(ExpectedConditions.textToBePresentInElementLocated(By.id("message"),"Received!"));

            if(message){
                System.out.println("la prueba se realizo con exito");
            }else {
                System.out.println("la prueba fallo en algun punto");
            }
        }finally {
            dr.quit();
        }
    }
}
