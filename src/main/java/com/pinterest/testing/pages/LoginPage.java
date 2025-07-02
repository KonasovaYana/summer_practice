package com.pinterest.testing.pages;
import com.pinterest.testing.elements.Button;
import com.pinterest.testing.elements.Input;

public class LoginPage extends BasePage {

    public LoginPage() {super(byDataTestId("simple-login"));}

    private final Button enterButton =
            Button.byButtonPhraseInXpathCreate("Войти");
    private final Input emailField =
            Input.byInputNameCreate("id");
    private final Input passwordField =
            Input.byInputNameCreate("password");
    private final Button loginButton =
            Button.byButtonTypeCreate("submit");

    public void clickEnterButton() {
        enterButton.click("Войти");
    }

    public void enterEmailField(String email) {
        emailField.setValue("Email", email);
    }

    public void enterPasswordField(String password) {
        passwordField.setValue("Password", password);
    }

    public void clickLoginButton() {
        loginButton.click("Войти");
    }
}
