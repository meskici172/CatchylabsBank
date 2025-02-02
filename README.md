# **Web Tabanlı Bankacılık Uygulaması Otomasyon Test Projesi**

## 📋 **Proje Hakkında**
Bu proje, bir web tabanlı bankacılık uygulamasının otomasyon testlerini kapsamaktadır. Kullanıcıların login olma, para transferi, kart ile para yatırma ve hesap ayarları işlemlerini başarıyla gerçekleştirebilmesi için gerekli tüm işlevlerin test edilmesi hedeflenmiştir. Proje, kullanıcı deneyimini ve güvenliğini artırmayı amaçlayan kapsamlı bir test stratejisi sunar.

---

## 🔧 **Proje Özellikleri**
- **Fonksiyonlar:**
  - Success Login-Logout işlemleri
  - Failed Login işlemleri
  - Para transferi işlemleri.
  - Kart ile para yatırma işlemi.
  - Hesap ayarları
  - UI/UX testleri.
  - Farklı tarayıcı uyumluluk testleri (Chrome, Firefox, Edge).

- **Kullanılan Teknolojiler:**
  - **Java:** Test otomasyonu kodlaması için.
  - **Selenium WebDriver:** Tarayıcı otomasyonu için.
  - **Cucumber:** BDD formatında test yazımı ve raporlama için.
  - **JUnit:** Test yönetimi ve organizasyonu için.
  - **Log4j:** Loglama mekanizması.
  - **Maven:** Bağımlılık yönetimi ve test çalıştırma için.
  - **Tasarım Deseni:** Page Object Model (POM) kullanıldı.

---
## Test Kapsamı ve Modüller
| Modül | Kapsam |
| -- | -- | 
| Kullanıcı girişi | Kullanıcı geçerli bilgilerle giriş yapabilir. | 
| Kullanıcı girişi | Kullanıcı geçersiz bilgilerle giriş Yapamaz. | 
| Para Transferi | Kullanıcı farklı bir hesaba para gönderebilir. | 
| Para Transferi Negatif Senaryo | Kullanıcı farklı bir hesaba negatif para gönderemez. | 
| Kart ile Para Yatırma | Kullanıcı, kart bilgilerini girerek hesabına para yatırabilir. | 
| Kart ile Para Yatırma  Negatif Senaryo| Kullanıcı, kart bilgilerini eksik girerek hesabına para yatıramaz. | 
| Hesap Bilgisi Güncelleme | Kullanıcı, hesap bilgilerini düzenleyebilir. | 
| Hesap Bilgisi Güncelleme Negatif Senaryo| Kullanıcı, hesap bilgilerini sistemde olması gerektiği gibi düzenleyebilir. | 
---
## 🚀 **Kurulum Talimatları**
### **1. Gerekli Araçlar ve Yazılımlar**
Projeyi çalıştırmak için aşağıdaki yazılımların bilgisayarınızda kurulu olduğundan emin olun:
- **Java JDK 11 veya üstü:** [Java İndirme](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
- **Apache Maven 3.6 veya üstü:** [Maven İndirme](https://maven.apache.org/download.cgi)
- **Git** (opsiyonel): Kodları klonlamak için.
- **IDE (IntelliJ IDEA, Eclipse vb.):** Projeyi düzenlemek ve çalıştırmak için.
- **Cucumber 7.15 veya üstü** [Cucumber](https://cucumber.io/)

### **2. Depoyu Klonlayın**
Projeyi klonlamak için aşağıdaki komutu kullanın:

```
git clone https://github.com/meskici172/CatchylabsBank
```
---
## 🎮 **Kullanım Yönergeleri**
### **Nasıl Test Çalıştırılır?**
Alternatif Çalıştırma Yöntemi
1. Proje dizinine gidin.
2. Proje dizininde src > test > java > runners > AllTestRunner methodunu açın (Modüllere ayrılmış şekilde Runnerlar Mevcut isteğe bağlı seçim yapılabilir.)
3. public class AllTestRunner yazının solunda yer alan icona tıklayın. Bu işlemi gerçekleştirdikten sonra 
4. Proje dizininde src > test > resources > feautures > modüllere ayrılmış BDD Frameworklerinden testi çalıştırabilirsiniz. 

Alternatif Çalıştırma Yöntemi 2
1. Proje dizinine gidin.
2. Maven kullanarak testleri çalıştırın

```
mvn test
```

### **Tag Kullanarak Testleri Çalıştırmak**
```
mvn test -Dcucumber.options="--tags @NegativeAmount"

```
---
## 📊 Test Raporları
3. Test süreçlerinin sonuçlarını ve detaylarını içeren raporlar otomatik olarak oluşturulmaktadır. Gauge raporlama aracı ile görsel ve detaylı bir formatta test sonuçları sunulur.

     * Raporların Görüntülenmesi:

         * Test sonuçları **target/cucumber-reports.html** dosyasına kaydedilir. Tarayıcıda bu dosyayı açarak başarı oranlarını ve hata detaylarını inceleyebilirsiniz.
     * Hata Logları:

        * Tüm test adımları ve hatalar **logs/application.log** dosyasında saklanır. Bu dosya, test sonuçlarının detaylı analizi için kullanılabilir.
---
## 📂 Proje Yapısı
```
cucumber-selenium-template/
├── logs/
│   └── application.log               # Log kayıtları
├── main/
│   └── java/
            └── com.maintemplate
│           └── utilities      # Test raporları
              └── DriverManager.java
├── test/
│   └── java/ 
      └── maintemplate
        └──AppTest.java
      └── hooks 
        └── Hooks.java
      └──methods
        └──enums
          └── LocatorType.java
        └── ClickHelper.java
          └── DriverHelper.java 
          └── functions.java 
          └── ReadHelper.java 
          └── WaitHelper.java 
          └── VisibleHelper.java 
          └── WriteHelper.java
      └──runners 
        └── add
           └── AddRunner.java
        └──edit
           └── EditRunner.java
        └──login
         └── LoginRunner.java
        └──transfer
         └── TransferRunner.java
        └── AllTestRunner.java

      └──stepDefinitions
        └── AddMoneySteps.java
        └── EditAccountNameSteps.java
        └── FailedLoginSteps.java
        └── SuccessLoginSteps.java
        └── TransferMoneySteps.java
│   └── resources/
      └── features
        └── add
          └── addMoneyScenarios.feature
        └── login
          └── failedLoginScenarios.feature
          └── successLoginAndLogoutScenarios.feature
        └── edit
          └── editAccountName.feature
        └── transfer
          └── transferScenarios.feature
      └── locators
        └── addMoneyLocators.json
        └── editLocators.json
        └── locators.json
        └── loginLocators.json
        └── mainLocators.json
        └── transferLocators.json
      └── values
        └── values.json
      └── logback.xml
├── pom.xml                     # Maven bağımlılıkları
└── README.md                   # README dosyası
```
---
## 🛠 **Sorun Giderme İpuçları**
**Kurulum ile İlgili Sorunlar**

1. **mvn komutu çalışmıyor:**

* Maven'in sistem PATH değişkenine eklendiğinden emin olun.
* Yükleme talimatlarını [buradan](https://maven.apache.org/install.html) kontrol edin.

2. **java komutu bulunamadı:**

* Java'nın kurulu olduğundan ve PATH değişkenine eklendiğinden emin olun.
* Java versiyonunuzu doğrulamak için:
```
java -version
```
3. **Raporlama Sorunları**
* Raporlar eksikse veya hatalı oluşturulmuşsa, rapor klasörünü temizleyin ve testleri yeniden çalıştırın:
```
mvn clean test
```
4. **Geliştirici Modunda Test Çalıştırma**
* Daha fazla detay görmek ve testlerin hata ayıklamasını yapmak için Maven debug modunu kullanabilirsiniz:
```
mvn test -X
```
---
## 🔗 Kaynaklar
Projenizi daha etkili bir şekilde geliştirmek ve yönetmek için aşağıdaki kaynakları kullanabilirsiniz:

- [Selenium Resmi Dokümantasyonu](https://www.selenium.dev/documentation/)
- [Cucumber Resmi Dokümantasyonu](https://cucumber.io/docs)
- [JUnit Resmi Dokümantasyonu](https://junit.org/junit5/docs/current/user-guide/)
- [Maven Kullanım Kılavuzu](https://maven.apache.org/guides/index.html)
---
## 📞 İletişim
Proje hakkında herhangi bir sorunuz varsa veya destek almak isterseniz iletişime geçebilirsiniz:

Hazırlayan: Mehmet Eskici

E-posta: mehmet.eskici@testinium.com

