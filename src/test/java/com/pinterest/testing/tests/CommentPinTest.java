package com.pinterest.testing.tests;

import com.pinterest.testing.BaseTest;
import com.pinterest.testing.pages.AccountPage;
import com.pinterest.testing.pages.HomePage;
import com.pinterest.testing.pages.LoginPage;
import org.junit.jupiter.api.Test;

/**
 * Тестовый класс для проверки функционала комментирования пинов.
 * Содержит тест-кейсы, связанные с:
 * - Добавлением текстовых комментариев к пинам
 * - Добавлением emoji в комментарии
 * - Проверкой отображения комментария
 */
public class CommentPinTest extends BaseTest {

    private static final String PROPERTY_EMAIL = "email";
    private static final String PROPERTY_PASSWORD = "password";
    private static final String PIN_COMMENT = " Тестовый комментарий";

    /**
     * Тестирует процесс добавления комментария к пину:
     * 1. Авторизация пользователя
     * 2. Переход в профиль
     * 3. Выбор раздела "Созданные мной"
     * 4. Добавление текстового комментария
     * 5. Добавление emoji к комментарию
     * 6. Отправка комментария
     * 7. Проверка отображения комментария
     *
     * Шаги теста:
     * - Получение учетных данных из конфигурации
     * - Выполнение входа в систему
     * - Переход на страницу профиля
     * - Фильтрация пинов по "Созданные мной"
     * - Выбор конкретного пина
     * - Ввод текста комментария
     * - Добавление emoji
     * - Отправка комментария
     * - Проверка отображения комментария под пином
     */
    @Test
    public void testCommentPin() {
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
        accountPage.writeComment(PIN_COMMENT);
        accountPage.clickChooseEmoji();
        accountPage.chooseEmoji();
        accountPage.sendComment();
        assert accountPage.checkCommentSend(PIN_COMMENT);
    }
}