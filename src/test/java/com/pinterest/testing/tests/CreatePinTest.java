package com.pinterest.testing.tests;

import com.pinterest.testing.BaseTest;
import com.pinterest.testing.pages.HomePage;
import com.pinterest.testing.pages.LoginPage;
import com.pinterest.testing.pages.PinCreationPage;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class CreatePinTest extends BaseTest {
    private String getProperty(String key) {
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("account.properties")) {
            Properties props = new Properties();
            if (input == null) {
                throw new RuntimeException("account.properties not found");
            }
            props.load(input);
            return props.getProperty(key);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load account properties", e);
        }
    }
    @Test

    public void testCreatePin() {
        String email = getProperty("email");
        String password = getProperty("password");
        new LoginPage().login(email, password);
        HomePage home = new HomePage();
        home.openPinCreation();
        PinCreationPage creationPage = new PinCreationPage();
        creationPage.uploadImage("flower.jpg");
        creationPage.setTitle("Тестовый пин");
        creationPage.publish();
        creationPage.goToPublishedPin();

    }
}