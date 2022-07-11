import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    private final static String username = "*****";
    private final static String password = "*****";
    static WebDriver driver = setupDriver();
    static JavascriptExecutor jse = (JavascriptExecutor) driver;
    private static final int[] idArray = {181, 179, 133, 134, 135, 136, 137, 138, 139, 140, 141, 142, 143, 144, 145,
            146, 147, 148
            , 149, 150, 172, 187,
            184, 174};

    public static void main(String[] args) throws InterruptedException {


        driver.get("https://ugvle.ucsc.cmb.ac.lk/my");
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("loginbtn")).click();

        driver.findElement(By.xpath("//a[@href='https://ugvle.ucsc.cmb.ac.lk/course/view.php?id=181']")).click();


        for (int id : idArray) {
            driver.findElement(By.xpath("//a[@href='https://ugvle.ucsc.cmb.ac.lk/course/view.php?id=" + id + "']")).click();
            Long scrollableHeight = (Long) jse.executeScript("return document.body.scrollHeight");
            jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
            Thread.sleep(5000);
            driver.navigate().back();
            Thread.sleep(5000);
        }

        driver.quit();
    }

    //Setup an initiate the driver
    private static WebDriver setupDriver() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }

//    private static void scrollToBottom(WebDriver driver , Long scrollableHeight) throws InterruptedException {
//        Long unitLength = scrollableHeight/50;
//        for (int i = 0; i <= scrollableHeight; i+= unitLength.byteValue()) {
//            jse.executeScript("window.scrollTo(0, "+i+")");
//        }
//        Thread.sleep(400);
//    }
}
