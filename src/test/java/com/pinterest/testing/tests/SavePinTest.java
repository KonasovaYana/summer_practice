package com.pinterest.testing.tests;

import com.pinterest.testing.BaseTest;
import com.pinterest.testing.pages.AccountPage;
import com.pinterest.testing.pages.HomePage;
import com.pinterest.testing.pages.LoginPage;
import org.junit.jupiter.api.Test;

/**
 * Тестовый класс для проверки функционала сохранения пинов в Pinterest.
 * Содержит тест-кейсы, связанные с сохранением пинов на доски,
 * включая создание новой доски в процессе сохранения пина.
 */
public class SavePinTest extends BaseTest {

    private static final String PROPERTY_EMAIL = "email";
    private static final String PROPERTY_PASSWORD = "password";
    private static final String BOARD_NAME = "Тестовая доска";

    /**
     * Тестирует полный процесс сохранения пина, включая:
     * 1. Авторизацию пользователя
     * 2. Открытие пина из ленты
     * 3. Создание новой доски
     * 4. Сохранение пина на новую доску
     * 5. Проверку успешного сохранения пина
     *
     * Шаги теста:
     * - Выполняет вход с использованием учетных данных из properties-файла
     * - Открывает первый пин в домашней ленте
     * - Создает новую доску с заданным названием
     * - Сохраняет пин на созданную доску
     * - Проверяет, что пин был успешно сохранен
     */
    @Test
    public void testSavePin() {
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
        assert home.checkSavedPin();
    }
}