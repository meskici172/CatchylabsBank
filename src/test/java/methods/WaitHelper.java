package methods;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
public class WaitHelper extends ReadHelper {
    /**
     * Bir elementin 2 saniye içinde görünür hale gelmesini bekler.
     *
     *
     */
    public void waitForTwoSeconds() {
        try {
            Thread.sleep(2000); // 2 saniye bekler
            logAction("waitForTwoSeconds", "2 saniye bekleme tamamlandı.");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            logAction("waitForTwoSeconds", "Bekleme sırasında bir hata oluştu: " + e.getMessage());
        }
    }
    /**
     * Bir elementin belirli bir süre içinde görünür hale gelmesini bekler.
     *
     * @param key            JSON'dan alınacak key
     * @param timeoutSeconds Beklenecek süre (saniye)
     */
    public void waitForElement(String key, int timeoutSeconds) {
        By locator = readJsonValue(key); // By nesnesi kullanılıyor
        new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds))
                .until(driver -> driver.findElement(locator));
        logAction("waitForElement", "Element için " + timeoutSeconds + " saniye beklendi. Key: " + key);
    }
}
