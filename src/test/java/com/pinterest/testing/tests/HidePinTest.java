package com.pinterest.testing.tests;

import com.pinterest.testing.BaseTest;
import com.pinterest.testing.pages.HomePage;
import com.pinterest.testing.pages.LoginPage;
import org.junit.jupiter.api.Test;

/**
 * Тестовый класс для проверки функционала скрытия пинов.
 * Содержит тест-кейсы, связанные с:
 * - Скрытием пина из ленты
 * - Указанием причины скрытия
 * - Проверкой успешности операции скрытия
 */
public class HidePinTest extends BaseTest {

    private static final String PROPERTY_EMAIL = "email";
    private static final String PROPERTY_PASSWORD = "password";

    /**
     * Тестирует процесс скрытия пина:
     * 1. Авторизация пользователя
     * 2. Открытие пина из ленты
     * 3. Вызов меню дополнительных действий
     * 4. Выбор опции скрытия пина
     * 5. Указание причины скрытия
     * 6. Проверка успешности операции
     *
     * Шаги теста:
     * - Получение учетных данных из конфигурации
     * - Выполнение входа в систему
     * - Открытие первого пина в ленте
     * - Открытие меню дополнительных действий
     * - Выбор пункта "Скрыть пин"
     * - Выбор причины скрытия ("Другое")
     * - Проверка подтверждения скрытия
     */
    @Test
    public void testHidePin() {
        String email = getProperty(PROPERTY_EMAIL);
        String password = getProperty(PROPERTY_PASSWORD);
        LoginPage loginPage = new LoginPage();
        loginPage.clickEnterButton();
        loginPage.enterEmailField(email);
        loginPage.enterPasswordField(password);
        loginPage.clickLoginButton();
        HomePage home = new HomePage();
        home.openFirstPin();
        home.chooseOtherActions();
        home.makePinHidden();
        home.reasonPinHidden();
        assert home.checkHidden();
    }
}