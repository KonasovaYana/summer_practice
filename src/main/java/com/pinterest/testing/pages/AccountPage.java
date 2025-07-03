package com.pinterest.testing.pages;
import com.pinterest.testing.elements.Button;
import com.pinterest.testing.elements.Input;

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
//    private final Button createSmthButton = Button.byAriaLabelCreate("Создать пин или доску");
//    private final Button createBoardButton = Button.byButtonIdCreate("Create board");
//    private final Input boardName = Input.byInputIdCreate("boardEditName");
//    private final Button createNamedBoardButton = Button.byButtonIdCreate("board-form-submit-button");
//    private final Button openHomePageButton = Button.byIdAndACreate("home-tab");


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
        return(FavouritesButton.isDisplayed("Удалить из избранного"));
    }

    public void choosePins() {
        choosePinsButton.click("Пины");
    }

    public void chooseFavourites() {
        chooseFavouritesButton.click("Избранное");
    }

    public void chooseMadeByMe() {
        chooseMadeByMeButton.click("Созданные мной");
    }

    public void choosePin() {
        choosePinButton.click("Первый пин");
    }

    public void chooseLikePin() {
        chooseLikePinButton.click("Отреагировать");
    }

    public boolean checkLikePin() {
        return LikeButton.isDisplayed("Мне нравится!");
    }
//    public void createNew(){
//        createSmthButton.click("Создать");
//    }
//
//    public void createNewBoard(){
//        createBoardButton.click("Доска");
//    }
//
//    public void enterBoardName(String name){
//        boardName.setValue("Название", name);
//    }
//
//    public void createNewNamedBoard(){
//        createNamedBoardButton.click("Создать");
//    }
//
//    public void openHomePage(){
//        openHomePageButton.click("Домашняя страница");
//    }
}