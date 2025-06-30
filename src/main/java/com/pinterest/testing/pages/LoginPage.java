package com.pinterest.testing.pages;

import com.pinterest.testing.elements.Button;
import com.pinterest.testing.elements.Input;

import static com.codeborne.selenide.Selenide.$x;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginPage extends BasePage {
    private static final Logger logger = LoggerFactory.getLogger(LoginPage.class);

    public LoginPage() {
        super($x("//div[@data-test-id='simple-login']"));
    }

    private final Button enterButton =
            Button.createByXpath("//button[.//div[text()='Войти']]");
    private final Input emailField =
            Input.createByXpath("//input[@name='id']");
    private final Input passwordField =
            Input.createByXpath("//input[@name='password']");
    private final Button loginButton =
            Button.createByXpath("//button[@type='submit']");

    public void login(String email, String password) {
        logger.info("Логин с email: {}", email);
        enterButton.click();
        emailField.setValue(email);
        passwordField.setValue(password);
        loginButton.click();
        logger.info("Кнопка входа нажата");
    }
}
