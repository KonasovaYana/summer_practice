package com.pinterest.testing.tests;

import com.pinterest.testing.BaseTest;
import com.pinterest.testing.pages.HomePage;
import org.junit.jupiter.api.Test;

/**
 * Тестовый класс для проверки функционала поиска пинов.
 */
public class SearchPinTest extends BaseTest {

    private static final String PIN_QUERY = "flowers";

    /**
     * Метод тестирует процесс поиска пинов:
     * на главной страницы выбирает поле "поиск",
     * вводит необходимую категроию, после чего
     * нажимает Enter.
     */
    @Test
    public void testSearchPin() {
        HomePage home = loginService()
                .openLoginForm()
                .enterCredentials(getProperty(PROPERTY_EMAIL),getProperty(PROPERTY_PASSWORD))
                .submitLogin();
        home.writeQuery(PIN_QUERY);
        home.searchPins();
        home.openHomePage();
        home.openSearch();
        assert home.checkSearchHistory();
    }
}