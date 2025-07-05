package com.pinterest.testing.tests;

import com.pinterest.testing.BaseTest;
import com.pinterest.testing.pages.HomePage;
import org.junit.jupiter.api.Test;

/**
 * Тестовый класс для проверки функционала сохранения пинов в Pinterest.
 */
public class SavePinTest extends BaseTest {

    private static final String BOARD_NAME = "Первая доска";

    /**
     * Метод тестирует полный процесс сохранения пиная:
     * выбирает первый пин в ленте, сохраняет его в первую доску,
     * параллельно создавая ее.
     */
    @Test
    public void testSavePin() {
        HomePage home = loginService()
                .openLoginForm()
                .enterCredentials(getProperty(PROPERTY_EMAIL),getProperty(PROPERTY_PASSWORD))
                .submitLogin();
        home.openFirstPin();
        home.profile();
        home.createBoard();
        home.enterBoardName(BOARD_NAME);
        home.addBoard();
        assert home.checkSavedPin();
    }
}