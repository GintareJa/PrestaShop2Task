import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseTest {

        protected WebDriver driver;
        protected WebDriverWait wait;

        @BeforeEach
        public void setUp() {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            driver.get("http://192.168.88.64/");
        }}
//
//        @AfterEach
//        public void tearDown() {
//                driver.quit();
//            }
//

