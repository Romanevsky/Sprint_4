import ru.practicum.qascooter.HeadPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import ru.practicum.qascooter.HeadPage;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class TestText {
    private WebDriver driver;

    @Before
    public void setUpP() {
        System.setProperty("webdriver.firefox.driver", "Users\\valiulin.r\\WebDriver\\bin");
        ChromeOptions options = new ChromeOptions();
        this.driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        HeadPage headPage = new HeadPage(driver);
        headPage.open();
        headPage.clickCookButton();
        headPage.scrollDownOne();
    }

    @Test
    public void testText0() {
        String example0 = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
        HeadPage headPage;
        headPage = new HeadPage(driver);
        headPage.clickElement0();
        String actualText = headPage.getText0();
        assertEquals("Строки отличаются", example0, actualText);
    }

    @Test
    public void testText1() {
        String example1 = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
        HeadPage headPage = new HeadPage(driver);
        headPage.clickElement1();
        String actualText = headPage.getText1();
        assertEquals("Строки отличаются", example1, actualText);
    }

    @Test
    public void testText2() {
        String example2 = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
        HeadPage headPage = new HeadPage(driver);
        headPage.clickElement2();
        String actualText = headPage.getText2();
        assertEquals("Строки отличаются", example2, actualText);
    }

    @Test
    public void testText3() {
        String example3 = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
        HeadPage headPage = new HeadPage(driver);
        headPage.clickElement3();
        String actualText = headPage.getText3();
        assertEquals("Строки отличаются", example3, actualText);
    }

    @Test
    public void testText4() {
        String example4 = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
        HeadPage headPage = new HeadPage(driver);
        headPage.clickElement4();
        String actualText = headPage.getText4();
        assertEquals("Строки отличаются", example4, actualText);
    }

    @Test
    public void testText5() {
        String example5 = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
        HeadPage headPage = new HeadPage(driver);
        headPage.clickElement5();
        String actualText = headPage.getText5();
        assertEquals("Строки отличаются", example5, actualText);
    }

    @Test
    public void testText6() {
        String example6 = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
        HeadPage headPage = new HeadPage(driver);
        headPage.clickElement6();
        String actualText = headPage.getText6();
        assertEquals("Строки отличаются", example6, actualText);
    }

    @Test
    public void testText7() {
        String example7 = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";
        HeadPage headPage = new HeadPage(driver);
        headPage.clickElement7();
        String actualText = headPage.getText7();
        assertEquals("Строки отличаются", example7, actualText);
    }

    @After
    public void theEnd() {
        driver.quit();
    }
}
