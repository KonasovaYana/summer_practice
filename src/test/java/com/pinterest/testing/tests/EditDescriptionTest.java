package com.pinterest.testing.tests;

import com.pinterest.testing.BaseTest;
import com.pinterest.testing.pages.AccountPage;
import com.pinterest.testing.pages.HomePage;
import com.pinterest.testing.pages.LoginPage;
import org.junit.jupiter.api.Test;

/**
 * Тестовый класс для проверки функционала редактирования описания пина.
 * Содержит тест-кейсы, связанные с:
 * - Изменением описания пина
 * - Сохранением изменений
 * - Проверкой обновленного описания
 */
public class EditDescriptionTest extends BaseTest {

    private static final String PROPERTY_EMAIL = "email";
    private static final String PROPERTY_PASSWORD = "password";
    private static final String PIN_DESCRIPTION = "Этот пин красивый!";

    /**
     * Тестирует процесс редактирования описания пина:
     * 1. Авторизация пользователя
     * 2. Переход в раздел "Созданные мной"
     * 3. Выбор пина для редактирования
     * 4. Изменение описания пина
     * 5. Сохранение изменений
     * 6. Проверка обновленного описания
     *
     * Шаги теста:
     * - Получение учетных данных из properties-файла
     * - Выполнение авторизации
     * - Переход на страницу аккаунта
     * - Выбор раздела "Пины" -> "Созданные мной"
     * - Выбор конкретного пина
     * - Открытие меню редактирования
     * - Ввод нового описания
     * - Сохранение изменений
     * - Проверка отображения нового описания
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
