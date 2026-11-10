import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class Ejercicio6 {
    public static void ejercicio6(){
        WebDriver dr = new ChromeDriver();
        WebDriverWait wt = new WebDriverWait(dr, Duration.ofSeconds(5));

        try {
            dr.get("https://www.selenium.dev/selenium/web/dynamic.html");
            dr.manage().window().maximize();

            wt.until(ExpectedConditions.elementToBeClickable(By.id("adder"))).click();
            wt.until(ExpectedConditions.elementToBeClickable(By.id("reveal"))).click();

           WebElement input = wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("revealed")));
            input.sendKeys("Prueba Selenium ADSO");
            String valor = input.getDomProperty("value");

            if(valor.equals("Prueba Selenium ADSO")){
                System.out.println("prueba exitosa el valor del input es: "+valor);
            }else {
                System.out.println("fallo la prueba");
            }
            File screenshot = ((TakesScreenshot) dr).getScreenshotAs(OutputType.FILE);
            File destino = new File("evidencia-login-fallido.png");
            FileHandler.copy(screenshot, destino);

            System.out.println("la caputra se a guardado exitosamente en: "+destino.getAbsolutePath());

        } catch (Exception e) {
            System.out.println("fallo en: "+e);
            throw new RuntimeException(e);
        }
        finally {
            dr.quit();
        }
    }
}
