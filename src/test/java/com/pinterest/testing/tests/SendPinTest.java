package com.pinterest.testing.tests;

import com.pinterest.testing.BaseTest;
import com.pinterest.testing.pages.HomePage;
import com.pinterest.testing.pages.LoginPage;
import org.junit.jupiter.api.Test;

/**
 * Тестовый класс для проверки функционала отправки пина другому пользователю.
 */
public class SendPinTest extends BaseTest {

    private static final String PROPERTY_EMAIL = "email";
    private static final String PROPERTY_PASSWORD = "password";
    private static final String USER_PASSWORD = "axalzev";

    /**
     * Метод тестирует процесс отправки пина другому пользователю:
     * выбирает первый пин в ленте, после чего выбирает
     * "Общий доступ", вводит имя пользователя для отправки и
     * ждет отправки изображения.
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