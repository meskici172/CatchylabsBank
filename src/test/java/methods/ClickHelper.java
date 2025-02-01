package methods;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
public class ClickHelper extends ReadHelper {
    /**
     * Bir elemente tıklama işlemi yapar.
     *
     * @param key JSON'dan alınacak key
     */
    public void clickElement(String key) {
        By locator = readJsonValue(key);
        WebElement element = driver.findElement(locator);
        element.click();
        logAction("clickElement", "Elemente tıklama işlemi gerçekleştirildi. Key: " + key + ", Locator: " + locator);
    }
    public void clickFirstOption(String key) {
        By locator = readJsonValue(key);  // JSON'dan locatorü oku
        WebElement dropdown = driver.findElement(locator); // Dropdown'ı bul

        dropdown.click(); // Selectbox’ı aç
        logAction("clickFirstOption", "Selectbox açıldı. Key: " + key + ", Locator: " + locator);

        Select select = new Select(dropdown);
        select.selectByIndex(0); // İlk seçeneği seç

        logAction("clickFirstOption", "İlk seçenek seçildi: " + select.getFirstSelectedOption().getText());
    }
    public void clickElementWithMouse(String key) {
        // JSON'dan locatörü al
        By locator = readJsonValue(key);

        // Elementi bul ve görünür olmasını bekle
        WebElement element = waitUntilVisible(locator);

        // Elementin etrafına border ekle (Fareyi görünür kılmak için görsel ipucu)
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.border='10px solid red';", element);

        // Actions sınıfını kullanarak fare ile tıklama işlemi yap
        try {
            Actions actions = new Actions(driver);
            actions.moveToElement(element).click().perform(); // Fareyi elemana getir ve tıkla
            logAction("clickElement", "Fare ile elemente tıklama işlemi gerçekleştirildi. Key: " + key + ", Locator: " + locator);

            // Tıklama işleminden sonra border'ı kaldır
            js.executeScript("arguments[0].style.border='';", element);
        } catch (ElementClickInterceptedException e) {
            // Eğer element başka bir element tarafından engelleniyorsa, JavaScript ile tıklama yap
            js.executeScript("arguments[0].click();", element);
            logAction("clickElement", "JavaScript ile elemente tıklama işlemi gerçekleştirildi. Key: " + key + ", Locator: " + locator);
        }
    }
    // Görünür olana kadar bekleme fonksiyonu
    public WebElement waitUntilVisible(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // 10 saniye bekleme süresi
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public void jsClicker(String key) {
        // Locator'ı JSON'dan al
        By locator = readJsonValue(key);

        // WebElement'i bul
        WebElement element = driver.findElement(locator);

        // JavaScript ile tıklama
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);

        logAction("jsClicker", "Elemente JavaScript ile tıklama işlemi gerçekleştirildi. Key: " + key + ", Locator: " + locator);
    }
    public void clickElementIfHiddenDivExist(String parentKey, String childKey) {
        // Ana div öğesinin lokasyonunu al
        By parentLocator = readJsonValue(parentKey);
        WebElement parentElement = driver.findElement(parentLocator);

        // Alt öğenin lokasyonunu al
        By childLocator = readJsonValue(childKey);
        WebElement childElement = parentElement.findElement(childLocator);

        // Alt öğeye tıklama işlemi
        try {
            if (childElement.isDisplayed() && childElement.isEnabled()) {
                childElement.click();
                logAction("clickElement", "Alt öğeye tıklama işlemi gerçekleştirildi. Parent Key: " + parentKey + ", Child Key: " + childKey);
            } else {
                logAction("clickElement", "Alt öğe tıklanabilir değil. Parent Key: " + parentKey + ", Child Key: " + childKey);
            }
        } catch (Exception e) {
            logAction("clickElement", "Alt öğeye tıklama hatası: " + e.getMessage());
        }
    }
    public void clickElementWithHighlight(String key) {
        // Locator'ı JSON'dan al
        By locator = readJsonValue(key);

        // WebElement'i bul
        WebElement element = driver.findElement(locator);

        // JavaScript ile elementin etrafını sarıya boyayalım
        String script = "arguments[0].style.border='3px solid yellow';";
        ((JavascriptExecutor) driver).executeScript(script, element);

        // Tıklama işlemini gerçekleştir
        element.click();

        // Log işlemi
        logAction("clickElementWithHighlight", "Elemente tıklama işlemi gerçekleştirildi ve etrafı sarıya boyandı. Key: " + key + ", Locator: " + locator);
    }
    public void clickOnH3TitleByIndex(String key, int index) {
        try {
            // JSON'dan locator değerini al
            By locator = readJsonValue(key);

            // Tüm h3 elemanlarını bul
            List<WebElement> elements = driver.findElements(locator);
            int elementCount = elements.size(); // Öğe sayısını al

            // Verilen index'in geçerli olup olmadığını kontrol et
            if (index < 0 || index >= elementCount) {
                String errorMessage = "Geçersiz index: " + index + ". Bulunan öğe sayısı: " + elementCount;
                logAction("clickOnH3TitleByIndex", errorMessage);
                throw new IndexOutOfBoundsException(errorMessage);
            }

            // Belirtilen indexteki h3 öğesini seç
            WebElement h3Element = elements.get(index);

            // highlightElement ile h3 öğesini sarıya boya (isteğe bağlı)
            highlightElement(h3Element);

            // h3 öğesinin altındaki a öğesini al
            WebElement linkElement = h3Element.findElement(By.tagName("a"));

            // a etiketi üzerinde tıklama işlemini gerçekleştir
            highlightElement(linkElement); // İsteğe bağlı, tıklanacak alanı vurgulama
            linkElement.click();

            // Başarılı tıklama logu
            logAction(
                    "clickOnH3TitleByIndex",
                    "Index: " + index + " öğesinin altında bulunan 'a' etiketine tıklandı. Locator: " + locator + ", Bulunan öğe sayısı: " + elementCount
            );

        } catch (IndexOutOfBoundsException e) {
            // Index dışı durumlar için özel hata logu
            logAction("clickOnH3TitleByIndex", "Hata: " + e.getMessage());
            throw e; // Hatanın üst katmana iletilmesi
        } catch (Exception e) {
            // Genel hata durumları için log
            logAction("clickOnH3TitleByIndex", "H3 başlığı içindeki 'a' etiketine tıklanırken beklenmeyen bir hata oluştu. Mesaj: " + e.getMessage());
            throw new RuntimeException("H3 başlığı altında bulunan 'a' etiketine tıklanırken bir hata oluştu.", e);
        }
    }
    public void highlightElement(WebElement element) {
        try {
            // JavascriptExecutor oluştur
            JavascriptExecutor js = (JavascriptExecutor) driver; // Global driver kullanılıyor

            // Orijinal stili tutmak için mevcut stil değerini al
            String originalStyle = element.getAttribute("style");

            // Ögeyi sarıya boyat
            js.executeScript("arguments[0].setAttribute('style', arguments[1]);",
                    element,
                    "background: yellow; border: 2px solid orange;");

            // Vurgu birkaç saniye sonra kaldır (isteğe bağlı)
            Thread.sleep(1000); // Bu süreyi değiştirebilirsiniz.
            js.executeScript("arguments[0].setAttribute('style', arguments[1]);",
                    element,
                    originalStyle); // Orijinal stile geri dön
        } catch (Exception e) {
            System.out.println("Element vurgulama sırasında bir hata oluştu: " + e.getMessage());
        }
    }
}
