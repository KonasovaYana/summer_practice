package com.pinterest.testing.tests;

import com.pinterest.testing.BaseTest;
import com.pinterest.testing.pages.HomePage;
import com.pinterest.testing.pages.LoginPage;
import org.junit.jupiter.api.Test;

/**
 * Тестовый класс для проверки функционала поиска пинов.
 */
public class SearchPinTest extends BaseTest {

    private static final String PROPERTY_EMAIL = "email";
    private static final String PROPERTY_PASSWORD = "password";
    private static final String PIN_QUERY = "flowers";

    /**
     * Метод тестирует процесс поиска пинов:
     * на главной страницы выбирает поле "поиск",
     * вводит необходимую категроию, после чего
     * нажимает Enter.
     */
    @Test
    public void testSearchPin() {
        String email = getProperty(PROPERTY_EMAIL);
        String password = getProperty(PROPERTY_PASSWORD);
        LoginPage loginPage = new LoginPage();
        loginPage.clickEnterButton();
        loginPage.enterEmailField(email);
        loginPage.enterPasswordField(password);
        loginPage.clickLoginButton();
        HomePage home = new HomePage();
        home.writeQuery(PIN_QUERY);
        home.searchPins();
    }
}