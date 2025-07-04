package com.pinterest.testing.tests;

import com.pinterest.testing.BaseTest;
import com.pinterest.testing.pages.AccountPage;
import com.pinterest.testing.pages.HomePage;
import com.pinterest.testing.pages.LoginPage;
import org.junit.jupiter.api.Test;

/**
 * Тестовый класс для проверки функционала перемещения пинов между досками в Pinterest.
 * Содержит тест-кейсы, связанные с:
 * - Созданием новой доски
 * - Перемещением пина между досками
 * - Удалением пина с доски
 */
public class MovingPinBetweenBoardsTest extends BaseTest {

    private static final String PROPERTY_EMAIL = "email";
    private static final String PROPERTY_PASSWORD = "password";
    private static final String BOARD_NAME = "Вторая доска";

    /**
     * Тестирует полный процесс перемещения пина между досками:
     * 1. Авторизация пользователя
     * 2. Создание новой доски
     * 3. Сохранение пина на новую доску
     * 4. Перемещение пина на другую доску
     * 5. Удаление пина с доски
     *
     * Шаги теста:
     * - Авторизация с использованием учетных данных
     * - Открытие первого пина в ленте
     * - Создание новой доски с заданным именем
     * - Переход в выбор доски
     * - Выбор доски и первого пина на ней
     * - Сохранение пина на другую доску
     * - Проверка успешного сохранения
     * - Редактирование и удаление пина
     * - Проверка подтверждения удаления
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