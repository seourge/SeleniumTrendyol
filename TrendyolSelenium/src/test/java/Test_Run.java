import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class Test_Run extends Open_And_Login{

    @Test
    @Order(1)
    public void AcceptCookiesAndLogin() throws InterruptedException {
        //Çıkan Popop ve cookiesleri kabul et
        driver.findElement(By.id("Group-38")).click();
        driver.findElements(By.xpath("//div/button[@id='onetrust-accept-btn-handler']"));

        //Giriş yap'a tıkla - Kullanıcı Adı ve Şifre Gir
        driver.findElement(By.cssSelector(".account-nav-item.user-login-container")).click();
        driver.findElement(By.id("login-email")).sendKeys("seourgeseco@gmail.com");
        driver.findElement(By.id("login-password-input")).sendKeys("2085602350");
        driver.findElement(By.cssSelector(".q-primary.q-fluid.q-button-medium.q-button.submit")).click();
        Thread.sleep(1500);
    }

    @Test
    @Order(2)
    public void searchLiAction() throws InterruptedException {
        Actions actions = new Actions(driver);
        List<WebElement>menuBars = driver.findElements(By.cssSelector(".tab-link"));
        for (WebElement menuBar:menuBars){
            actions.moveToElement(menuBar).perform();
            Thread.sleep(2000);
        }
    }

    @Test
    @Order(3)
    public void searchProduct() throws InterruptedException {
        driver.findElement(By.cssSelector(".search-box")).sendKeys("figür");
        Thread.sleep(1500);
        driver.findElement(By.cssSelector(".search-icon")).click();
    }

    @Test
    @Order(4)
    public void selectProductAndAddToCart() throws InterruptedException {
        driver.findElement(By.xpath("//div[text()='MARVEL']")).click();
        Thread.sleep(1500);
        driver.findElement(By.xpath("(//div[text()='Sepete Ekle'])[27]")).click();
    }

}
