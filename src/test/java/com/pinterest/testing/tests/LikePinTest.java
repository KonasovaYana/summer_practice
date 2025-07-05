package com.pinterest.testing.tests;

import com.pinterest.testing.BaseTest;
import com.pinterest.testing.pages.AccountPage;
import com.pinterest.testing.pages.HomePage;
import org.junit.jupiter.api.Test;

/**
 * Тестовый класс для проверки функционала добавления пинов в "Мне нравится".
 */
public class LikePinTest extends BaseTest {

    /**
     * Метод тестирует процесс отметки пина как понравившегося:
     * выбирает последний сохраненный пользователем пин, ставит
     * отметку "нравится".
     */
    @Test
    public void testLikePin() {
        HomePage home = loginService()
                .openLoginForm()
                .enterCredentials(getProperty(PROPERTY_EMAIL),getProperty(PROPERTY_PASSWORD))
                .submitLogin();
        AccountPage accountPage = home.openAccountPage();
        accountService(home)
                .navigateToCreatedPins()
                .selectPin();
        accountPage.chooseLikePin();
        assert accountPage.checkLikePin();
    }
}