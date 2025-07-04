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

public class BaseTest {
    @BeforeEach
    public void openBrowser() {
        Configuration.browserSize = "1920x1080";
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("profile.default_content_setting_values.notifications", 2); // блокировка уведомлений
        options.setExperimentalOption("prefs", prefs);
        Configuration.browserCapabilities = options;
        open("https://www.pinterest.com/");
    }
    @AfterEach
    public void closeBrowser() {
        closeWebDriver();
    }

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