package runners.transfer;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/transfer/transferScenarios.feature", // Feature dosyalarının doğru klasör yolu
        glue = {"stepDefinitions", "hooks"},      // Step Definition'ların bulunduğu paketler
        plugin = {"pretty", "html:target/cucumber-reports.html"},
        monochrome = true,
        tags = " @TransferMoney and @NegativeAmount"
)
public class TransferRunner {
}