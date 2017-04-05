package ohtu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tester {

    public static void main(String[] args) {
	System.setProperty("webdriver.chrome.driver", "chromedriverkansio/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("http://localhost:4567");
        
        sleep(2);
        
        WebElement element = driver.findElement(By.linkText("login"));
        element.click();

        sleep(2);

        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("password"));
        element.sendKeys("akkep");
        element = driver.findElement(By.name("login"));
        
        sleep(2);
        element.submit();

        sleep(3);
        
        driver.quit();

	//oikea käyttäjätunnus väärä salasana
        driver = new ChromeDriver();

        driver.get("http://localhost:4567");
        
        sleep(1);
        
        element = driver.findElement(By.linkText("login"));
        element.click();

        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("password"));
        element.sendKeys("vaarasalasana");
        element = driver.findElement(By.name("login"));
        
        sleep(1);
        element.submit();

        sleep(1);
        
        driver.quit();

        //ei olemassaoleva käyttäjätunnus
        driver = new ChromeDriver();

        driver.get("http://localhost:4567");
        
        sleep(1);
        
        element = driver.findElement(By.linkText("login"));
        element.click();

        element = driver.findElement(By.name("username"));
        element.sendKeys("olematon");
        element = driver.findElement(By.name("password"));
        element.sendKeys("salasana");
        element = driver.findElement(By.name("login"));
        
        sleep(1);
        element.submit();

        sleep(1);
        
        driver.quit();

        //uusi käyttäjätunnus
        driver = new ChromeDriver();

        driver.get("http://localhost:4567");
        
        sleep(1);
        
        element = driver.findElement(By.linkText("register new user"));
        element.click();

        element = driver.findElement(By.name("username"));
        element.sendKeys("matti");
        element = driver.findElement(By.name("password"));
        element.sendKeys("ittam");
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys("ittam");
        element = driver.findElement(By.name("signup"));
        
        sleep(1);
        element.submit();

        sleep(1);

        element = driver.findElement(By.linkText("continue to application mainpage"));
        element.click();

        sleep(1);

        element = driver.findElement(By.linkText("logout"));
        element.click();
        
        driver.quit();
    }
    
    private static void sleep(int n){
        try{
            Thread.sleep(n*1000);
        } catch(Exception e){}
    }
}
