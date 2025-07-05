package com.pinterest.testing.tests;

import com.pinterest.testing.BaseTest;
import com.pinterest.testing.pages.HomePage;
import com.pinterest.testing.pages.LoginPage;
import org.junit.jupiter.api.Test;

/**
 * Тестовый класс для проверки функционала поиска пинов.
 * Содержит тест-кейсы, связанные с:
 * - Поиском пинов по ключевым словам
 * - Проверкой работы поисковой системы
 */
public class SearchPinTest extends BaseTest {

    private static final String PROPERTY_EMAIL = "email";
    private static final String PROPERTY_PASSWORD = "password";
    private static final String PIN_QUERY = "flowers";

    /**
     * Тестирует процесс поиска пинов:
     * 1. Авторизация в системе
     * 2. Ввод поискового запроса
     * 3. Выполнение поиска
     *
     * Шаги теста:
     * - Получение учетных данных из конфигурации
     * - Выполнение входа в систему
     * - Ввод поискового запроса в строку поиска
     * - Запуск поиска
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
        home.openHomePage();
        home.openSearch();
        assert home.checkSearchHistory();
    }
}