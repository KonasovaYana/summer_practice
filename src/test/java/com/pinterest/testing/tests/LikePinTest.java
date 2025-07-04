package com.pinterest.testing.tests;

import com.pinterest.testing.BaseTest;
import com.pinterest.testing.pages.AccountPage;
import com.pinterest.testing.pages.HomePage;
import com.pinterest.testing.pages.LoginPage;
import org.junit.jupiter.api.Test;

/**
 * Тестовый класс для проверки функционала добавления пинов в "Мне нравится".
 * Содержит тест-кейсы, связанные с:
 * - Отметкой пина как понравившегося
 * - Проверкой состояния лайка
 */
public class LikePinTest extends BaseTest {

    private static final String PROPERTY_EMAIL = "email";
    private static final String PROPERTY_PASSWORD = "password";

    /**
     * Тестирует процесс отметки пина как понравившегося:
     * 1. Авторизация в системе
     * 2. Переход в профиль пользователя
     * 3. Выбор раздела "Созданные мной"
     * 4. Отметка пина как понравившегося
     * 5. Проверка успешности операции
     *
     * Шаги теста:
     * - Получение учетных данных из конфигурации
     * - Выполнение входа в систему
     * - Переход на страницу профиля
     * - Фильтрация пинов по "Созданные мной"
     * - Выбор конкретного пина
     * - Нажатие кнопки "Мне нравится"
     * - Проверка состояния лайка
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
        accountPage.choosePins();
        accountPage.chooseMadeByMe();
        accountPage.choosePin();
        accountPage.chooseLikePin();
        assert accountPage.checkLikePin();
    }
}