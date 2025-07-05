package com.pinterest.testing;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.codeborne.selenide.Selenide.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Базовый класс для всех тестовых классов.
 * Предоставляет общую конфигурацию браузера и методы для работы с тестами.
 * Содержит:
 * - Настройки браузера перед каждым тестом
 * - Методы закрытия браузера после теста
 * - Вспомогательные методы для работы с properties-файлами
 */
public class BaseTest {
    /**
     * Метод выполняемый перед каждым тестом.
     * Настраивает и открывает браузер с заданными параметрами:
     * - Устанавливает размер окна браузера
     * - Открывает стартовую страницу Pinterest
     */
    @BeforeEach
    public void openBrowser() {
        Configuration.browserSize = "1920x1080";
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("profile.default_content_setting_values.notifications", 2);
        options.setExperimentalOption("prefs", prefs);
        Configuration.browserCapabilities = options;
        open("https://www.pinterest.com/");
    }

    /**
     * Метод выполняемый после каждого теста.
     * Закрывает браузер и освобождает ресурсы.
     */
    @AfterEach
    public void closeBrowser() {
        closeWebDriver();
    }

    /**
     * Получает значение свойства из файла account.properties.
     *
     * @param key ключ свойства для получения
     * @return значение свойства
     * @throws RuntimeException если файл не найден или произошла ошибка чтения
     */
    protected String getProperty(String key) {
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("account.properties")) {
            Properties props = new Properties();
            if (input == null) {
                throw new RuntimeException("account.properties not found");
            }
            props.load(input);
            return props.getProperty(key);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load account properties", e);
        }
    }
}