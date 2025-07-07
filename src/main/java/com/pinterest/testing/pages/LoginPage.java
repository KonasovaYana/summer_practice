package com.pinterest.testing.pages;
import com.pinterest.testing.elements.Button;
import com.pinterest.testing.elements.Input;

/**
 * Класс страницы авторизации Pinterest.
 * Предоставляет методы для взаимодействия с элементами формы входа,
 * включая ввод учетных данных и выполнение входа в систему.
 */
public class LoginPage extends BasePage {

    private final Button enterButton =
            Button.byButtonPhraseInXpathCreate("Войти");
    private final Input emailField =
            Input.byInputNameCreate("id");
    private final Input passwordField =
            Input.byInputNameCreate("password");
    private final Button loginButton =
            Button.byButtonTypeCreate("submit");

    /**
     * Конструктор страницы авторизации.
     * Инициализирует страницу с использованием локатора формы входа.
     */
    public LoginPage() {super(byDataTestId("simple-login"));}

    /**
     * Нажимает кнопку "Войти" для перехода к форме авторизации.
     */
    public void clickEnterButton() {
        enterButton.click("Войти");
    }

    /**
     * Вводит email/логин в соответствующее поле формы.
     * @param email email или логин пользователя для авторизации
     */
    public void enterEmailField(String email) {
        emailField.setValue("Email", email);
    }

    /**
     * Вводит пароль в соответствующее поле формы.
     * @param password пароль пользователя для авторизации
     */
    public void enterPasswordField(String password) {
        passwordField.setValue("Password", password);
    }

    /**
     * Нажимает кнопку подтверждения входа после ввода учетных данных.
     */
    public void clickLoginButton() {
        loginButton.click("Войти");
    }

}