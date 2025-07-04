package com.pinterest.testing.tests;

import com.pinterest.testing.BaseTest;
import com.pinterest.testing.pages.HomePage;
import com.pinterest.testing.pages.LoginPage;
import org.junit.jupiter.api.Test;

/**
 * Тестовый класс для проверки функционала отправки пина другому пользователю.
 * Содержит тест-кейсы, связанные с:
 * - Отправкой пина через систему обмена сообщениями
 * - Проверкой успешности отправки
 * - Открытием чата с получателем
 */
public class SendPinTest extends BaseTest {

    private static final String PROPERTY_EMAIL = "email";
    private static final String PROPERTY_PASSWORD = "password";
    private static final String USER_PASSWORD = "axalzev";

    /**
     * Тестирует процесс отправки пина другому пользователю:
     * 1. Авторизация в системе
     * 2. Открытие пина из ленты
     * 3. Отправка пина указанному пользователю
     * 4. Проверка успешности отправки
     * 5. Открытие чата с получателем
     *
     * Шаги теста:
     * - Получение учетных данных из конфигурации
     * - Выполнение входа в систему
     * - Открытие первого пина в ленте
     * - Вызов меню отправки
     * - Ввод имени получателя
     * - Подтверждение отправки
     * - Проверка подтверждения отправки
     * - Открытие чата с получателем
     */
    @Test
    public void testSendPin() {
        String email = getProperty(PROPERTY_EMAIL);
        String password = getProperty(PROPERTY_PASSWORD);
        LoginPage loginPage = new LoginPage();
        loginPage.clickEnterButton();
        loginPage.enterEmailField(email);
        loginPage.enterPasswordField(password);
        loginPage.clickLoginButton();
        HomePage home = new HomePage();
        home.openFirstPin();
        home.sharedAccess();
        home.writeUserName(USER_PASSWORD);
        home.sendPin();
        assert home.checkMessage();
        home.openChat();
    }
}