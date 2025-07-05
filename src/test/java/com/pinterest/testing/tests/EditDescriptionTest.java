package com.pinterest.testing.tests;

import com.pinterest.testing.BaseTest;
import com.pinterest.testing.pages.AccountPage;
import com.pinterest.testing.pages.HomePage;
import com.pinterest.testing.pages.LoginPage;
import org.junit.jupiter.api.Test;

/**
 * Тестовый класс для проверки функционала редактирования описания пина.
 */
public class EditDescriptionTest extends BaseTest {

    private static final String PROPERTY_EMAIL = "email";
    private static final String PROPERTY_PASSWORD = "password";
    private static final String PIN_DESCRIPTION = "Этот пин красивый!";

    /**
     * Метод тестирует процесс редактирования описания пина:
     * выбирает последний сохраненный пользователем пин,
     * редактирует его описание и сохраняет изменения.
     */
    @Test
    public void testEditDescription() {
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
        accountPage.chooseOtherActions();
        accountPage.chooseCorrectPin();
        accountPage.editDescription(PIN_DESCRIPTION);
        accountPage.saveDescription();
        assert accountPage.checkSavedDescriptionDescription(PIN_DESCRIPTION);
    }
}
