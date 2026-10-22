package Framework;

import Framework.Browser.DriverManager;
import Framework.Browser.TypeBrowser;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

public class TesteBase extends DriverManager {

    private static WebDriver driver;
    // da para trocar na hora de rodar: mvn test -Durl=... -Dbrowser=HEADLESS
    private static String URL = System.getProperty("url", "https://bugbank.netlify.app/");
    private static TypeBrowser BROWSER = TypeBrowser.valueOf(System.getProperty("browser", "CHROME"));

    public static WebDriver getDriverManager (){

        driver = getDriver(BROWSER);
        return driver;

    }

    @BeforeEach
    public void setUp(){

        getDriverManager().get(URL);

    }

    @AfterEach
    public void finish(){

        fecharDriver();
    }

}
