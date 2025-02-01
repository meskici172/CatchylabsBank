package stepDefinitions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import methods.*;
import org.json.JSONObject;

import java.math.BigDecimal;

public class TransferMoneySteps {
    // `functions` sınıfı örneği oluşturuyoruz.
    private final functions helper = new functions();
    private final ClickHelper clickHelper = new ClickHelper();
    private final VisibleHelper visibleHelper = new VisibleHelper();
    private final WaitHelper waitHelper = new WaitHelper();
    private final WriteHelper writeHelper = new WriteHelper();
    @And("Check My Account Information")
    public void checkMyAccountInformation() {
        waitHelper.waitForTwoSeconds();
        waitHelper.waitForElement("checkAccountName",10);
        waitHelper.waitForElement("checkAmount",10);

        String value = helper.getElementText("checkAmount");
        helper.logAction("AMOUNTTTTTT : " + value,"+++ ");
        writeHelper.writeJson("nowAmount",value);
        helper.compareTextbox("checkAccountName", "123Mehmet");
        helper.compareTextbox("checkAccountType", "CHECKING");
        helper.compareTextboxes("checkAmount", "nowAmount");
        helper.logAction("checkAccountName", "Karşılaştırma işlemi tamamlandı.");

    }

    @And("Click Transfer Money Button")
    public void clickTransferMoneyButton() {
        clickHelper.clickElementWithHighlight("transferMoneyButton");
        helper.logAction("transferMoneyButton", "transferMoneyButton Tıklama Tamamlandı.");
    }
    @And("Write Amount {string}")
    public void writeAmount(String keyword) {
        try {
            helper.getDivClassesFromModal("waitDiv");
            helper.openClosedDiv("waitDiv");
            helper.openClosedDiv("waitModal");
            waitHelper.waitForElement("inputFieldForAmount", 10);

            clickHelper.clickElementWithHighlight("inputFieldForAmount");
            writeHelper.writeToElement("inputFieldForAmount", keyword);
            helper.logAction("inputFieldForAmount", "Amount Yazma işlemi Tamamlandı.");

            // Eğer negatif bir sayı girilmişse log kaydedecek
            if (Double.parseDouble(keyword) < 0) {
                helper.logAction("NegativeAmountError", "❌ Negatif bir sayı girildi: " + keyword);
            }

        } catch (Exception e) {
            // Diğer hatalar için genel hata mesajı
            helper.logAction("Error", "Beklenmeyen bir hata oluştu: " + e.getMessage());
        }
    }
    @And("Click Recevier Testinium2 Account")
    public void clickRecevierAccountTestinium2() {
        waitHelper.waitForElement("waitDiv",3);
        clickHelper.clickElementIfHiddenDivExist("waitDiv","selectElementReceiver");
        clickHelper.clickElementWithHighlight("optionTestinium2");
        helper.closeAlert();
        helper.logAction("selectElementReceiver", "selectElementRecevier işlemi Tamamlandı. Testinium2 Seçildi");

    }
    @And("Click Recevier Testinium3 Account")
    public void clickRecevierAccountTestinium3() {
        waitHelper.waitForElement("waitDiv",3);
        clickHelper.clickElementIfHiddenDivExist("waitDiv","selectElementReceiver");
        clickHelper.clickElementWithHighlight("optionTestinium3");
        helper.closeAlert();
        helper.logAction("selectElementReceiver", "selectElementRecevier işlemi Tamamlandı. Testinium2 Seçildi");

    }
    @And("Click Recevier Testinium4 Account")
    public void clickRecevierAccountTestiniu4() {
        waitHelper.waitForElement("waitDiv",3);
        clickHelper.clickElementIfHiddenDivExist("waitDiv","selectElementReceiver");
        clickHelper.clickElementWithHighlight("optionTestinium4");
        helper.closeAlert();
        helper.logAction("selectElementReceiver", "selectElementRecevier işlemi Tamamlandı. Testinium2 Seçildi");

    }
    @And("Click Recevier Testinium5 Account")
    public void clickRecevierAccountTestinium5() {
        waitHelper.waitForElement("waitDiv",3);
        clickHelper.clickElementIfHiddenDivExist("waitDiv","selectElementReceiver");
        clickHelper.clickElementWithHighlight("optionTestinium5");
        helper.closeAlert();
        helper.logAction("selectElementReceiver", "selectElementRecevier işlemi Tamamlandı. Testinium2 Seçildi");

    }

    @And("Click Send Button")
    public void clickSendButton() {
        waitHelper.waitForElement("transferSendButton", 3);
        visibleHelper.isElementVisible("transferSendButton");
        clickHelper.clickElementWithMouse("transferSendButton");
        helper.logAction("transferMoneyButton", "transferMoneyButton Tıklama Tamamlandı.");
    }

    @Then("Check My Account Information Again")
    public void checkMyAccountInformationAgain() {
        waitHelper.waitForElement("checkAccountName", 3);
        // JSON stringini al
        String jsonValue = helper.getJsonText("nowAmount");
        // JSON objesine çevir
        JSONObject jsonObj = new JSONObject(jsonValue);
        String amountStr = jsonObj.getString("value"); // "-29,070,000,000,007,510.00"
        // Virgülleri kaldır ve BigDecimal olarak işle
        amountStr = amountStr.replace(",", ""); // "-29070000000007510.00"
        BigDecimal amount = new BigDecimal(amountStr);
        // 100 çıkar
        BigDecimal newValue = amount.subtract(BigDecimal.valueOf(100));
        // Yeni değeri string olarak yaz
        writeHelper.writeJson("newAmount", newValue.toPlainString());
        // Diğer işlemler
        helper.compareTextbox("checkAccountName", "123Mehmet");
        helper.compareTextbox("checkAccountType", "CHECKING");
        helper.compareTextboxes("checkAmount", "newAmount");
        helper.logAction("Account Information", "Karşılaştırma işlemi tamamlandı.");
    }
    @Then("Check Transaction Information")
    public void checkMyTransactionInformation(){
        waitHelper.waitForTwoSeconds();
        String recevier = helper.getJsonText("transactionReceiver");
        writeHelper.writeJson("newAmount",recevier);
        waitHelper.waitForElement("transactionSender", 3);
        helper.compareTextbox("transactionSender", "123Mehmet");
        helper.compareTextboxes("transactionReceiver", "recevier");
        helper.compareTextbox("transactionAmount", "");
        helper.logAction("Transaction", "Karşılaştırma işlemleri tamamlandı.");
    }
}
