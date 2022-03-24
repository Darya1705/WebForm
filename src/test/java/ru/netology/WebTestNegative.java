package ru.netology;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertEquals;

    public class WebTestNegative {

        private WebDriver driver;

        @BeforeAll
        public static void setUpAll() {
            WebDriverManager.chromedriver().setup();
        }

        @BeforeEach
        public void setDriver() {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--no-sandbox");
            options.addArguments("--headless");
            driver = new ChromeDriver(options);
        }

        @AfterEach
        public void tearDown() {
            driver.quit();
        }

        @Test
        public void shouldSendFormNegativeName() {
            driver.get("http://localhost:9999");
            driver.findElement(By.cssSelector("[data-test-id='name'] input")).sendKeys("Ivanov Ivan");
            driver.findElement(By.cssSelector("[data-test-id='phone'] input")).sendKeys("+79000000000");
            driver.findElement(By.cssSelector("[data-test-id=agreement]")).click();
            driver.findElement(By.cssSelector("button")).click();
            //String actual = driver.findElement(By.className("input_sub")).getText().trim();
            //String expected = "Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы.";
            assertEquals("Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы.", driver.findElement(By.cssSelector(".input_invalid[data-test" +
                    "-id=name] .input__sub")).getText().trim());
        }

        @Test
        public void shouldSendFormNegativeTel() {
            driver.get("http://localhost:9999");
            driver.findElement(By.cssSelector("[data-test-id='name'] input")).sendKeys("Иванов Иван");
            //driver.findElement(By.cssSelector("[data-test-id='phone'] input")).sendKeys("+79000000000");
            driver.findElement(By.cssSelector("[data-test-id=agreement]")).click();
            driver.findElement(By.cssSelector("button")).click();
            //String actual = driver.findElement(By.className("input_sub")).getText().trim();
            //String expected = "Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы.";
            assertEquals("Поле обязательно для заполнения", driver.findElement(By.cssSelector(".input_invalid[data-test" +
                    "-id=phone] .input__sub")).getText().trim());
        }
        @Test
        public void shouldSendFormNegativeName1() {
            driver.get("http://localhost:9999");
            //driver.findElement(By.cssSelector("[data-test-id='name'] input")).sendKeys("Иванов Иван");
            driver.findElement(By.cssSelector("[data-test-id='phone'] input")).sendKeys("+79000000000");
            driver.findElement(By.cssSelector("[data-test-id=agreement]")).click();
            driver.findElement(By.cssSelector("button")).click();
            //String actual = driver.findElement(By.className("input_sub")).getText().trim();
            //String expected = "Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы.";
            assertEquals("Поле обязательно для заполнения", driver.findElement(By.cssSelector(".input_invalid[data-test" +
                    "-id=name] .input__sub")).getText().trim());
        }

        @Test
        public void shouldSendFormNegativeTel2() {
            driver.get("http://localhost:9999");
            driver.findElement(By.cssSelector("[data-test-id='name'] input")).sendKeys("Иванов Иван");
            driver.findElement(By.cssSelector("[data-test-id='phone'] input")).sendKeys("+790000000--");
            driver.findElement(By.cssSelector("[data-test-id=agreement]")).click();
            driver.findElement(By.cssSelector("button")).click();
            //String actual = driver.findElement(By.className("input_sub")).getText().trim();
            //String expected = "Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы.";
            assertEquals("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678.", driver.findElement(By.cssSelector(".input_invalid[data-test" +
                    "-id=phone] .input__sub")).getText().trim());
        }
}
























