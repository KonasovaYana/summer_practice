package com.pinterest.testing.tests;

import com.pinterest.testing.BaseTest;
import com.pinterest.testing.pages.AccountPage;
import com.pinterest.testing.pages.HomePage;
import com.pinterest.testing.pages.LoginPage;
import org.junit.jupiter.api.Test;

/**
 * Тестовый класс для проверки функционала добавления пинов в избранное.
 * Содержит тест-кейсы, связанные с:
 * - Добавлением пина в избранное
 * - Проверкой отображения пина в разделе избранного
 * - Навигацией по разделам профиля
 */
public class FavoritePinTest extends BaseTest {

    private static final String PROPERTY_EMAIL = "email";
    private static final String PROPERTY_PASSWORD = "password";

    /**
     * Тестирует процесс добавления пина в избранное:
     * 1. Авторизация пользователя
     * 2. Переход в профиль
     * 3. Выбор доски с пинами
     * 4. Добавление пина в избранное
     * 5. Проверка успешности операции
     * 6. Переход в раздел избранного
     *
     * Шаги теста:
     * - Получение учетных данных из конфигурации
     * - Выполнение входа в систему
     * - Переход на страницу профиля
     * - Выбор раздела "Доски"
     * - Выбор первой доски
     * - Выбор первого пина на доске
     * - Добавление пина в избранное
     * - Проверка наличия пина в избранном
     * - Возврат в профиль
     * - Переход в раздел "Избранное"
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