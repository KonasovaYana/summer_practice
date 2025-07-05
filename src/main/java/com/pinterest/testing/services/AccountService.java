package com.pinterest.testing.services;

import com.pinterest.testing.pages.AccountPage;
import com.pinterest.testing.pages.HomePage;

/**
 * Сервисный класс для работы с пинами в аккаунте пользователя.
 * Инкапсулирует логику взаимодействия с пользовательскими пинами.
 */
public class AccountService {

    private final AccountPage accountPage;

    /**
     * Инициализирует сервис работы с аккаунтом.
     * @param homePage экземпляр домашней страницы для перехода в аккаунт
     */
    public AccountService(HomePage homePage) {
        this.accountPage = homePage.openAccountPage();
    }

    /**
     * Открывает раздел "Пины" в аккаунте пользователя.
     * @return текущий экземпляр AccountService
     */
    public AccountService openPinsSection() {
        accountPage.choosePins();
        return this;
    }

    /**
     * Фильтрует пины, показывая только созданные пользователем.
     * @return текущий экземпляр AccountService
     */
    public AccountService filterCreatedPins() {
        accountPage.chooseMadeByMe();
        return this;
    }

    /**
     * Выбирает конкретный пин из списка.
     * @return текущий экземпляр AccountService
     */
    public AccountService selectPin() {
        accountPage.choosePin();
        return this;
    }

    /**
     * Выполняет переход к созданным пинам (комбинация открытия раздела и фильтрации).
     * @return текущий экземпляр AccountService
     */
    public AccountService navigateToCreatedPins() {
        return this.openPinsSection().filterCreatedPins();
    }

    /**
     * Полный сценарий работы с созданными пинами.
     * @return текущий экземпляр AccountService
     */
    public AccountService fullPinWorkflow() {
        return this.navigateToCreatedPins().selectPin();
    }

}