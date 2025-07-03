package com.pinterest.testing.pages;
import com.pinterest.testing.elements.Button;
import com.pinterest.testing.elements.Input;

public class HomePage extends BasePage {

    public HomePage() {super(byDataTestId("header"));}

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

    public void openPinCreation() {
        openPinCreationButton.click("Создать");
    }

    public void openAccountPage() {
        openAccountPageButton.click("Профиль");
    }

    public void openFirstPin() {
        openFirstPinButton.click("Первый пин в ленте");
    }

    public void sharedAccess() {
        sharedAccessButton.click("Общий доступ");
    }

    public void writeUserName(String title) {;
        userName.setValue("Вводим имя пользователя", title);
    }

    public void sendPin() {
        sendPinButton.click("Отправить");
    }

    public boolean checkMessage(){;
        return openChatButton.isDisplayed("См. чат");
    }

    public void openChat() {
        openChatButton.click("См. чат");
    }

    public void profile(){
        profileButton.click("Профиль");
    }

    public void createBoard(){
        createBoardButton.click("Создать доску");
    }

    public void enterBoardName(String title) {;
        boardName.setValue("Название", title);
    }

    public void addBoard(){
        addBoardButton.click("Создать");
    }

    public boolean checkSavedPin() {
        return SavedPinButton.isDisplayed("Сохранено");
    }

    public void chooseOtherActions() {
        chooseOtherActionsButton.click("Другие действия");
    }

    public void makePinHidden() {
        makePinHiddenButton.click("Скрыть пин");
    }

    public void reasonPinHidden() {
        reasonPinHiddenButton.click("Другое");
    }

    public boolean checkHidden(){
        return(confirmHideButton.isDisplayed("Отмена"));
    }

    public void writeQuery(String query) {
        searchInput.setValue("Поиск", query);
    }

    public void searchPins() {
        searchInput.pressEnter();
    }

}