package com.pinterest.testing.tests;

import com.pinterest.testing.BaseTest;
import com.pinterest.testing.pages.AccountPage;
import com.pinterest.testing.pages.HomePage;
import org.junit.jupiter.api.Test;

/**
 * Тестовый класс для проверки функционала добавления пинов в избранное.
 */
public class FavoritePinTest extends BaseTest {

    /**
     * Метод тестирует процесс добавления пина в избранное:
     * выбирает первую доску пользователя и первый пин в ней,
     * далее добавляет этот пин в избранное.
     */
    @Test
    public void testFavoritePin() {
        HomePage home = loginService()
                .openLoginForm()
                .enterCredentials(getProperty(PROPERTY_EMAIL),getProperty(PROPERTY_PASSWORD))
                .submitLogin();
        AccountPage accountPage = home.openAccountPage();
        accountPage.chooseBoards();
        accountPage.chooseFirstBoards();
        accountPage.chooseFirstPinBoards();
        accountPage.makePinFavourite();
        assert accountPage.checkFavourites();
    }
}