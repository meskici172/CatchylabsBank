package utilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.HashMap;
import java.util.Map;
public class DriverManager {
    private static WebDriver driver;
    public static WebDriver getDriver() {
        if (driver == null) {
            String browser = System.getProperty("browser", "chrome");
            switch (browser.toLowerCase()) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
                case "mobile_chrome": // Android Chrome için
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions mobileOptions = new ChromeOptions();
                    Map<String, String> mobileEmulation = new HashMap<>();
                    mobileEmulation.put("deviceName", "Pixel 5"); // İstediğin cihazı seç
                    mobileOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
                    driver = new ChromeDriver(mobileOptions);
                    break;
                default:
                    throw new IllegalArgumentException("Geçersiz tarayıcı değeri: " + browser +
                            ". Desteklenen tarayıcılar: chrome, firefox, edge, mobile_chrome.");
            }
        }
        return driver;
    }
    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
