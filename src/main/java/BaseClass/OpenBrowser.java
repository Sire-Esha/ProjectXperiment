package BaseClass;

import PropertiesFile.ReadPropertiesFile;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class OpenBrowser {
    public static WebDriver driver;
    public static void NavToWebsite(String url) throws IOException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--allow-insecure-localhost");
        //options.addArguments("--headless");
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");
        DesiredCapabilities caps = DesiredCapabilities.chrome();
        caps.setCapability(ChromeOptions.CAPABILITY, options);
        caps.setCapability("acceptInsecureCerts", caps);
        driver = new ChromeDriver(options);

        driver.get(ReadPropertiesFile.PropFile("url"));
        //driver.get(ReadPropertiesFile.PropFile("urlAccountScreen"));
        //driver.get(ReadPropertiesFile.PropFile("urlCreateanAccScreen"));
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    public static void CloseBrowser() throws IOException
    {
        driver.close();
        driver.quit();
    }
}
