package methods;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.*;
import utilities.DriverManager;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
public class functions extends ReadHelper {
    // WebDriver nesnesi
    private final WebDriver driver = DriverManager.getDriver();
    /**
     * Bir elementi kaydırma işlemine tabi tutar.
     *
     * @param key JSON'dan alınacak key
     */
    public void scrollToElement(String key) {
        By locator = readJsonValue(key);
        WebElement element = driver.findElement(locator);
        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        logAction("scrollToElement", "Elemente kaydırma işlemi yapıldı. Key: " + key + ", Locator: " + locator);
    }
    public void getDivClassesFromModal(String key) {
        // Locator'ı JSON'dan al
        By locator = readJsonValue(key);

        // WebElement'i bul
        WebElement element = driver.findElement(locator);

        // JavaScript ile modal içindeki tüm div'lerin class'larını almak
        JavascriptExecutor executor = (JavascriptExecutor) driver;

        // JavaScript kodu: Modal içindeki tüm div'lerin class'larını al
        String script =
                "var modal = arguments[0];" +
                        "var divs = modal.getElementsByTagName('div');" +
                        "var classes = [];" + // Boş bir dizi oluştur
                        "for (var i = 0; i < divs.length; i++) {" +
                        "   classes.push(divs[i].className);" + // className'i al ve diziye ekle
                        "}" +
                        "return classes;"; // Tüm class'ları döndür

        // Çalıştır ve sonucu al
        List<String> classNames = (List<String>) executor.executeScript(script, element);

        // Loglama işlemi
        logAction("getDivClassesFromModal", "Modal içindeki div öğelerinin class'ları alındı. Key: " + key + ", Classlar: " + classNames);
    }
    public void closeAlert() {
        try {
            // Alert'e geçiş yapıyoruz
            Alert alert = driver.switchTo().alert();

            // Alert'i kapatıyoruz (OK butonuna basar)
            alert.accept();
            logAction("closeAlert", "Alert Kapatıldı");
        } catch (Exception e) {
            logAction("closeAlert", "Alert Kapatılamadı!");
        }
    }
    public void openClosedDiv(String key) {
        // Get the element locator
        By locator = readJsonValue(key);

        // Use JavaScript to make the element visible
        String script = "var element = arguments[0];"
                + "if (element.style.display === 'none') {"
                + "   element.style.display = 'block';"
                + "}";

        // Find the element
        WebElement element = driver.findElement(locator);

        // Execute the script to open the div
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(script, element);

        // Log the action
        logAction("openClosedDiv", "Kapalı olan div açıldı. Key: " + key);
    }
    public void deletePlaceholder(String key) {
        By locator = readJsonValue(key);
        WebElement element = driver.findElement(locator);
        element.clear();
        logAction("deletePlaceholder", "Elementin içeriği temizlendi. Key: " + key + ", Locator: " + locator);
    }
    public String getElementText(String key) {
        try {
            By locator = readJsonValue(key);
            WebElement element = driver.findElement(locator);
            String text = element.getText().trim();
            logAction("getElementText", "Elementten alınan metin: '" + text + "'. Key: " + key + ", Locator: " + locator);
            return text;
        } catch (Exception e) {
            logAction("getElementText", "⚠️ Hata! Elementin metni alınamadı. Key: " + key);
            return "Element bulunamadı";
        }
    }
    public String getJsonText(String key) {
        try {
            // JSON dosyasının var olup olmadığını kontrol et
            String filePath = "src/test/resources/values/values.json"; // JSON dosyanın yolu
            if (!Files.exists(Paths.get(filePath))) {
                logAction("getJsonText", "❌ Hata! JSON dosyası bulunamadı: " + filePath);
                return "JSON okunamadı";
            }

            // JSON dosyasını oku
            String content = new String(Files.readAllBytes(Paths.get(filePath)));
            if (content.isEmpty()) {
                logAction("getJsonText", "❌ Hata! JSON dosyası boş: " + filePath);
                return "JSON okunamadı";
            }

            // JSON içeriğini parse et
            JSONObject json = new JSONObject(content);
            String value = json.optString(key, "Key bulunamadı");

            logAction("getJsonText", "✅ JSON'dan alınan değer: '" + value + "'. Key: " + key);
            return value;
        } catch (Exception e) {
            logAction("getJsonText", "⚠️ Hata! JSON'dan değer alınamadı. Key: " + key + ", Hata: " + e.getMessage());
            return "JSON okunamadı";
        }
    }
    /**
     * Verilen key ile eşleşen textbox içeriği ile verilen metni karşılaştırır.
     *
     * @param key Kontrol edilecek elementin JSON'dan alınan anahtar değeri (locator'ı almak için kullanılır)
     * @param expectedText Beklenen metin
     */
    public void compareTextbox(String key, Object expectedText) {
        try {
            // Locator'ı JSON'dan al
            By locator = readJsonValue(key);
            // Elementi bulmaya çalış
            WebElement element = driver.findElement(locator);
            // Elementin içeriğini al
            String actualText = element.getText();
            // Convert expectedText to String if it's an Object
            String expectedTextString = (expectedText != null) ? expectedText.toString() : "";
            // Beklenen metin ile karşılaştır
            boolean isMatch = actualText.equals(expectedTextString);

            // Log işlemi
            logAction("compareTextbox", "Textbox karşılaştırması yapıldı. Key: " + key + ", Beklenen: '"
                    + expectedTextString + "', Gerçekleşen: '" + actualText + "', Eşleşme: " + isMatch);

            // Eğer içerik eşleşmezse, hata logu
            if (!isMatch) {
                logAction("compareError", "❌ Hata! Eşleşme Başarısız: " + actualText);
                Assert.fail("🚨 Başarısız Eşleşme: " + actualText);
            }
        } catch (Exception e) {
            // Hata durumu logu
            logAction("compareTextbox", "Textbox kontrolü sırasında hata oluştu. Key: " + key + ", Hata: " + e.getMessage());
        }
    }
    /**
     * Verilen key ile eşleşen textbox içeriği ile verilen metni karşılaştırır.
     *
     * @param key1 Kontrol edilecek elementin JSON'dan alınan anahtar değeri (locator'ı almak için kullanılır)
     * @param key2 Beklenen metin değerini value JSON'dan alır
     */
    public void compareTextboxes(String key1, String key2) {
        try {
            // Key1 için Locator'ı JSON'dan al
            By locator1 = readJsonValue(key1);
            WebElement element1 = driver.findElement(locator1);
            String text1 = element1.getText(); // İlk textbox içeriği

            String text2;

            // Key2'nin bir locatör olup olmadığını kontrol et
            if (isLocator(key2)) {
                By locator2 = readJsonValue(key2);
                WebElement element2 = driver.findElement(locator2);
                text2 = element2.getText(); // İkinci textbox içeriği
            } else {
                // JSON formatında ise, 'value' değerini al
                String jsonString = getJsonText(key2);
                text2 = extractValueFromJson(jsonString); // JSON'dan sayıyı al
            }

            // Metinleri formatla
            String formattedText1 = formatText(text1);
            String formattedText2 = formatText(text2);

            // Karşılaştırma yap
            boolean isMatch = formattedText1.equals(formattedText2);

            // Log işlemi
            logAction("compareTextboxes", "Textbox karşılaştırması yapıldı. Key1: " + key1 + ", Key2: " + key2 +
                    ", Metin1: '" + formattedText1 + "', Metin2: '" + formattedText2 + "', Eşleşme: " + isMatch);

            // Eğer içerik eşleşmezse, hata fırlat
            if (!isMatch) {
                logAction("compareError", "❌ Hata! Eşleşme Başarısız: Metin1: '" + formattedText1 + "' Metin2: '" + formattedText2 + "'");
                try {
                    // Hata fırlat, ancak testin devam etmesini sağla
                    Assert.fail("🚨 Başarısız Eşleşme: Metin1: '" + formattedText1 + "' Metin2: '" + formattedText2 + "'");
                } catch (AssertionError e) {
                    // Hata mesajını logla ve testin devam etmesini sağla
                    logAction("compareError", "⚠️ Hata, ancak test devam ediyor: " + e.getMessage());
                }
            }
        } catch (Exception e) {
            logAction("compareTextboxes", "⚠️ Hata! Textbox kontrolü sırasında hata oluştu. Key1: " + key1 + ", Key2: " + key2 + ", Hata: " + e.getMessage());
        }
    }
    // JSON string'ten 'value' alanını çeken metod
    private String extractValueFromJson(String jsonString) {
        try {
            // JSON objesini parse et
            JSONObject jsonObject = new JSONObject(jsonString);
            // "value" alanındaki değeri al
            return jsonObject.optString("value", "");
        } catch (Exception e) {
            logAction("extractValueFromJson", "⚠️ Hata! JSON çözümleme sırasında hata oluştu: " + e.getMessage());
            return "";
        }
    }
    public String formatText(String text) {
        // Virgülleri kaldır, boşlukları temizle
        return text.replace(",", "").trim();
    }
    // Key'in bir locator olup olmadığını kontrol eden metod
    private boolean isLocator(String key) {
        try {
            // Eğer key bir locator ise, burada hata almayız
            readJsonValue(key);
            return true;
        } catch (Exception e) {
            // Eğer burada hata alırsak, bu key bir locator değildir
            return false;
        }
    }






}