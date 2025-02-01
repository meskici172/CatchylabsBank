package hooks;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import utilities.DriverManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
public class Hooks {
    private static final Logger logger = LogManager.getLogger(Hooks.class);
    @Before
    public void setUp() {
        String browser = System.getProperty("browser", "chrome");
        logger.info("Test başlıyor...");
        logger.info("Seçilen tarayıcı: " + browser);

        if (!browser.equalsIgnoreCase("mobile_chrome")) {
            logger.info("Pencereyi büyütüyoruz...");
            DriverManager.getDriver().manage().window().maximize();
        } else {
            logger.info("Mobil tarayıcıda test yapılıyor, pencere boyutu değiştirilmedi.");
        }

        logger.info("Test hazırlığı tamamlandı.");
    }
    @After
    public void tearDown() {
        try {
            logger.info("Test bitiyor, tarayıcı kapanmadan önce 5 saniye bekleniyor...");
            Thread.sleep(5000);
            logger.info("5 saniyelik bekleme tamamlandı.");
        } catch (InterruptedException e) {
            logger.error("Bekleme sırasında bir hata oluştu: " + e.getMessage());
        } finally {
            logger.info("Tarayıcı kapanıyor...");
            DriverManager.quitDriver();
            logger.info("Tarayıcı başarıyla kapatıldı.");
        }
    }
}
