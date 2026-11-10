import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Ejercicio1 {
    public static void ejercicio1(){
        WebDriver dr = new ChromeDriver();
        WebDriverWait await = new WebDriverWait(dr, Duration.ofSeconds(5));


        try {
            dr.get("https://demoqa.com/text-box");

            dr.manage().window().maximize();

            await.until(ExpectedConditions.visibilityOfElementLocated(By.id("userName"))).sendKeys("Laura Martínez");

            await.until(ExpectedConditions.visibilityOfElementLocated(By.id("userEmail"))).sendKeys("laura@gmail.com");

            await.until(ExpectedConditions.visibilityOfElementLocated(By.id("currentAddress"))).sendKeys("Calle 25 # 10-20");

            await.until(ExpectedConditions.visibilityOfElementLocated(By.id("permanentAddress"))).sendKeys("Carrera 15 # 30-40");

            await.until(ExpectedConditions.elementToBeClickable(By.id("submit"))).click();

           String nombre = await.until(ExpectedConditions.visibilityOfElementLocated(By.id("name"))).getText();

           String Email = await.until(ExpectedConditions.visibilityOfElementLocated(By.id("email"))).getText();

           if (nombre.contains("Laura Martínez") && Email.contains("laura@gmail.com")){
               System.out.println("la pureba se realizo con exto con el usuario: "+nombre);
           }else {
               System.out.println("la prueba ha fallado en algo");
           }
        } catch (Exception e) {
            System.out.println("el error es: "+e);
            throw new RuntimeException(e);
        }
        finally {
            dr.quit();
        }
    }
}
