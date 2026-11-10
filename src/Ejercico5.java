import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Ejercico5 {
    public static void ejercicio5(){
        WebDriver dr =  new ChromeDriver();
        WebDriverWait wt = new WebDriverWait(dr, Duration.ofSeconds(5));

        try{
            dr.get("https://demoqa.com/webtables");
            dr.manage().window().maximize();

            wt.until(ExpectedConditions.elementToBeClickable(By.id("addNewRecordButton"))).click();

            wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("firstName"))).sendKeys("Carlos");
            wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("lastName"))).sendKeys("Ramírez");
            wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("userEmail"))).sendKeys("carlos@gmail.com");
            wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("age"))).sendKeys("25");
            wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("salary"))).sendKeys("2500000");
            wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("department"))).sendKeys("Sistemas");

            wt.until(ExpectedConditions.elementToBeClickable(By.id("submit"))).click();

            wt.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("table")));

            wt.until(ExpectedConditions.elementToBeClickable(By.id("searchBox"))).sendKeys("Carlos");



            Boolean nombre_correcto = wt.until(ExpectedConditions.textToBePresentInElementLocated(By.tagName("tbody"),"Carlos"));
            Boolean apellido_correcto = wt.until(ExpectedConditions.textToBePresentInElementLocated(By.tagName("tbody"),"Ramírez"));

            if(nombre_correcto && apellido_correcto){
                System.out.println("prueba realizada con exito");
            }else{
                System.out.println("hubo un problema fallo la prueba");
            }
        }finally {
            dr.quit();
        }
    }
}
