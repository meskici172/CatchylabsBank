package methods;
import methods.enums.LocatorType;
import org.json.JSONObject;
import org.openqa.selenium.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.nio.file.Files;
import java.nio.file.Paths;
public class ReadHelper extends DriverHelper {
    private static final List<String> LOCATORS_FILE_PATHS = Arrays.asList(
            "src/test/resources/locators/loginLocators.json",
            "src/test/resources/locators/editLocators.json",
            "src/test/resources/locators/locators.json",
            "src/test/resources/locators/mainLocators.json",
            "src/test/resources/locators/transferLocators.json",
            "src/test/resources/locators/addMoneyLocators.json",
            "src/test/resources/values/values.json"

    );
    // Logger nesnesi
    private static final Logger logger = LoggerFactory.getLogger(ReadHelper.class);
    /**
     * Belirtilen LocatorType türüne göre doğru By nesnesini döndürür.
     *
     * @param locatorType Locator türü (ID, XPATH vb.)
     * @param locator     Locator değeri
     * @return By nesnesi
     */
    public By getBy(LocatorType locatorType, String locator) {
        switch (locatorType) {
            case XPATH:
                return By.xpath(locator);
            case ID:
                return By.id(locator);
            case CLASS_NAME:
                return By.className(locator);
            case CSS_SELECTOR:
                return By.cssSelector(locator);
            case TAG_NAME:
                return By.tagName(locator);
            case LINK_TEXT:
                return By.linkText(locator);
            case PARTIAL_LINK_TEXT:
                return By.partialLinkText(locator);
            default:
                throw new IllegalArgumentException("Geçersiz locator türü: " + locatorType);
        }
    }
    /**
     * JSON'dan belirtilen key'e karşılık gelen locator değerini okur.
     *
     * @param key JSON'daki key
     * @return Locator değeri
     */
    public By readJsonValue(String key) {
        String value = "";
        try {
            for (String filePath : LOCATORS_FILE_PATHS) {
                try {
                    // JSON dosyasını oku
                    String content = new String(Files.readAllBytes(Paths.get(filePath)));
                    JSONObject jsonObject = new JSONObject(content);

                    // Eğer JSON içinde key varsa, işleme devam et
                    if (jsonObject.has(key)) {
                        JSONObject locatorObject = jsonObject.getJSONObject(key);
                        String type = locatorObject.getString("type");
                        value = locatorObject.getString("value");

                        // Enum'dan LocatorType al ve By objesi oluştur
                        LocatorType locatorType = LocatorType.valueOf(type.toUpperCase());
                        By by = getBy(locatorType, value);

                        // Log kaydı
                        logAction("readJsonValue", "JSON dosyası okundu. Dosya: " + filePath + ", Key: " + key + ", LocatorType: " + type + ", Locator: " + value);

                        return by; // İlk bulunan değeri döndür
                    }
                } catch (IOException e) {
                    logAction("readJsonValue", "JSON dosyası okunurken hata oluştu: " + filePath + " - Hata: " + e.getMessage());
                }
            }

            // Eğer hiçbir JSON dosyasında key bulunmazsa hata fırlat
            throw new RuntimeException("Hiçbir JSON dosyasında key bulunamadı: " + key);

        } catch (Exception e) {
            logAction("readJsonValue", "JSON dosyaları taranırken hata oluştu. Key: " + key + ", Hata: " + e.getMessage());
            throw new RuntimeException("JSON dosyaları taranırken bir hata oluştu. Key: " + key + " - Value: " + value);
        }
    }
    /**
     * Loglama işlemi için yardımcı metot.
     *
     * @param methodName Metot adı
     * @param message    Loglanacak mesaj
     */
    public void logAction(String methodName, String message) {
        logger.info("[{}] - {}", methodName, message);
    }
}
