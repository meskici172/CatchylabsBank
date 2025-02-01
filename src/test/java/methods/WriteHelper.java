    package methods;
    import org.json.JSONObject;
    import org.openqa.selenium.By;
    import org.openqa.selenium.JavascriptExecutor;
    import org.openqa.selenium.WebElement;
    import java.io.FileWriter;
    import java.io.IOException;
    import java.nio.file.Files;
    import java.nio.file.Paths;

    public class WriteHelper extends ReadHelper{
        /**
         * Bir elemente metin yazar.
         *
         * @param key   JSON'dan alınacak key
         * @param value Yazılacak metin
         */
        public void writeToElement(String key, String value) {
            By locator = readJsonValue(key);
            WebElement element = driver.findElement(locator);
            element.sendKeys(value);
            logAction("writeToElement", "Elemente '" + value + "' yazıldı. Key: " + key + ", Locator: " + locator);
        }
        public void jsWriterElement(String key, String text) {
            // Locator'ı JSON'dan al
            By locator = readJsonValue(key);

            // WebElement'i bul
            WebElement element = driver.findElement(locator);

            // JavaScript ile yazma işlemi
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].value = arguments[1];", element, text);

            logAction("jsWriterElement", "Elemente JavaScript ile yazma işlemi gerçekleştirildi. Key: " + key + ", Text: " + text + ", Locator: " + locator);
        }
        /**
         * Verilen değeri belirtilen JSON dosyasına kaydeder.
         *
         * @param key   JSON anahtarı (isim)
         * @param value Kaydedilecek değer
         */
        public void writeJson(String key, String value) {
            String filePath = "src/test/resources/values/values.json";
            JSONObject jsonObject;

            try {
                // Eğer dosya varsa içeriğini oku
                String content = new String(Files.readAllBytes(Paths.get(filePath)));
                jsonObject = new JSONObject(content);
            } catch (IOException e) {
                // Dosya yoksa yeni bir JSON nesnesi oluştur
                jsonObject = new JSONObject();
            }

            // Yeni değeri JSON nesnesine ekle
            JSONObject innerObject = new JSONObject();
            innerObject.put("value", value);
            jsonObject.put(key, innerObject);

            // JSON'u dosyaya yaz
            try (FileWriter file = new FileWriter(filePath)) {
                file.write(jsonObject.toString(4)); // 4 boşlukla girintili formatta yaz
                file.flush();
                logAction("writeJson", "JSON dosyasına yazıldı: Key: " + key + ", Value: " + value);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
