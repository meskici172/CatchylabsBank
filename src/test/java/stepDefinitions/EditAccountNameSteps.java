package stepDefinitions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import methods.*;
import org.junit.Assert;

public class EditAccountNameSteps {
    // `functions` sınıfı örneği oluşturuyoruz.
    private final functions helper = new functions();
    private final ClickHelper clickHelper = new ClickHelper();
    private final VisibleHelper visibleHelper = new VisibleHelper();
    private final WaitHelper waitHelper = new WaitHelper();
    private final WriteHelper writeHelper = new WriteHelper();

    @And("Click Open Money Transfer Button")
    public void clickOpenMoneyTransferButton() {
        waitHelper.waitForElement("openMoneyTransferBtn", 10);
        clickHelper.clickElementWithHighlight("openMoneyTransferBtn");
        helper.logAction("Open Money Button", "Open Money Butonuna tıklandı.");

    }
    @And("Click Edit Account Button")
    public void clickEditAccountButton() {
        waitHelper.waitForElement("editButton", 10);
        clickHelper.clickElementWithHighlight("editButton");
        helper.logAction("Edit Button", "Edit Butonuna tıklandı.");
    }
    @And("Write Account Name {string}")
    public void writeAccountName(String keyword){
        waitHelper.waitForElement("writeAccountBox", 10);
        helper.deletePlaceholder("writeAccountBox");
        waitHelper.waitForElement("writeAccountBox", 10);
        writeHelper.writeToElement("writeAccountBox", keyword);
        helper.logAction("WriteBox", "Write Box Alanına isim yazıldı.");
    }
    @And("Click Update Button")
    public void clickUpdateButton(){
        waitHelper.waitForElement("updateButton", 10);
        clickHelper.clickElementWithHighlight("updateButton");
        helper.logAction("Update Button", "Update Butonuna Tıklandı.");

    }

    @Then("Check Account Name of {string} After The Update")
    public void checkAccountName(String keyword){
        waitHelper.waitForElement("checkAccountName",10);
        String actualAccountName = helper.getElementText("checkAccountName");

        // Eğer rakam veya boşluk içeriyorsa TESTİ BAŞARISIZ YAP
        if (keyword.trim().isEmpty() || !keyword.matches("^[a-zA-Z]+$")) {
            helper.logAction("AccountName", "❌ Hata! Hatalı isim kabul edildi: " + keyword);
            Assert.fail("🚨 Hatalı Account Name kabul edildi: " + keyword);
        }

        helper.compareTextbox("checkAccountName", keyword);
        helper.logAction("AccountName", "✅ Account Name " + keyword + " doğru şekilde güncellendi.");
    }
}
