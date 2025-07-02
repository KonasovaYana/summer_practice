package com.pinterest.testing.pages;
import com.pinterest.testing.elements.Button;
import com.pinterest.testing.elements.Input;

public class HomePage extends BasePage {

    public HomePage() {super(byDataTestId("header"));}

    private final Button openPinCreationButton = Button.byIdAndHrefCreate("create-tab", "/pin-creation-tool/");
    private final Button openAccountPageButton = Button.byIdAndLabelCreate("header-profile","Профиль");
    private final Button openFirstPinButton = Button.byXpathCreate("//div[@data-test-id='pin']//img\n");
    private final Button sharedAccessButton = Button.byAriaLabelCreate("Отправить");
    private final Input userName = Input.byAriaLabelCreate("Поле поиска");
    private final Button sendPinButton = Button.byButtonIdCreate("sharesheet-contact-send-button");
    private final Button openChatButton = Button.byButtonIdCreate("sharesheet-viewchat-button");

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
        com.codeborne.selenide.Selenide.sleep(2000);
    }
}
