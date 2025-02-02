package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@CucumberOptions(
        features = {
                "src/test/resources/features/login/failedLoginScenarios.feature", // ilk feature dosyası
                "src/test/resources/features/login/successLoginAndLogoutScenarios.feature", // Diğer feature dosyası
                "src/test/resources/features/edit/editAccountName.feature",  // Başka bir feature dosyası
                "src/test/resources/features/transfer/transferScenarios.feature",  // Başka bir feature dosyası
                "src/test/resources/features/add/addMoneyScenarios.feature"  // Başka bir feature dosyası

        },
        glue = {"stepDefinitions", "hooks"},      // Step Definition'ların bulunduğu paketler
        plugin = {"pretty", "html:target/cucumber-reports.html"},
        monochrome = true,
        tags = "@AllEdit or @SuccsessLogin or @AllTransfer or @AllAddMoney or @FailedLogin"

)
@RunWith(Cucumber.class)
public class AllTestRunner {
}
