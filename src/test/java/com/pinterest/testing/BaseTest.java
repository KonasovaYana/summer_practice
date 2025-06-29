package com.pinterest.testing;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import static com.codeborne.selenide.Selenide.*;

public class BaseTest {
    @BeforeEach
    public void openBrowser() {
        Configuration.browserSize = "1920x1080";
        open("https://www.pinterest.com/");
    }
    @AfterEach
    public void closeBrowser() {
        closeWebDriver();
    }
}