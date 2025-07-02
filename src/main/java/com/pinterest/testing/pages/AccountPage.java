package com.pinterest.testing.pages;
import com.pinterest.testing.elements.Button;
public class AccountPage extends BasePage {

    public AccountPage() {super(byDataTestId("header-profile"));}

    private final Button chooseBoardsButton = Button.byIdCreate("_boards-profile-tab");
    private final Button chooseFirstBoardsButton = Button.byRoleCreate("listitem");
    private final Button chooseFirstPinButton = Button.byXpathCreate("(//div[@data-test-id='pinrep-image']//img[contains(@class, 'hCL')])[1]\n");
    private final Button makePinFavouriteButton = Button.byButtonIdCreate("favorite-button-star");
    private final Button FavouritesButton = Button.byPhraseInXpathCreate("Удалить из избранного");
    private final Button choosePinsButton = Button.byIdCreate("_pins-profile-tab");
    private final Button chooseFavouritesButton = Button.byButtonIdCreate("favorites_pins_button");
    private final Button chooseMadeByMeButton = Button.byButtonIdCreate("created_by_you_button");
    private final Button choosePinButton = Button.byGridIdCreate("0");
    private final Button chooseLikePinButton = Button.byAriaLabelCreate("Отреагировать");
    private final Button LikeButton = Button.byPhraseInXpathCreate("Мне нравится!");

    public void chooseBoards() {
        chooseBoardsButton.click("Доски");
    }

    public void chooseFirstBoards() {
        chooseFirstBoardsButton.click("Первая доска");
    }

    public void chooseFirstPinBoards() {
        chooseFirstPinButton.click("Первый пин");
    }

    public void makePinFavourite() {
        makePinFavouriteButton.click("Добавить в избранное");
    }

    public boolean checkFavourites(){
        com.codeborne.selenide.Selenide.sleep(1000);
        return(FavouritesButton.isDisplayed("Удалить из избранного"));
    }

    public void choosePins() {
        choosePinsButton.click("Пины");
    }

    public void chooseFavourites() {
        chooseFavouritesButton.click("Избранное");
        com.codeborne.selenide.Selenide.sleep(1000);
    }

    public void chooseMadeByMe() {
        chooseMadeByMeButton.click("Созданные мной");
    }

    public void choosePin() {
        choosePinButton.click("Первый пин");
    }

    public void chooseLikePin() {
        chooseLikePinButton.click("Отреагировать");
        com.codeborne.selenide.Selenide.sleep(1000);
    }

    public boolean checkLikePin() {;
        return LikeButton.isDisplayed("Мне нравится!");
    }
}