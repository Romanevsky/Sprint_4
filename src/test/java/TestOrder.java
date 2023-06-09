import org.example.OrderObject.HeadPage;
import org.example.OrderObject.OrderPage;
import org.junit.After;
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

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class TestOrder {
    private WebDriver driver;
    private final String name;
    private final String lastName;
    private final String street;
    private final String telephone;
    private final String comment;

    public TestOrder(String name, String lastName, String street, String telephone, String comment){
        this.name = name;
        this.lastName = lastName;
        this.street = street;
        this.telephone = telephone;
        this.comment = comment;
    }
    @Parameterized.Parameters
    public static Object[][] testData(){
        return new Object[][] {
                {"Роман", "Владимиров", "Первая", "79999999999", "пав"},
                //{"Сергей", "Сергеев", "Тульская", "79130009988", "семь"},
               // {"Игорь", "Михалычев", "Улица-Сутулица", "78889990033", "парам-пам-пам"}
        };
    }
    @Before
    public void setUp() {
        System.setProperty("webdriver.firefox.driver","Users\\valiulin.r\\WebDriver\\bin");
        ChromeOptions options = new ChromeOptions();
        driver = new FirefoxDriver(options);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        HeadPage headPage = new HeadPage(driver);
        headPage.open();
        headPage.clickCookButton();
    }
    @Test
    public void orderTests(){
        HeadPage headPage = new HeadPage(driver);
        HeadPage.clickHeadOrderButton();
        OrderPage orderPage = new OrderPage(driver);
        orderPage.inputFirstOrderPage(name, lastName, street, telephone);
        assertEquals("Заказ оформлен",orderPage.inputSecondOrderPage(comment), orderPage.checkFinal());
    }
    @Test
    public void orderTestsTwo(){
        HeadPage headPage = new HeadPage(driver);
        HeadPage.scrollDownTwo();
        HeadPage.clickCentrOrderButton();
        OrderPage orderPage = new OrderPage(driver);
        orderPage.inputFirstOrderPage(name, lastName, street, telephone);
        assertEquals("Заказ оформлен",orderPage.inputThirdOrderPage(comment), orderPage.checkFinal());
    }
    @After
    public void theEnd() {
        driver.quit();
    }
}
