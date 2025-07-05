package com.pinterest.testing.tests;

import com.pinterest.testing.BaseTest;
import com.pinterest.testing.pages.HomePage;
import com.pinterest.testing.pages.PinCreationPage;
import org.junit.jupiter.api.Test;

/**
 * Тестовый класс для проверки функционала создания новых пинов.
 */
public class CreatePinTest extends BaseTest {

    private static final String IMAGE_NAME = "flower.jpg";
    private static final String PIN_TITLE = "Тестовый пин";

    /**
     * Метод тестирует полный процесс создания нового пина:
     * переходит на страницу создания пина, загружает изображение,
     * добавляет название пина и публикует его.
     */
    @Test
    public void testCreatePin() {
        HomePage home = loginService()
                .openLoginForm()
                .enterCredentials(getProperty(PROPERTY_EMAIL),getProperty(PROPERTY_PASSWORD))
                .submitLogin();
        PinCreationPage creationPage = home.openPinCreation();
        creationPage.uploadImage(IMAGE_NAME);
        creationPage.setTitle(PIN_TITLE);
        creationPage.publish();
        assert creationPage.isPublished();
    }
}