package com.pinterest.testing.tests;

import com.pinterest.testing.BaseTest;
import com.pinterest.testing.pages.HomePage;
import com.pinterest.testing.pages.LoginPage;
import com.pinterest.testing.pages.PinCreationPage;
import org.junit.jupiter.api.Test;

/**
 * Тестовый класс для проверки функционала создания новых пинов.
 * Содержит тест-кейсы, связанные с:
 * - Созданием нового пина
 * - Загрузкой изображения
 * - Установкой заголовка
 * - Публикацией пина
 * - Проверкой успешности публикации
 */
public class CreatePinTest extends BaseTest {

    private static final String IMAGE_NAME = "flower.jpg";
    private static final String PIN_TITLE = "Тестовый пин";
    private static final String PROPERTY_EMAIL = "email";
    private static final String PROPERTY_PASSWORD = "password";

    /**
     * Тестирует полный процесс создания нового пина:
     * 1. Авторизация пользователя
     * 2. Открытие инструмента создания пина
     * 3. Загрузка изображения
     * 4. Установка заголовка пина
     * 5. Публикация пина
     * 6. Проверка успешности публикации
     * 7. Переход к опубликованному пину
     *
     * Шаги теста:
     * - Получение учетных данных из конфигурации
     * - Выполнение входа в систему
     * - Открытие страницы создания пина
     * - Загрузка тестового изображения
     * - Ввод заголовка пина
     * - Нажатие кнопки публикации
     * - Проверка подтверждения публикации
     * - Переход к созданному пину
     */
    @Test
    public void testCreatePin() {
        String email = getProperty(PROPERTY_EMAIL);
        String password = getProperty(PROPERTY_PASSWORD);
        LoginPage loginPage = new LoginPage();
        loginPage.clickEnterButton();
        loginPage.enterEmailField(email);
        loginPage.enterPasswordField(password);
        loginPage.clickLoginButton();
        HomePage home = new HomePage();
        home.openPinCreation();
        PinCreationPage creationPage = new PinCreationPage();
        creationPage.uploadImage(IMAGE_NAME);
        creationPage.setTitle(PIN_TITLE);
        creationPage.publish();
        assert creationPage.isPublished();
        creationPage.goToPublishedPin();
    }
}