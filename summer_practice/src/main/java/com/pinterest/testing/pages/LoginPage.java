package com.pinterest.testing.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class LoginPage extends BasePage {

    public LoginPage() {
        super($x("//div[@data-test-id='simple-login']")); // пример
    }
    private final SelenideElement emailField = $x("//input[@name='id']");
    private final SelenideElement passwordField = $x("//input[@name='password']");
    private final SelenideElement loginButton = $x("//button[@type='submit']");

    public void login(String email, String password) {
        emailField.setValue(email);
        passwordField.setValue(password);
        loginButton.click();
    }
}
