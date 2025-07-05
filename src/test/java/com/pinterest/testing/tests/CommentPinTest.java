package com.pinterest.testing.tests;

import com.pinterest.testing.BaseTest;
import com.pinterest.testing.pages.AccountPage;
import com.pinterest.testing.pages.HomePage;
import com.pinterest.testing.pages.LoginPage;
import org.junit.jupiter.api.Test;

/**
 * Тестовый класс для проверки функционала комментирования пинов.
 */
public class CommentPinTest extends BaseTest {

    private static final String PROPERTY_EMAIL = "email";
    private static final String PROPERTY_PASSWORD = "password";
    private static final String PIN_COMMENT = " Тестовый комментарий";

    /**
     * Метод тестирует процесс добавления комментария к пину:
     * выбирает последний сохраненный пин и добавляет к нему
     * комментарий из букв и эмодзи.
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