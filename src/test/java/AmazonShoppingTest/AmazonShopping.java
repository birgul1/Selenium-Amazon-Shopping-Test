package AmazonShoppingTest;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

public class AmazonShopping extends TestBaseBeforeAfter {
       /*
    Tarayıcıyı başlatın.
Amazon Türkiye e-ticaret sitesine gidin ("https://www.amazon.com.tr/").
Arama kutusuna bir ürün adı yazın ve arama yapın. Örneğin, "klavye".
Arama sonuçları arasından bir ürünü seçin ve ürün sayfasına gidin.
Ürün sayfasında bulunan "Sepete Ekle" düğmesine tıklayarak ürünü sepete ekleyin.
Satın alma işlemini başlatmak için ödeme sayfasına gidin.
Kargo bilgilerini doldurun.
Tarayıcıyı kapatın.
     */

    @Test
    public void Test() throws InterruptedException {
        driver.get("https://www.amazon.com.tr/");

        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='sp-cc-rejectall-link']")).click();

        WebElement searchBox = driver.findElement(By.xpath("(//*[@id='twotabsearchtextbox'])[1]"));
        searchBox.sendKeys("klavye", Keys.RETURN);

        WebElement selectedProduct = driver.findElement(By.xpath("(//*[@class='a-section a-spacing-base'])[3]"));
        selectedProduct.click();

        WebElement addToCart = driver.findElement(By.xpath("(//*[@id='add-to-cart-button'])[1]"));
        addToCart.click();

        WebElement proceedToCheckout = driver.findElement(By.name("proceedToRetailCheckout"));
        proceedToCheckout.click();

        WebElement mail = driver.findElement(By.xpath("//*[@id='ap_email']"));
        mail.sendKeys("denemetest@gmail.com", Keys.ENTER);

        WebElement password = driver.findElement(By.xpath("//*[@id='ap_password']"));
        password.sendKeys("Test12345", Keys.ENTER);

        WebElement fullName = driver.findElement(By.xpath("//*[@id='address-ui-widgets-enterAddressFullName']"));
        fullName.sendKeys("Test Deneme", Keys.TAB);

        WebElement phone = driver.findElement(By.xpath("//*[@name='address-ui-widgets-enterAddressPhoneNumber']"));
        phone.sendKeys("5497894545");

        WebElement address = driver.findElement(By.xpath("//*[@id='address-ui-widgets-enterAddressLine1']"));
        address.sendKeys("Şeyit osman avcı mahallesi 28 ekim sokak");

        WebElement addressTitle = driver.findElement(By.id("address-ui-widgets-enterAddressLine2"));
        addressTitle.sendKeys("Home", Keys.TAB);

        WebElement city = driver.findElement(By.xpath("//*[@id='address-ui-widgets-enterAddressCity']"));
        Actions actions = new Actions(driver);
        actions.click(city).sendKeys("Ankara",Keys.ARROW_DOWN).sendKeys(Keys.TAB).build().perform();


        WebElement region = driver.findElement(By.xpath("//*[@id='address-ui-widgets-enterAddressStateOrRegion']"));
        actions.click(region).sendKeys("Etimesgut",Keys.ARROW_DOWN).sendKeys(Keys.TAB).build().perform();

        WebElement county = driver.findElement(By.xpath("//*[@id='address-ui-widgets-enterAddressDistrictOrCounty']"));
        actions.click(county).sendKeys("Şehit Osman Avcı Mh.",Keys.ARROW_DOWN).sendKeys(Keys.TAB).sendKeys(Keys.TAB).build().perform();

        driver.findElement(By.xpath("(//*[@class='a-button-input'])[3]")).click();


    }
}
