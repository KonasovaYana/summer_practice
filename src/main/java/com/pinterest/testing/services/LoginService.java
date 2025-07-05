package com.pinterest.testing.services;

import com.pinterest.testing.pages.HomePage;
import com.pinterest.testing.pages.LoginPage;

/**
 * Сервисный класс для инкапсуляции процесса авторизации.
 */
public class LoginService {
    private final LoginPage loginPage;

    /**
     * Инициализирует новый экземпляр сервиса авторизации.
     * Создает связанный экземпляр LoginPage.
     */
    public LoginService() {
        this.loginPage = new LoginPage();
    }

    /**
     * Открывает форму логина на странице.
     * @return текущий экземпляр LoginService
     */
    public LoginService openLoginForm() {
        loginPage.clickEnterButton();
        return this;
    }

    /**
     * Вводит учетные данные (email и пароль) в форму авторизации.
     * @param email email пользователя
     * @param password пароль пользователя
     * @return текущий экземпляр LoginService
     */
    public LoginService enterCredentials(String email, String password) {
        return enterEmail(email).enterPassword(password);
    }

    /**
     * Вводит email в соответствующее поле формы.
     * @param email email пользователя
     * @return текущий экземпляр LoginService
     */
    public LoginService enterEmail(String email) {
        loginPage.enterEmailField(email);
        return this;
    }

    /**
     * Вводит пароль в соответствующее поле формы.
     * @param password пароль пользователя
     * @return текущий экземпляр LoginService
     */
    public LoginService enterPassword(String password) {
        loginPage.enterPasswordField(password);
        return this;
    }

    /**
     * Отправляет форму авторизации и возвращает экземпляр домашней страницы.
     * @return новый экземпляр HomePage после успешного входа
     */
    public HomePage submitLogin() {
        loginPage.clickLoginButton();
        return new HomePage();
    }
}