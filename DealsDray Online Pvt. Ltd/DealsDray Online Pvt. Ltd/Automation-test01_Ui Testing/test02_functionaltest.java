package functional_test;

import java.io.File;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class test02_functionaltest {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver.exe");

        

        
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        
        driver.get("https://demo.dealsdray.com/");

        // Login to the web application
        driver.findElement(By.xpath("//*[@id=\"mui-1\"]")).sendKeys("prexo.mis@dealsdray.com");
        driver.findElement(By.xpath("//*[@id=\"mui-2\"]")).sendKeys("prexo.mis@dealsdray.com");
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div/form/div[3]/div/button")).click();
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div[2]/div[1]/div[2]/button")).click();
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div[2]/div[1]/div[2]/div/div[1]/a/button")).click();
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div/div[2]/div[2]/button")).click();

      
        
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        
        WebElement fileInput = driver.findElement(By.xpath("//*[@id=\"mui-7\"]"));
        fileInput.sendKeys("C:\\\\Users\\\\Lenovo\\\\Documents\\\\demo-data.xlsx");
        driver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div/div/div[2]/div[3]/button")).click();
        driver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div/div/div[2]/div[3]/button")).click();
        
        Thread.sleep(5000);
        
        driver.switchTo().alert().accept();
        

        try {
     	   String filename=(new Date()).toString().replace(":", "-").trim()+".png";
     	   
     	   
     		   
     	   String destinationFilepath=System.getProperty("user.dir")+File.separator+"Screenshots/" +filename;
     	   System.out.println(destinationFilepath);
     	   try {
     		   TakesScreenshot ts =(TakesScreenshot) driver;
     		   File Source=ts.getScreenshotAs(OutputType.FILE);
     		   File destination=new File(destinationFilepath);
     		   FileUtils.copyFile(Source,destination);
     		   
     		   
     	   } catch (Exception e) {
     		   System.out.println("Exception while taking screenshot"+ e.getMessage());
     	   }
     			   
     			   
        }catch (Exception e) {
     	   
     	   e.printStackTrace();
        }
     	   
 	       Thread.sleep(3000);
       driver.close();
        
 	}

       
    	}
			

	


