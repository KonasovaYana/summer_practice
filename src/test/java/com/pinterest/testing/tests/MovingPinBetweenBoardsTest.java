package com.pinterest.testing.tests;

import com.pinterest.testing.BaseTest;
import com.pinterest.testing.pages.AccountPage;
import com.pinterest.testing.pages.HomePage;
import com.pinterest.testing.pages.LoginPage;
import org.junit.jupiter.api.Test;

/**
 * Тестовый класс для проверки функционала перемещения пинов между досками в Pinterest.
 */
public class MovingPinBetweenBoardsTest extends BaseTest {

    private static final String PROPERTY_EMAIL = "email";
    private static final String PROPERTY_PASSWORD = "password";
    private static final String BOARD_NAME = "Вторая доска";

    /**
     * Метод тестирует полный процесс перемещения пина между досками:
     * добавляет первый пин в ленте во вторую доску,
     * одновременно ее создавая, далее добавляет этот
     * пин в первую доску, а из второй удаляет.
     */
    @Test
    public void testMovingPinBetweenBoards() {
        String email = getProperty(PROPERTY_EMAIL );
        String password = getProperty(PROPERTY_PASSWORD);
        LoginPage loginPage = new LoginPage();
        loginPage.clickEnterButton();
        loginPage.enterEmailField(email);
        loginPage.enterPasswordField(password);
        loginPage.clickLoginButton();
        HomePage home = new HomePage();
        home.openFirstPin();
        home.profile();
        home.createBoard();
        home.enterBoardName(BOARD_NAME);
        home.addBoard();
        home.openAccountPage();
        AccountPage accountPage = new AccountPage();
        accountPage.chooseBoard();
        accountPage.chooseFirstPinOnBoard();
        accountPage.profile();
        accountPage.chooseFirstBoard();
        assert accountPage.checkSavedPin();
        accountPage.chooseEdit();
        accountPage.chooseBoardEdit();
        accountPage.chooseDelete();
        accountPage.chooseDelete();
        assert accountPage.checkConfirmDeletePin();
    }
}