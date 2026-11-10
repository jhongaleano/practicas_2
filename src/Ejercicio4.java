import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Ejercicio4 {
    public static void ejercicio4(){
        WebDriver dr = new ChromeDriver();
        WebDriverWait wt = new WebDriverWait(dr, Duration.ofSeconds(5));
        Actions ac = new Actions(dr,Duration.ofSeconds(5));

        try{
            dr.get("https://demoqa.com/buttons");
            dr.manage().window().maximize();

            WebElement action = wt.until(ExpectedConditions.elementToBeClickable(By.id("doubleClickBtn")));
            ac.doubleClick(action).perform();

           Boolean confirmacion = wt.until(ExpectedConditions.textToBePresentInElementLocated(By.id("doubleClickMessage"),"You have done a double click"));
            if(confirmacion){
                System.out.println("la prueba se realizo con exito");
            }else {
                System.out.println("la prueba fallo en algun punto");
            }

        }finally {
            dr.quit();
        }
    }
}
