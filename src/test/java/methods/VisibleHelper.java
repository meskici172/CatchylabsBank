package methods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
public class VisibleHelper extends ReadHelper {
    /**
     * Verilen key ile eşleşen locator'a sahip bir elementin görünür olup olmadığını kontrol eder.
     *
     * @param key Kontrol edilecek elementin JSON'dan alınan anahtar değeri (locator'ı almak için kullanılır)
     */
    public void isElementVisible(String key) {
        try {
            // Locator'ı JSON'dan al
            By locator = readJsonValue(key);
            // Elementi bulmaya çalış
            WebElement element = driver.findElement(locator);
            // Elemanın görünür olup olmadığını kontrol et
            boolean isVisible = element.isDisplayed();

            logAction("isElementVisible", "Element görünürlük kontrolü yapıldı. Key: " + key + ", Locator: "
                    + locator + ", Görünür: " + isVisible);
        } catch (Exception e) {
            // Eğer element bulunamazsa görünür olmadığını varsay
            logAction("isElementVisible", "Element görünür değil. Key: " + key + ", Hata: " + e.getMessage());
        }
    }
}
