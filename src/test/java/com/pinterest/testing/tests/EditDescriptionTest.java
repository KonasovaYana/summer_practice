package com.pinterest.testing.tests;

import com.pinterest.testing.BaseTest;
import com.pinterest.testing.pages.AccountPage;
import com.pinterest.testing.pages.HomePage;
import org.junit.jupiter.api.Test;

/**
 * Тестовый класс для проверки функционала редактирования описания пина.
 */
public class EditDescriptionTest extends BaseTest {

    private static final String PIN_DESCRIPTION = "Этот пин красивый!";

    /**
     * Метод тестирует процесс редактирования описания пина:
     * выбирает последний сохраненный пользователем пин,
     * редактирует его описание и сохраняет изменения.
     */
    @Test
    public void testEditDescription() {
        HomePage home = loginService()
                .openLoginForm()
                .enterCredentials(getProperty(PROPERTY_EMAIL),getProperty(PROPERTY_PASSWORD))
                .submitLogin();
        AccountPage accountPage = home.openAccountPage();
        accountService(home)
                .navigateToCreatedPins()
                .selectPin();
        accountPage.chooseOtherActions();
        accountPage.chooseCorrectPin();
        accountPage.editDescription(PIN_DESCRIPTION);
        accountPage.saveDescription();
        assert accountPage.checkSavedDescriptionDescription(PIN_DESCRIPTION);
    }
}
