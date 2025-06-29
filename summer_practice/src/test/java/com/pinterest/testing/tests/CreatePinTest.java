package com.pinterest.testing.tests;

import com.pinterest.testing.BaseTest;
import com.pinterest.testing.pages.HomePage;
import com.pinterest.testing.pages.LoginPage;
import com.pinterest.testing.pages.PinCreationPage;
import org.junit.jupiter.api.Test;

public class CreatePinTest extends BaseTest {

    @Test
    public void testCreatePin() {
        new LoginPage().login("kasej77361@coasah.com", "Test!12345");
        HomePage home = new HomePage();
        home.openPinCreation();

        PinCreationPage creationPage = new PinCreationPage();
        creationPage.uploadImage("flower.jpg");
        creationPage.setTitle("Тестовый пин");
        creationPage.publish();
    }
}
