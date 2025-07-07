package com.pinterest.testing.pages;
import com.pinterest.testing.elements.Button;
import com.pinterest.testing.elements.Input;

/**
 * Класс, представляющий домашнюю страницу Pinterest.
 * Содержит методы для взаимодействия с основными элементами главной страницы,
 * включая создание пинов, поиск, управление досками и другие функции.
 */
public class HomePage extends BasePage {

    private final Button openPinCreationButton = Button.byIdAndHrefCreate("create-tab", "/pin-creation-tool/");
    private final Button openAccountPageButton = Button.byIdAndLabelCreate("header-profile","Профиль");
    private final Button openFirstPinButton = Button.byXpathCreate("//div[@data-grid-item-idx=\"0\"]//img");
    private final Button sharedAccessButton = Button.byAriaLabelCreate("Отправить");
    private final Input userName = Input.byAriaLabelCreate("Поле поиска");
    private final Button sendPinButton = Button.byButtonIdCreate("sharesheet-contact-send-button");
    private final Button openChatButton = Button.byButtonIdCreate("sharesheet-viewchat-button");
    private final Button profileButton = Button.byButtonIdCreate("PinBetterSaveDropdown");
    private final Button createBoardButton = Button.byPhraseInXpathCreate("Создать доску");
    private final Input boardName = Input.byInputIdCreate("boardEditName");
    private final Button addBoardButton = Button.byPhraseInXpathCreate("Создать");
    private final Button SavedPinButton = Button.byPhraseInXpathCreate("Сохранено");
    private final Button chooseOtherActionsButton = Button.byAriaLabelCreate("Другие действия");
    private final Button makePinHiddenButton = Button.byButtonIdCreate("pin-action-dropdown-hide");
    private final Button reasonPinHiddenButton = Button.bySpanTextCreate("Другое");
    private final Button confirmHideButton = Button.byPhraseInXpathCreate("Отмена");
    private final Input searchInput = Input.byAriaLabelCreate("Поиск");
    private final Button homeButton = Button.byIdAndHrefCreate("home-tab", "/");
    private final Button searchResultButton = Button.byTextContainCreate("flowers");

    /**
     * Конструктор домашней страницы.
     * Инициализирует страницу с использованием локатора заголовка.
     */
    public HomePage() {super(byDataTestId("header"));}

    /**
     * Открывает инструмент создания нового пина
     * и создает новую страницу PinCreationPage.
     */
    public PinCreationPage openPinCreation() {
        openPinCreationButton.click("Создать");
        return new PinCreationPage();
    }

    /**
     * Открывает страницу профиля пользователя
     * и создает новую страницу AccountPage.
     */
    public AccountPage openAccountPage() {
        openAccountPageButton.click("Профиль");
        return new AccountPage();
    }

    /**
     * Открывает первый пин в ленте.
     */
    public void openFirstPin() {
        openFirstPinButton.click("Первый пин в ленте");
    }

    /**
     * Открывает меню общего доступа для текущего пина.
     */
    public void sharedAccess() {
        sharedAccessButton.click("Общий доступ");
    }

    /**
     * Вводит имя пользователя в поле поиска.
     * @param title имя пользователя для поиска
     */
    public void writeUserName(String title) {
        userName.setValue("Вводим имя пользователя", title);
    }

    /**
     * Отправляет пин выбранному пользователю.
     */
    public void sendPin() {
        sendPinButton.click("Отправить");
    }

    /**
     * Проверяет наличие кнопки перехода к чату.
     * @return true если кнопка "См. чат" отображается, иначе false
     */
    public boolean checkMessage(){
        return openChatButton.isDisplayed("См. чат");
    }

    /**
     * Открывает выбор доски для сохранения.
     */
    public void profile(){
        profileButton.click("Профиль");
    }

    /**
     * Начинает процесс создания новой доски.
     */
    public void createBoard(){
        createBoardButton.click("Создать доску");
    }

    /**
     * Вводит название для новой доски.
     * @param title название доски
     */
    public void enterBoardName(String title) {
        boardName.setValue("Название", title);
    }

    /**
     * Завершает создание новой доски.
     */
    public void addBoard(){
        addBoardButton.click("Создать");
    }

    /**
     * Проверяет, сохранен ли пин.
     * @return true если текст "Сохранено" отображается, иначе false
     */
    public boolean checkSavedPin() {
        return SavedPinButton.isDisplayed("Сохранено");
    }

    /**
     * Открывает меню дополнительных действий для пина.
     */
    public void chooseOtherActions() {
        chooseOtherActionsButton.click("Другие действия");
    }

    /**
     * Скрывает текущий пин.
     */
    public void makePinHidden() {
        makePinHiddenButton.click("Скрыть пин");
    }

    /**
     * Выбирает причину скрытия пина ("Другое").
     */
    public void reasonPinHidden() {
        reasonPinHiddenButton.click("Другое");
    }

    /**
     * Проверяет, скрыт ли пин.
     * @return true если кнопка "Отмена" отображается, иначе false
     */
    public boolean checkHidden(){
        return(confirmHideButton.isDisplayed("Отмена"));
    }

    /**
     * Вводит поисковый запрос.
     * @param query текст поискового запроса
     */
    public void writeQuery(String query) {
        searchInput.setValue("Поиск", query);
    }

    /**
     * Выполняет поиск по введенному запросу.
     */
    public void searchPins() {
        searchInput.pressEnter();
    }

    /**
     * Обновляет домашюю страницу.
     */
    public void openHomePage() {
        homeButton.click("Главная");
    }

    /**
     * Открывает поле поиска пинов по определенному запросу.
     */
    public void openSearch() {
        searchInput.click("Поиск");
    }

    /**
     * Проверяет наличие определенного запроса.
     */
    public boolean checkSearchHistory(){
        return(searchResultButton.isDisplayed("flowers"));
    }
}