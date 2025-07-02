package com.pinterest.testing.tests;

import com.pinterest.testing.BaseTest;
import com.pinterest.testing.pages.HomePage;
import com.pinterest.testing.pages.LoginPage;
import com.pinterest.testing.pages.PinCreationPage;
import org.junit.jupiter.api.Test;

public class CreatePinTest extends BaseTest {

    private static final String IMAGE_NAME = "flower.jpg";
    private static final String PIN_TITLE = "Тестовый пин";
    private static final String PROPERTY_EMAIL = "email";
    private static final String PROPERTY_PASSWORD = "password";

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