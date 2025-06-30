package com.pinterest.testing.pages;
import com.pinterest.testing.elements.Button;
import com.pinterest.testing.elements.Input;
import static com.codeborne.selenide.Selenide.$x;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HomePage extends BasePage {
    private static final Logger logger = LoggerFactory.getLogger(LoginPage.class);
    public HomePage() {
        super($x("//div[contains(@data-test-id, 'header')]"));
    }
    private final Button openPinCreationButton = Button.createByXpath("//a[@data-test-id=\"create-tab\" and @href=\"/pin-creation-tool/\"]");
    public void openPinCreation() {
        logger.info("Открытие страницы создания пина");
        openPinCreationButton.click();
    }
    private final Button openAccountPageButton = Button.createByXpath("//a[@aria-label=\"Профиль\" and @href=\"/sellithu/\"]");
    public void openAccountPage() {
        logger.info("Открытие страницы ваших сохраненных идей");
        openAccountPageButton.click();
    }
    private final Button openFirstPinButton = Button.createByXpath("//div[@data-test-id='pin']//img\n");
    public void openFirstPin() {
        logger.info("Выбираем первый пин в ленте");
        openFirstPinButton.click();
    }
    private final Button sharedAccessButton = Button.createByXpath("//button[@aria-label='Отправить']\n");
    public void sharedAccess() {
        logger.info("Нажимаем на кнопку 'общий доступ'");
        sharedAccessButton.click();
    }

    private final Input userName = Input.createByXpath("//input[@aria-label='Поле поиска']\n");
    public void writeUserName(String title) {
        logger.info("Вводим имя пользователя");
        userName.setValue(title);
    }

    private final Button sendPinButton = Button.createByXpath("//button[@data-test-id='sharesheet-contact-send-button']\n");
    public void sendPin() {
        logger.info("Отправляем пин выбранному пользователю");
        sendPinButton.click();
    }

    private final Button openChatButton = Button.createByXpath("//button[@data-test-id='sharesheet-viewchat-button']\n");

    public boolean checkMessage(){
        logger.info("Проверяем, отправилось ли сообщение");
        return openChatButton.isDisplayed();
    }
    public void openChat() {
        logger.info("Переходим в чат с пользователем");
        openChatButton.click();
        com.codeborne.selenide.Selenide.sleep(2000);
    }

}
