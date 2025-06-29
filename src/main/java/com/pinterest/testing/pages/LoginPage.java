package com.pinterest.testing.pages;
import com.pinterest.testing.elements.Button;
import com.pinterest.testing.elements.Input;

import static com.codeborne.selenide.Selenide.$x;

public class LoginPage extends BasePage {

    public LoginPage() {
        super($x("//div[@data-test-id='simple-login']"));}
    private final Input emailField =
            new Input(ElementHelper.byXpathPublic("//input[@name='id']"));
    private final Input passwordField =
            new Input(ElementHelper.byXpathPublic("//input[@name='password']"));
    private final Button loginButton =
            new Button(ElementHelper.byXpathPublic("//button[@type='submit']"));

    public void login(String email, String password) {
        emailField.setValue(email);
        passwordField.setValue(password);
        loginButton.click();
    }
}
