package runners.login;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {
                "src/test/resources/features/login/failedLoginScenarios.feature", // ilk feature dosyası
                "src/test/resources/features/login/successLoginAndLogoutScenarios.feature"  // ikinci dosyası
        }, // Feature dosyalarının doğru klasör yolu
        glue = {"stepDefinitions", "hooks"},      // Step Definition'ların bulunduğu paketler
        plugin = {"pretty", "html:target/cucumber-reports.html"},
        monochrome = true
)
public class LoginRunner {
}