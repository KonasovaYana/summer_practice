package com.pinterest.testing.tests;

import com.pinterest.testing.BaseTest;
import com.pinterest.testing.pages.AccountPage;
import com.pinterest.testing.pages.HomePage;
import com.pinterest.testing.pages.LoginPage;
import org.junit.jupiter.api.Test;

/**
 * Тестовый класс для проверки функционала добавления пинов в избранное.
 */
public class FavoritePinTest extends BaseTest {

    private static final String PROPERTY_EMAIL = "email";
    private static final String PROPERTY_PASSWORD = "password";

    /**
     * Метод тестирует процесс добавления пина в избранное:
     * выбирает первую доску пользователя и первый пин в ней,
     * далее добавляет этот пин в избранное.
     */
    @Test
    public void testFavoritePin() {
        String email = getProperty(PROPERTY_EMAIL);
        String password = getProperty(PROPERTY_PASSWORD);
        LoginPage loginPage = new LoginPage();
        loginPage.clickEnterButton();
        loginPage.enterEmailField(email);
        loginPage.enterPasswordField(password);
        loginPage.clickLoginButton();
        HomePage home = new HomePage();
        home.openAccountPage();
        AccountPage accountPage = new AccountPage();
        accountPage.chooseBoards();
        accountPage.chooseFirstBoards();
        accountPage.chooseFirstPinBoards();
        accountPage.makePinFavourite();
        assert accountPage.checkFavourites();
        home.openAccountPage();
        accountPage.choosePins();
        accountPage.chooseFavourites();
    }
}