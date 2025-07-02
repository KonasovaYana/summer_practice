package com.pinterest.testing.pages;

import com.pinterest.testing.elements.Button;
import static com.codeborne.selenide.Selenide.$x;

import com.pinterest.testing.elements.Input;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.codeborne.selenide.Condition;
public class AccountPage extends BasePage {
    private static final Logger logger = LoggerFactory.getLogger(LoginPage.class);
    public AccountPage() {
        super($x("//div[contains(@data-test-id,'sellithu')]"));
    }
    private final Button chooseBoardsButton = Button.createByXpath("//*[@id=\"_boards-profile-tab\"]");
    public void chooseBoards() {
        logger.info("Выбираем раздел 'доски'");
        chooseBoardsButton.click();
    }
    private final Button chooseFirstBoardsButton = Button.createByXpath("(//div[@role=\"listitem\"])[1]//a\n");
    public void chooseFirstBoards() {
        logger.info("Выбираем первую доску");
        chooseFirstBoardsButton.click();
    }

    private final Button chooseFirstPinButton = Button.createByXpath("(//div[@data-test-id='pinrep-image']//img[contains(@class, 'hCL')])[1]\n");
    public void chooseFirstPinBoards() {
        logger.info("Выбираем первый пин в доске");
        chooseFirstPinButton.click();
    }
    private final Button makePinFavouriteButton = Button.createByXpath("//button[@data-test-id='favorite-button-star']\n");
    public void makePinFavourite() {
        logger.info("Добавляем пин в избранное");
        makePinFavouriteButton.click();
    }

    private final Button FavouritesButton = Button.createByXpath(".//div[text()='Удалить из избранного']");
    public boolean checkFavourites(){
        logger.info("Проверяем, добавлен ли элемент в избранное");
        com.codeborne.selenide.Selenide.sleep(1000);
        return(FavouritesButton.isDisplayed());
    }
    private final Button choosePinsButton = Button.createByXpath("//*[@id=\"_pins-profile-tab\"]");
    public void choosePins() {
        logger.info("Выбираем раздел 'пины'");
        choosePinsButton.click();
    }
    private final Button chooseFavouritesButton = Button.createByXpath("//button[@data-test-id=\"favorites_pins_button\"]");
    public void chooseFavourites() {
        logger.info("Выбираем раздел 'избранное'");
        chooseFavouritesButton.click();
        com.codeborne.selenide.Selenide.sleep(1000);
    }
    private final Button chooseMadeByMeButton = Button.createByXpath("//button[@data-test-id=\"created_by_you_button\"]");
    public void chooseMadeByMe() {
        logger.info("Выбираем раздел 'Созданные мной'");
        chooseMadeByMeButton.click();
    }
    private final Button choosePinButton = Button.createByXpath("//div[@data-grid-item-idx=\"0\"]//img");
    public void choosePin() {
        logger.info("Выбираем первый пин из раздела");
        choosePinButton.click();
    }
    private final Button chooseLikePinButton = Button.createByXpath("//button[@aria-label=\"Отреагировать\"]");
    public void chooseLikePin() {
        logger.info("Ставим лайк на пин");
        chooseLikePinButton.click();
        com.codeborne.selenide.Selenide.sleep(1000);
    }
    private final Button LikeButton = Button.createByXpath(".//div[text()='Мне нравится!']");
    public boolean checkLikePin() {
        logger.info("Проверяем поставлен ли лайк");
        return LikeButton.isDisplayed();
    }
    private final Button chooseNewBoardButton = Button.createByXpath("//button[.//div[text()=\"Создать доску\"]]");
    public void chooseNewBoard() {
        logger.info("Создаем новую доску");
        chooseNewBoardButton.click();
        com.codeborne.selenide.Selenide.sleep(1000);
    }
    private final Input NewBoardField = Input.createByXpath("//input[@placeholder=\"Например, «Куда пойти?» или «Рецепты»\"]\n");
    private final Button NewBoardAcceptButton = Button.createByXpath("//button[.//div[text()=\"Создать\"]]");
    public void WriteNameNewBoard() {
        logger.info("Вводим названия для новой доски");
        NewBoardField.setValue("Цветы");
        NewBoardAcceptButton.click();
        com.codeborne.selenide.Selenide.sleep(1000);
    }
}