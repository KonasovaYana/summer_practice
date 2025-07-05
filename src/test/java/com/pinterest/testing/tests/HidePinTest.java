package com.pinterest.testing.tests;

import com.pinterest.testing.BaseTest;
import com.pinterest.testing.pages.HomePage;
import org.junit.jupiter.api.Test;

/**
 * Тестовый класс для проверки функционала скрытия пинов.
 */
public class HidePinTest extends BaseTest {

    /**
     * Метод тестирует процесс скрытия пина:
     * выбирает первый пин в ленте, после чего
     * выбирает возможность скрыть пин и объясняет
     * причину скрытия пина.
     */
    @Test
    public void testHidePin() {
        HomePage home = loginService()
                .openLoginForm()
                .enterCredentials(getProperty(PROPERTY_EMAIL),getProperty(PROPERTY_PASSWORD))
                .submitLogin();
        home.openFirstPin();
        home.chooseOtherActions();
        home.makePinHidden();
        home.reasonPinHidden();
        assert home.checkHidden();
    }
}