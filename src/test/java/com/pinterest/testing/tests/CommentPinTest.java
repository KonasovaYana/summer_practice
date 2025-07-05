package com.pinterest.testing.tests;

import com.pinterest.testing.BaseTest;
import com.pinterest.testing.pages.AccountPage;
import com.pinterest.testing.pages.HomePage;
import org.junit.jupiter.api.Test;

/**
 * Тестовый класс для проверки функционала комментирования пинов.
 */
public class CommentPinTest extends BaseTest {

    private static final String PIN_COMMENT = " Тестовый комментарий";

    /**
     * Метод тестирует процесс добавления комментария к пину:
     * выбирает последний сохраненный пин и добавляет к нему
     * комментарий из букв и эмодзи.
     */
    @Test
    public void testCommentPin() {
        HomePage home = loginService()
                .openLoginForm()
                .enterCredentials(getProperty(PROPERTY_EMAIL),getProperty(PROPERTY_PASSWORD))
                .submitLogin();
        AccountPage accountPage = home.openAccountPage();
        accountService(home)
                .navigateToCreatedPins()
                .selectPin();
        accountPage.writeComment(PIN_COMMENT);
        accountPage.clickChooseEmoji();
        accountPage.chooseEmoji();
        accountPage.sendComment();
        assert accountPage.checkCommentSend(PIN_COMMENT);
    }
}