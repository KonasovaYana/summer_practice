package com.pinterest.testing.pages;

import com.pinterest.testing.elements.Button;

import static com.codeborne.selenide.Selenide.$x;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private final Button choosePinsButton = Button.createByXpath("//*[@id=\"_pins-profile-tab\"]");
    public void choosePins() {
        logger.info("Выбираем раздел 'пины'");
        choosePinsButton.click();
    }
    private final Button chooseFavouritesButton = Button.createByXpath("//button[@data-test-id=\"favorites_pins_button\"]");
    public void chooseFavourites() {
        logger.info("Выбираем раздел 'избранное'");
        chooseFavouritesButton.click();
        com.codeborne.selenide.Selenide.sleep(3000);
    }

}