import ru.practicum.qascooter.HeadPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.concurrent.TimeUnit;

@RunWith(Parameterized.class)
public class TestLogoAndPage {
    private WebDriver driver;
    private final String numberOrder;

    public TestLogoAndPage(String numberOrder) {
        this.numberOrder = numberOrder;
    }

    @Parameterized.Parameters(name = "Номер страницы. Тестовые данные: {0}")
    public static Object[][] testDataS() {
        return new Object[][]{
                {"4543"},
                {"gfsgf"}
        };
    }

    @Before
    public void setUpPs() {
        System.setProperty("webdriver.firefox.driver", "Users\\valiulin.r\\WebDriver\\bin");
        ChromeOptions options = new ChromeOptions();
        this.driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        HeadPage headPage = new HeadPage(driver);
        headPage.open();
        headPage.clickCookButton();
    }

    @Test
    public void scooterTestNotFound() {
        HeadPage headPage = new HeadPage(driver);
        headPage.clickOrderStatusButton();
        headPage.setNotFound(numberOrder);
        headPage.clickGo();
        String expectedTitle = "undefined";
        String url = "https://qa-scooter.praktikum-services.ru/track?t=4543";
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        Assert.assertEquals("Error page", expectedTitle, driver.getTitle());
    }
    @Test
    public void yandexTest() {
        HeadPage headPage = new HeadPage(driver);
        headPage.setYandexLogo();
        String expectedTitle = "Дзен";
        String url = "https://dzen.ru/?yredirect=true";
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        Assert.assertEquals("Error page", expectedTitle, driver.getTitle());
    }

    @Test
    public void scooterPageTest() {
        HeadPage headPage = new HeadPage(driver);
        HeadPage.clickHeadOrderButton();
        headPage.clickScooterLogo();
        String expectedTitle = "undefined";
        String url = "https://qa-scooter.praktikum-services.ru/";
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        Assert.assertEquals("Error page", expectedTitle, driver.getTitle());
    }

    @After
    public void theEnd() {
        driver.quit();
    }
}