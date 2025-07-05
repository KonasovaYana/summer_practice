package com.pinterest.testing.tests;

import com.pinterest.testing.BaseTest;
import com.pinterest.testing.pages.AccountPage;
import com.pinterest.testing.pages.HomePage;
import com.pinterest.testing.pages.LoginPage;
import org.junit.jupiter.api.Test;

/**
 * Тестовый класс для проверки функционала добавления пинов в "Мне нравится".
 */
public class LikePinTest extends BaseTest {

    private static final String PROPERTY_EMAIL = "email";
    private static final String PROPERTY_PASSWORD = "password";

    /**
     * Метод тестирует процесс отметки пина как понравившегося:
     * выбирает последний сохраненный пользователем пин, ставит
     * отметку "нравится".
     */
    @Test
    public void testLikePin() {
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
        accountPage.choosePins();
        accountPage.chooseMadeByMe();
        accountPage.choosePin();
        accountPage.chooseLikePin();
        assert accountPage.checkLikePin();
    }
}