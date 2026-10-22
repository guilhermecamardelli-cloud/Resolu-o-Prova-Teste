package Framework.Browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class DriverManager {

    private static WebDriver driver;

    private static WebDriver getManagerDrive(TypeBrowser type){

        switch (type){

            case CHROME:
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--start-maximized");
                options.addArguments("--incognito");
                options.setExperimentalOption("prefs", prefsSemAvisoDeSenha());
                driver =  new ChromeDriver(options);
                break;

            case EDGE:
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--start-maximized");
                edgeOptions.addArguments("--incognito");
                driver =  new EdgeDriver(edgeOptions);
                break;

            case FIREFORX:
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;



            case HEADLESS:
                WebDriverManager.chromedriver().setup();
                ChromeOptions headlessOptions = new ChromeOptions();
                headlessOptions.addArguments("--headless=new");
                headlessOptions.addArguments("--window-size=1366,768");
                headlessOptions.setExperimentalOption("prefs", prefsSemAvisoDeSenha());
                driver =  new ChromeDriver(headlessOptions);
                break;



        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    return driver;
    }

    // o Chrome pode mostrar avisos de senha ao logar e esses avisos bloqueiam os cliques
    private static Map<String, Object> prefsSemAvisoDeSenha(){

        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        prefs.put("profile.password_manager_leak_detection", false);
        return prefs;
    }

    public static WebDriver getDriver(TypeBrowser type){

        if (driver == null){
            driver = getManagerDrive(type);

        }
        return driver;
    }

    public static void fecharDriver(){

        if (driver !=null){
            driver.quit();
            driver = null;

        }
    }

}
