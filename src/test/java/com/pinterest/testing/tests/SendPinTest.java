package com.pinterest.testing.tests;

import com.pinterest.testing.BaseTest;
import com.pinterest.testing.pages.HomePage;
import org.junit.jupiter.api.Test;

/**
 * Тестовый класс для проверки функционала отправки пина другому пользователю.
 */
public class SendPinTest extends BaseTest {

    private static final String USER_PASSWORD = "axalzev";

    /**
     * Метод тестирует процесс отправки пина другому пользователю:
     * выбирает первый пин в ленте, после чего выбирает
     * "Общий доступ", вводит имя пользователя для отправки и
     * ждет отправки изображения.
     */
    @Test
    public void testSendPin() {
        HomePage home = loginService()
                .openLoginForm()
                .enterCredentials(getProperty(PROPERTY_EMAIL),getProperty(PROPERTY_PASSWORD))
                .submitLogin();
        home.openFirstPin();
        home.sharedAccess();
        home.writeUserName(USER_PASSWORD);
        home.sendPin();
        assert home.checkMessage();
    }
}